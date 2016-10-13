package nl.getthere.users;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Student{
	private Boolean inActief = false;
	private Long id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private String linkedIn;
	private String woonplaats;
	private Date gebDatum;
	private Boolean agreedPrivacy; // Agreed privacy letter
	@Transient
	private String password;
	private String passwordConfirmation;
	private Boolean wantsTraineeship;
	private Boolean wantsInternship;
	private Boolean wantsTechEvents;
	private Boolean wantsGraduationProject;

	//private Date readyDate; // Date at which student is ready to work

	@Transient
	public String getFullName(){
		return firstName + " " + lastName;
	}

	public Boolean getInActief() {
		return inActief;
	}
	public void setInActief(Boolean inActief){
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

	@Transient
//	@NotEmpty(message="Wachtwoord is verplicht")
	public String getPassword() {
		return this.password;
	}

	@Transient
	public void setPassword(String password) {
		this.password = password;
	}
	
//	@NotEmpty(message="Bevestig je wachtwoord")
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	public Boolean getWantsTraineeship() {
		return wantsTraineeship;
	}

	public void setWantsTraineeship(Boolean wantsTraineeship) {
		this.wantsTraineeship = wantsTraineeship;
	}

	public Boolean getWantsInternship() {
		return wantsInternship;
	}

	public void setWantsInternship(Boolean wantsInternship) {
		this.wantsInternship = wantsInternship;
	}

	public Boolean getWantsTechEvents() {
		return wantsTechEvents;
	}

	public void setWantsTechEvents(Boolean wantsTechEvents) {
		this.wantsTechEvents = wantsTechEvents;
	}

	public Boolean getWantsGraduationProject() {
		return wantsGraduationProject;
	}

	public void setWantsGraduationProject(Boolean wantsGraduationProject) {
		this.wantsGraduationProject = wantsGraduationProject;
	}

	public Boolean getAgreedPrivacy() {
		return agreedPrivacy;
	}

	public void setAgreedPrivacy(Boolean agreedPrivacy) {
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
	
	public String getLinkedIn() {
		return linkedIn;
	}
	
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
	public String getWoonplaats() {
		return woonplaats;
	}
	
	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}
	
	public Date getGebDatum() {
		return gebDatum;
	}
	
	public void setGebDatum (Date gebDatum) {
		this.gebDatum = gebDatum;
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

