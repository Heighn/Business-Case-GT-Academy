package nl.getthere.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recruiter extends User {
	
	private String recruiterName;
	private String recruiterPass;
	private Long id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
	    return id;
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
