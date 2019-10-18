package com.novare.IndividualProject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import com.novare.IndividualProject.*;

public class Function_Task {

    private String filePath = "/Users/induyekkala/ToDoList.csv";
    private TaskManager taskManager = new TaskManager();
//	 Date format
    private DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private UserTask user = new UserTask();
    private Scanner input = new Scanner(System.in);
    private FileHandler fileHandler = new FileHandler();
    private ArrayList<UserTask> usersTask = new ArrayList<UserTask>();
    public void createTask() {
	fileHandler.createFile(filePath);
    }

    public boolean validateDate(String dateValue) {

	boolean status = false;
	try {
	    Date taskDate = null;
	    taskDate = (Date) formatter.parse(dateValue);

	} catch (ParseException e) {
//	    System.out.println("Please enter date in correct format"+e.getMessage());
	    status = false;
	}
	return status;

    }

    public void writeTask() {

	try {

	    // Enter the title of the task
	    System.out.println("Enter the Task Title");
	    String taskTitle = input.nextLine();
	    System.out.println(" ");
	    // Enter the correct date format
	    System.out.println("Enter the Date in this format DD-MM-YYYY");
	    String taskDate = input.next();
	    input.nextLine();
	    this.validateDate(taskDate);
	    // Intialize date to null
	    Date taskDueDate = null;
	    // parse the date
	    taskDueDate = (Date) formatter.parse(taskDate);
	    // converting date to string format
	    String dueDate = formatter.format(taskDueDate);

	    // Default set task as Not Done
	    user.setTaskStatus("Not Done");
	    String taskStatus = user.getTaskStatus();
	    System.out.println("Enter the Novare SDA Lund,Novare SDA Stockholm are the project lists");

	    String projectName = input.nextLine();

	    // setting the project names
	    String list_projectName[] = { "Novare SDA Lund", "Novare SDA Stockholm" };
	    int line = fileHandler.findLineNumber();

	    if (list_projectName[0].equals(projectName) || list_projectName[1].equals(projectName)) {
		// passing values to constructor
		user = new UserTask(line, taskTitle, dueDate, taskStatus, projectName);
		// Adding Task to the list
		List<UserTask> usersTask = new ArrayList<UserTask>();
		usersTask.add(user);
		fileHandler.writeCsv(filePath, usersTask);
		// writing task to the file
//		 taskManager.writeCsv(filePath);
	    } else {
		System.out.println("check the project names you entered wrong values");

	    }

	    // catching an ParseException for Date.
	} catch (ParseException e) {
	    // e.printStackTrace();
	    System.out.println("Enter the correct date format");

	}

    }

    public void readTask() {

	fileHandler.readCSV(filePath);

    }

    public void sortTaskByProject() {

	String[] userTask = taskManager.sortProjectName();

	System.out.println(
		"TaskId" + "\t" + "TaskTitle" + "\t" + "Task Due Date" + "\t" + "Task Status" + "\t" + "Project Name");

	for (String sortedUserTask : userTask) {

	    System.out.println(sortedUserTask + "\t");
	    System.out.println("\n");
	}

    }
    
   

    public void sortTaskByDueDate() {
	String[] userTask = taskManager.sortDueDate();
	System.out.println("---------------------------------------------------------------------------------------\n");
        System.out.println("TaskId\t\t Task title\t\tTaskDueDate\t    Status\t\tProject Name \n");
        System.out.println("---------------------------------------------------------------------------------------- \n");
	  
       
        
        for (String sortedUserTask : userTask) {
	  
	      System.out.printf(String.format("%20s",sortedUserTask));
	     
	      System.out.println("\n");
	      }
	 

    }

    public boolean findATask() {
	System.out.println("Enter the task title to find");
	String taskTitle = input.nextLine();
	UserTask userTask = taskManager.findTask(taskTitle);
	boolean ret = false;

	if (userTask!= null) {

	    System.out.println("Record in the list is" + "\nTask Id=" + userTask.getTaskId() + "\nTask Title="
		    + userTask.getTaskTitle() + "\nTask Due Date=" + userTask.getTaskDueDate() + "\nTask Status="
		    + userTask.getTaskStatus() + "\nProject Name=" + userTask.getProjectName());
	    ret = true;
	} else {
	    ret = false;
	}

	return ret;
    }

    public void removeATask() {

	System.out.println("Enter the Task to remove from the record");
	String taskTitle = input.next();

	taskManager.removeTask(taskTitle);
    }

    public void removeAProject() {
	System.out.println("Enter the Project to remove from the record");
	String projectName = input.next();

	// taskManager.removeProject(projectName);
    }

    public void editATask() {
	System.out.println("Enter the which Project Name status to be changed ");
	String projectName = input.nextLine();
	taskManager.editTask(projectName);

    }
}