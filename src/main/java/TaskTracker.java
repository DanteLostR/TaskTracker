
import java.util.Scanner;


public class TaskTracker {

	public static void main(String[] args) {
		 
		
		Scanner scan = new Scanner(System.in);
		String command;
		System.out.println("Insert a new command");
		
		while(!(command = scan.nextLine()).equals("exit")) {
			switch (command) {
			case "add" : add(scan); break;
			case "update" : updateTask(scan);  break;          					//Update a task
		 	case "delete" : delete(scan); break; 							//Delete a task
		 	case "mark-todo" : updateStatusToDo(scan);   break;       	//Mark a task as to do
		 	case "mark-in-progress" : updateStatusInProgress(scan); break;   	//Mark a task as in progress
		 	case "mark-done" : updateStatusDone(scan); 	break;		//Mark a task as Done
		 	case "list" : showList();break;
		    case "list-todo" : showListToDo();break;
		    case "list-in-progress" : showListInProgress();break;
		    case "list-done" : showListDone();break;
		 	case "help" : help();break;
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
	
	public static void showListToDo() {
		System.out.println("Here is your task list:");
		TaskManager.showListToDo();			
	}
	
	public static void showListInProgress() {
		System.out.println("Here is your task list:");
		TaskManager.showListInProgress();			
	}
	
	public static void showListDone() {
		System.out.println("Here is your task list:");
		TaskManager.showListDone();			
	}
	
	public static void delete(Scanner scan) {
		System.out.println("Insert the ID of the task you want to obliterate");
		int ID = scan.nextInt();
		TaskManager.deleteTask(ID);
		System.out.println("Task removed succesfully");
	}
	public static void updateStatusToDo(Scanner scan) {
		System.out.println("Insert the ID of the task you want to change the status");
		int taskId = scan.nextInt();  
		TaskManager.updateStatusToDo(taskId);
		System.out.println("Task status updated succesfully");
	}
	
	public static void updateStatusInProgress(Scanner scan) {
		System.out.println("Insert the ID of the task you want to change the status");
		int taskId = scan.nextInt();  
		TaskManager.updateStatusInProgress(taskId);
		System.out.println("Task status updated succesfully");
	}
	public static void updateStatusDone(Scanner scan) {
		System.out.println("Insert the ID of the task you want to change the status");
		int taskId = scan.nextInt();  
		TaskManager.updateStatusDone(taskId);
		System.out.println("Task status updated succesfully");
	}
	
	public static void updateTask(Scanner scan) {
		System.out.println("Insert the ID of the task you want to update");
		int taskId = scan.nextInt();  
		System.out.println("Insert the new description for the task");
		String newDescription = scan.nextLine();
		TaskManager.updateTask(taskId, newDescription);
		System.out.println("Task descriptiion updated succesfully");
	}
	
	public static void help() {
		System.out.println("""
                - add [description] : Add a new task
                - update [id] [description] : Update a task
                - delete [id] : Delete a task
                - mark-todo [id] : Mark a task as Todo
                - mark-in-progress [id] : Mark a task as In-Progress
                - mark-done [id] : Mark a task as Done
                - list : List all tasks
                - list-todo : List all Todo tasks
                - list-in-progress : List all In-Progress tasks
                - list-done : List all Done tasks
                - exit : Exit the program
                """);
	}
}
