package todolist;

public class Todo {
		
	private String subject;
	private String content;
	private boolean status;
	private String result;
	
	public Todo() {
	}

	public Todo(Todo t) {
		this.subject = t.subject;
		this.content = t.content;
		this.status = t.status;
	}
	
	public Todo(String subject, String content, boolean status) {
		this.subject = subject;
		this.content = content;
		this.status = status;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getStatus() {
		return result = status ? "done" : "pending";
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}
