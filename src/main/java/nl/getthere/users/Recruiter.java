package nl.getthere.users;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Recruiter{
	
	@NotEmpty(message="Vul uw gebruikersnaam in.")
//	@UniqueConstraint(columnNames = {"recruiterName"})
	@Column(unique=true)
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