package nl.getthere.users;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Student extends User{
	private String phoneNumber;
	private String emailAddress;
	private Date readyDate; // Date at which student is ready to work
	private Boolean agreedPrivacy; // Agreed privacy letter
	private String password;
	private Boolean wantsTraineeship;
	private Boolean wantsInternship;
	private Boolean wantsTechEvents;
	private Boolean wantsGraduationProject;
	
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

	public Date getReadyDate() {
		return readyDate;
	}

	public void setReadyDate(Date ready_date) {
		this.readyDate = readyDate;
	}
}
