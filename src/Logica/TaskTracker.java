package Logica;


import java.util.Scanner;


public class TaskTracker {

	public static void main(String[] args) {
		
		String help = """
	                - add [description] : Add a new task
	                - update [id] [description] : Update a task
	                - delete [id] : Delete a task
	                - mark-todo [id] : Mark a task as to do
	                - mark-in-progress [id] : Mark a task as in progress
	                - mark-done [id] : Mark a task as Done
	                - list : List all tasks
	                """;
		 
		
		Scanner scan = new Scanner(System.in);
		String command;
		System.out.println("Insert a new command");
		
		while(!(command = scan.nextLine()).equals("exit")) {
			switch (command) {
				case "add" -> add(scan);
				case "update" -> updateTask(scan);            					//Update a task
			 	case "delete" -> delete(scan);  							//Delete a task
			 	case "mark-todo" -> updateStatus(command, scan);          	//Mark a task as to do
			 	case "mark-in-progress" -> updateStatus(command, scan);    	//Mark a task as in progress
			 	case "mark-done" -> updateStatus(command, scan); 			//Mark a task as Done
			 	case "list" -> showList();
			    case "list-todo" -> showList(command);
			    case "list-in-progress" -> showList(command);
			    case "list-done" -> showList(command);
			 	case "help" -> help(help);
			}		
		}
		System.out.println("See you next time!");
	}
	
	public static void add(Scanner scan) {
		System.out.println("Insert a name or description for the task");
		String description = scan.nextLine();
		TaskManager.add(description);
		System.out.println("New task added succesfully");
	}
	
	public static void showList() {
		System.out.println("Here is your task list:");
		TaskManager.showList();			
	}
	
	public static void showList(String command) {
		System.out.println("Here is your task list:");
		TaskManager.showList(command);			
	}
	
	public static void delete(Scanner scan) {
		System.out.println("Insert the ID of the task you want to obliterate");
		int ID = scan.nextInt();
		TaskManager.deleteTask(ID);
		System.out.println("Task removed succesfully");
	}
	
	public static void updateStatus(String command, Scanner scan) {
		System.out.println("Insert the ID of the task you want to change the status");
		int taskId = scan.nextInt();  
		TaskManager.updateStatus(taskId, command);
		System.out.println("Task status updated succesfully");
	}
	
	public static void updateTask(Scanner scan) {
		System.out.println("Insert the ID of the task you want to update");
		int taskId = scan.nextInt();  
		scan = new Scanner(System.in);
		System.out.println("Insert the new description for the task");
		String newDescription = scan.nextLine();
		TaskManager.updateTask(taskId, newDescription);
		System.out.println("Task descriptiion updated succesfully");
	}
	
	public static void help(String help) {
		System.out.println(help);
	}
}
