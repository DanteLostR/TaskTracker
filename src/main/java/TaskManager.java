import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TaskManager {
	
	protected static ArrayList<Task> taskList = new ArrayList<Task>();
	protected static int lastIdUsed = 0;
	
	ObjectMapper objectMapper = new ObjectMapper();
	File tasksFile = new File("./data/tasks.json");
	
	public void fromJsonToString() throws JsonParseException, JsonMappingException, IOException {
		Task task = objectMapper.readValue(tasksFile, Task.class);
		taskList.add(task);
	}
	
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
	
	public static void showListToDo() {
		for(int i = 0; i < taskList.size(); i++){
			Task task = taskList.get(i);
			if (task.getStatus().equals("to do")) {
				System.out.println(task.getName() + "  ||  " + task.getStatus() + "  ||  " + task.getId());
			}
		}
	}
	
	public static void showListInProgress() {
		for(int i = 0; i < taskList.size(); i++){
			Task task = taskList.get(i);
			if (task.getStatus().equals("in progress")) {
				System.out.println(task.getName() + "  ||  " + task.getStatus() + "  ||  " + task.getId());
			}
		}
	}
	
	public static void showListDone() {
		for(int i = 0; i < taskList.size(); i++){
			Task task = taskList.get(i);
			if (task.getStatus().equals("done")) {
				System.out.println(task.getName() + "  ||  " + task.getStatus() + "  ||  " + task.getId());
			}
		}
	}
	
	public static void updateTask(Integer taskId, String newDescription) {
		for(int i = 0; i < taskList.size(); i++){
			Task task = taskList.get(i);
			if (task.getId() == taskId) {
				task.setDescription(newDescription);
			}
		}
	}
	
	public static void updateStatusToDo(int taskId) {
		for(int i = 0; i < taskList.size(); i++){
			Task task = taskList.get(i);
			if (task.getId() == taskId) {
				task.setStatus("to do");
			}
		}
	}
	
	public static void updateStatusInProgress(int taskId) {
		for(int i = 0; i < taskList.size(); i++){
			Task task = taskList.get(i);
			if (task.getId() == taskId) {
				task.setStatus("in progress");
			}
		}
	}
	
	public static void updateStatusDone(int taskId) {
		for(int i = 0; i < taskList.size(); i++){
			Task task = taskList.get(i);
			if (task.getId() == taskId) {
				task.setStatus("done");
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