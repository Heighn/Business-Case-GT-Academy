package nl.getthere.users;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

	@Transient
	private UserProfile userProfile = new UserProfile();
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


	public Recruiter() {}
	
	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	private Long id;

	@Transient
	public UserProfile getUserProfile() {
		return userProfile;
	}

	@Transient
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

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
		this.recruiterPass = passwordEncoder.encode(recruiterPass);
	}

	public String getRecruiterName() {
		return recruiterName;
	}


	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
		userProfile.changeRole("recruiter");
	}

	public String getRecruiterPass() {
		return recruiterPass;
	}

	public void setRecruiterPass(String recruiterPass) {
		this.recruiterPass = passwordEncoder.encode(recruiterPass);
		this.userProfile.setPassword(recruiterPass);
	}
	

}