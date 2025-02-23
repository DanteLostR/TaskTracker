
import java.time.LocalDateTime;


//import java.time.format.DateTimeFormatter;


public class Task {

	protected int id;
	protected String description;
	protected String status;
	protected LocalDateTime createdAt;
	protected LocalDateTime updatedAt;
	
	
	
	public Task(String name) {
		this.description = name;
		this.id = getNewID();
		this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
		this.status = "todo";
	}	
	
	

	public void setDescription(String newDescription) {
		this.description = newDescription;
	}
	
	public static int getNewID() {
		return TaskManager.newID();
	}
	
	public String getName() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String newStatus) {
		this.status = newStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}