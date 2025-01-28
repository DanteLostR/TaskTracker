package Logica;
import java.util.ArrayList;


public class TaskManager {
	
	protected static ArrayList<Task> taskList = new ArrayList<Task>();
	protected static int lastIdUsed = 0;
	
	public static void add(String description) {
		Task task = new Task(description);
		taskList.add(task);
		lastIdUsed += 1;
	}

	public static void showList() {
		for(int i = 0; i < taskList.size(); i++){
			Task task = taskList.get(i);
			System.out.println(task.getName() + "  ||  " + task.getStatus() + "  ||  " + task.getId());		
		}	
	}
	
	public static void showList(String originalCommand) {
		String shortCommand = getOption(originalCommand);
		for(int i = 0; i < taskList.size(); i++){
			Task task = taskList.get(i);
			if (task.getStatus().equals(shortCommand)) {
				System.out.println(task.getName() + "  ||  " + task.getStatus() + "  ||  " + task.getId());
			}
		}
	}
	
	public static String getOption(String command){
		String aux = "";
		for(int i = 5; i < command.length(); i++){
			aux += command.charAt(i);
		}
		return aux;
	}
	
	public static void updateTask(int taskId, String newDescription) {
		for(int i = 0; i < taskList.size(); i++){
			Task task = taskList.get(i);
			if (task.getId() == taskId) {
				task.setDescription(newDescription);
			}
		}
	}
	public static void updateStatus(int taskId, String originalCommand) {
		String shortCommand = getOption(originalCommand);
		for(int i = 0; i < taskList.size(); i++){
			Task task = taskList.get(i);
			if (task.getId() == taskId) {
				task.setStatus(shortCommand);
			}
		}
	}
	
	public static void deleteTask(int id) {
		taskList.remove(id);
	}
	
	public static int newID(){
		return lastIdUsed;
	}

}
