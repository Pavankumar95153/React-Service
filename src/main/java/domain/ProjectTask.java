package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.*;

@Entity
public class ProjectTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Summary can't be blank")
	private String summary;
	private String acceptenceCriteria;
	private String status;
	public ProjectTask() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAcceptenceCriteria() {
		return acceptenceCriteria;
	}
	public void setAcceptenceCriteria(String acceptenceCriteria) {
		this.acceptenceCriteria = acceptenceCriteria;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
}
