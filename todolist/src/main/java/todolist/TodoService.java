package todolist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	public List<Todo> datalist = new ArrayList<Todo>();

	public TodoService() {
		cratedata();
	}

	public void cratedata() {

		datalist.add(new Todo("Task1", "Contect1", true));
		datalist.add(new Todo("Task2", "Contect2", true));
		datalist.add(new Todo("Task3", "Contect3", true));
		datalist.add(new Todo("Task4", "Contect4", true));
	}

	public List<Todo> showAllTask() {
		return datalist;
	}

	public Todo showTask(String subject) {
		for (Todo todo : datalist) {
			if (todo.getSubject().equals(subject)) {
				return todo;
			}
		}
		return null;
	}

	public Todo createNewTask(Todo subject) {
		datalist.add(new Todo(subject));
		return subject;
	}
	
	public Todo setStatus(String subject, boolean status) {
		for (Todo todo : datalist) {
			if (todo.getSubject().equals(subject)) {
				todo.setStatus(status);
				return todo;
			}
		}
		return null;
	}
	
	public Todo editTask(String subject, String content, boolean status) {
		for (Todo todo : datalist) {
			if (todo.getSubject().equals(subject)) {
				todo.setSubject(subject);
				todo.setContent(content);
				todo.setStatus(status);
				return todo;
			}
		}
		return null;
	}

	public void deleteTodo(String subject) {
		for (Iterator<Todo> iterator = datalist.iterator(); iterator.hasNext();) {
			Todo todo = iterator.next();
			if (todo.getSubject().equals(subject)) {
				// Remove the current element from the iterator and the list.
				iterator.remove();
			}
		}
	}

}
