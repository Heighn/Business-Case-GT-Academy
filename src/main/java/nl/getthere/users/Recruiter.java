package nl.getthere.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Recruiter{
	
	@NotEmpty(message="Vul uw gebruikersnaam in.")
	private String recruiterName;
	@NotEmpty(message="Geef een nieuw wachtwoord op.")
	private String recruiterPass;
	private String confirm;

	
	public Recruiter() {}
	
	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	private Long id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
	    return id;
	}
	
	public void setId(Long id){
	    this.id = id;
	}
	
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