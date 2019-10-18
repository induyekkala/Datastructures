package com.novare.IndividualProject;

import com.novare.IndividualProject.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.jackrutorial.User;

public class TaskManager {

    private Path file_Path = new File("/Users/induyekkala/ToDoList.csv").toPath();
    private Charset charset = Charset.defaultCharset();
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private String filePath = "/Users/induyekkala/ToDoList.csv";
    private FileHandler fileHandler = new FileHandler();
    private ArrayList<UserTask> listOfTasks = new ArrayList<UserTask>();
    private File file_delete = new File(filePath);

    // Sort the Tasks with ProjectName
    public String[] sortProjectName() {

	String[] userTaskArray = { "" };
	try {
	    // reading the data from csv file in string format

	    List<String> taskList = Files.readAllLines(file_Path, charset);
	    taskList.remove(0);
	    // passing into string array as array of strings
	    userTaskArray = taskList.toArray(new String[] {});

	    // Sort the array using projectName
	    Arrays.sort(userTaskArray, new Comparator<String>() {
		public int compare(String firstProjectName, String secondProjectName) {

		    return (firstProjectName.split(",")[4]).compareTo((secondProjectName.split(",")[4]));

		}
	    });

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return userTaskArray;
    }

    // Sort the Tasks with due Date
    public String[] sortDueDate() {

	String[] userTaskArray = { "" };

	try {
	    // Reading the data from csv file in string format
	    List<String> taskList = Files.readAllLines(file_Path, charset);

	    // Removing the header from list
	    taskList.remove(0);

	    // Passing into string array as array of strings
	    userTaskArray = taskList.toArray(new String[] {});

	    // Sort the array using Date
	    Arrays.sort(userTaskArray, new Comparator<String>() {

		// Comparing two string and the method return integer value
		public int compare(String firstTaskDate, String secondTaskDate) {

		    try {
			// Parsing the date to sort in order to day,month and year
			return dateFormat.parse(firstTaskDate.split(",")[2])
				.compareTo(dateFormat.parse(secondTaskDate.split(",")[2]));

		    }
		    // Catching parse exception for date
		    catch (ParseException e) {
			throw new IllegalArgumentException(e);
		    }

		}
	    });

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return userTaskArray;
    }

    public UserTask findTask(String taskTitle) {

	UserTask task = new UserTask();

	try {

	    int i = 0;
	    File file = new File(filePath);
	    BufferedReader read = new BufferedReader(new FileReader(file));
	    String st = "";
	    if (file.length() != 0 ) {

		while ((st = read.readLine()) != null) {
		    if (st.contains(taskTitle)) {

			String fileContent[] = st.split(",");
			task = new UserTask(Integer.parseInt(fileContent[0]), fileContent[1], fileContent[2],
				fileContent[3], fileContent[4]);

			return task;
		    } 

		}

	    } else {
		
		throw new FileNotFoundException();
	    }

	} catch (Exception e) {
	    task=null;
	    System.out.println("File not found exception");
	}
	return null;

    }

    public ArrayList<UserTask> listOfTasks() {
	try {

	    File file = new File(filePath);
	    BufferedReader read = new BufferedReader(new FileReader(file));
	    String st = "";
	    if (file.exists()) {

		while ((st = read.readLine()) != null) {

		    String fileContent[] = st.split(",");

		    if (!st.contains("Id")) {
			UserTask task = new UserTask(Integer.parseInt(fileContent[0]), fileContent[1], fileContent[2],
				fileContent[3], fileContent[4]);
			listOfTasks.add(task);
		    }

		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return listOfTasks;

    }

    public void removeTask(String taskTitle) {

	listOfTasks();

	Iterator<UserTask> iterator = listOfTasks.iterator();
	while (iterator.hasNext()) {

	    if (iterator.next().getTaskTitle().equals(taskTitle)) {
		iterator.remove();

	    }
	}

	file_delete.delete();

	try {
	    fileHandler.writeCsv(filePath, listOfTasks);

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void editTask(String projectName) {

	int i = 0;

	listOfTasks();
	for (UserTask user : listOfTasks) {
	    System.out.println(user.getTaskStatus() + user.getProjectName());
	}
	for (i = 0; i < listOfTasks.size(); i++) {
	    UserTask userTask = listOfTasks.get(i);
	    if (userTask.getProjectName().equals(projectName)) {

		System.out.println(2);

		userTask.setTaskStatus("Done");
		listOfTasks.set(i, userTask);
	    }

	}
	file_delete.delete();

	try {
	    fileHandler.writeCsv(filePath, listOfTasks);

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}