package com.novare.IndividualProject;

import java.io.*;
import java.util.Random;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.*;

public class ToDoListTest {
    
    public static void main(String args[])
    {
   
    Function_Task task=new Function_Task();
	 
	 Scanner input=new Scanner(System.in);	 
	 int read = 0;
		boolean exit = false;
			

		while (!exit) {
		    
		    //To display Menu List
		    printCommand();
		    //Read the choice value from user between 0 to 4
		    System.out.println("Enter your choices");
		    read = input.nextInt();
		    input.nextLine();
		    //print the Menu
		    switch (read) {
		     // List the tasks
		    case 0:task.createTask();
		         break;
		    case 1: 
			task.readTask();
			break;
	            // Add new task
		    case 2:
			task.writeTask();
			break;
                         //sort the task by projectname			
		    case 3:
			task.sortTaskByProject();
			break;
		       //sort the task by due date
		    case 4:
			task.sortTaskByDueDate();
			break;
	           case 5:task.findATask();
	                break;
	     	
		    case 6:task.removeATask();
		          break;
		    
		    case 7:task.editATask();   
		    	 break;
			
		 default:System.out.println("You entered wrong choice");	
		   	
		    }

		}

	    }
            //to print the menu

	    public static void printCommand() {
		System.out.println("\nWelcome to ToDoList"+
			"\nYou have X tasks todocompleted and Y tasks are done!"+
			 "\n Pick an option:"+
			 "\n Press 1:List the tasks" + 
			 "\n Press 2:Add new task"
			+ "\n Press 3:Sort the tasks by projectname" + 
			"\n Press 4:Sort the tasks by due date"+"\n Press 5:Search for the Task in the file"+"\n Press 6:Remove Task from the list"+"\n Press 7:Edit Task from the list");

	    }
	
	
    }
    
    
    
    


