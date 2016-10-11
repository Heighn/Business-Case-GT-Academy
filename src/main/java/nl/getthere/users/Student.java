package nl.getthere.users;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;


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
	private String gebDatum;
	private Boolean agreedPrivacy; // Agreed privacy letter
	private String password;
	private String passwordConfirmation;
	private Boolean wantsTraineeship;
	private Boolean wantsInternship;
	private Boolean wantsTechEvents;
	private Boolean wantsGraduationProject;

	@Transient
	private UserProfile userProfile = new UserProfile();

	@Transient
	public UserProfile getUserProfile() {
		return userProfile;
	}

	@Transient
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	//private Date readyDate; // Date at which student is ready to work

	@Transient
	public String getFullName(){
		return firstName + " " + lastName;
	}

	public Boolean isInActief(){
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
	
	@NotEmpty(message="Wachtwoord is verplicht")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = passwordEncoder.encode(password);
//		this.password = password;
		userProfile.setPassword(password);
	}

	@Transient
	@NotEmpty(message="Bevestig je wachtwoord")
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
		userProfile.setUserName(emailAddress);
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
	
	public String getGebDatum() {
		return gebDatum;
	}
	
	public void setGebDatum (String gebDatum) {
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

