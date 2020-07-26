package web;



import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.ProjectTask;
import service.ProjectTaskSerivce;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {
	
	@Autowired
	private ProjectTaskSerivce projectTaskSerivce;
	
	@PostMapping("")
	public ResponseEntity<?>addPTToBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult result){
		
	if(result.hasErrors()) {
		Map<String,String> errorMap = new HashMap<>();
		for (FieldError error: result.getFieldErrors()) {
			errorMap.put(error.getField(), error.getDefaultMessage());
		}
		return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
	}
		
		ProjectTask newPT= projectTaskSerivce.saveOrUpdateProject(projectTask);
		
		return new ResponseEntity<ProjectTask>(newPT,HttpStatus.CREATED);
		
		
	}

}
