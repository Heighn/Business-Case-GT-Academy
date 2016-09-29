package nl.getthere.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student{
	private boolean inActief = false;
	private Long id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private boolean agreedPrivacy; // Agreed privacy letter
	private String password;
	private String passwordConfirmation;
	private boolean wantsTraineeship;
	private boolean wantsInternship;
	private boolean wantsTechEvents;
	private boolean wantsGraduationProject;
	
	//private Date readyDate; // Date at which student is ready to work
	
	public boolean isInActief(){
		return inActief;
	}
	
	public void setInActief(boolean inActief){
		this.inActief = inActief;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty(message="Voornaam is verplicht")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@NotEmpty(message="Achternaam is verplicht")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@NotEmpty(message="Wachtwoord is verplicht")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@NotEmpty(message="Bevestig je wachtwoord")
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	public boolean getWantsTraineeship() {
		return wantsTraineeship;
	}

	public void setWantsTraineeship(Boolean wantsTraineeship) {
		this.wantsTraineeship = wantsTraineeship;
	}

	public boolean getWantsInternship() {
		return wantsInternship;
	}

	public void setWantsInternship(Boolean wantsInternship) {
		this.wantsInternship = wantsInternship;
	}

	public boolean getWantsTechEvents() {
		return wantsTechEvents;
	}

	public void setWantsTechEvents(Boolean wantsTechEvents) {
		this.wantsTechEvents = wantsTechEvents;
	}

	public boolean getWantsGraduationProject() {
		return wantsGraduationProject;
	}

	public void setWantsGraduationProject(Boolean wantsGraduationProject) {
		this.wantsGraduationProject = wantsGraduationProject;
	}

	public boolean getAgreedPrivacy() {
		return agreedPrivacy;
	}

	public void setAgreedPrivacy(boolean agreedPrivacy) {
		this.agreedPrivacy = agreedPrivacy;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String toString(){
		return firstName + " " + lastName + " " + phoneNumber + " " + emailAddress;
	}

//	public Date getReadyDate() {
//		return readyDate;
//	}
//
//	public void setReadyDate(Date ready_date) {
//		this.readyDate = readyDate;
//	}
}
