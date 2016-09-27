package nl.getthere.students;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Student {
	private Long id;
	private String name;
	private String phoneNumber;
	private String emailAddress;
	private Date readyDate; // Date at which student is ready to work
	private Boolean agreedPrivacy; // Agreed privacy letter

	public Boolean getAgreedPrivacy() {
		return agreedPrivacy;
	}

	public void setAgreedPrivacy(Boolean agreedPrivacy) {
		this.agreedPrivacy = agreedPrivacy;
	}

	// private Boolean wantsJob;
	// private Boolean wantsInternship;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
