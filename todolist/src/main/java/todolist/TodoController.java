package todolist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
	public List<Todo> datalist = new ArrayList<Todo>();
	@Autowired
	TodoService todoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List> showTodoList() {
		return new ResponseEntity<List>(todoService.showAllTask(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{subject}", method = RequestMethod.GET)
	public ResponseEntity<Todo> showTodoTask(@PathVariable(value = "subject") String subject) {
		return new ResponseEntity<Todo>(todoService.showTask(subject), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Todo> createTask(@RequestBody Todo todo) {
		return new ResponseEntity<Todo>(todoService.createNewTask(todo), HttpStatus.OK);
	}

	@RequestMapping(value = "/setstatus", method = RequestMethod.PUT)
	public ResponseEntity<Todo> setStatus(@RequestParam(value = "subject") String subject,
			@RequestParam(value = "status") boolean status) {
		return new ResponseEntity<Todo>(todoService.setStatus(subject, status), HttpStatus.OK);
	}

	@RequestMapping(value = "/edittask", method = RequestMethod.PUT)
	public ResponseEntity<Todo> editTask(@RequestParam(value = "subject") String subject,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "status") boolean status) {
		return new ResponseEntity<Todo>(todoService.editTask(subject, content,status), HttpStatus.OK);
	}

	@RequestMapping(value = "/{subject}", method = RequestMethod.PUT)
	public void deleteTask(@PathVariable("subject") String subject) {
		todoService.deleteTodo(subject);
	}
//test git
}
