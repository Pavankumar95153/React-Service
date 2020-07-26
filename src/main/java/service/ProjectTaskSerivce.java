package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.ProjectTask;
import repository.ProjectTaskRepository;

@Service
public class ProjectTaskSerivce {
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	public ProjectTask saveOrUpdateProject(ProjectTask  projectTask) {
		
		if (projectTask.getStatus()==null || projectTask.getStatus()=="") {
			projectTask.setStatus("To-Do");
		}
		
		return projectTaskRepository.save(projectTask);
	}

}
