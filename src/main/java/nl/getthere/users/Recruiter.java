package nl.getthere.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Recruiter extends User {
	
	@NotEmpty(message="Geef een gebruikersnaam op voor de nieuwe recruiter.")
	private String recruiterName;
	private String recruiterPass;
	private Long id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
	    return id;
	}
	
	public void setId(Long id){
	    this.id = id;
	}
	
	public Recruiter() {}
	
	public Recruiter(String recruiterName, String recruiterPass, String confirm){
		this.recruiterName = recruiterName;
		this.recruiterPass = recruiterPass;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getRecruiterPass() {
		return recruiterPass;
	}

	public void setRecruiterPass(String recruiterPass) {
		this.recruiterPass = recruiterPass;
	}
}