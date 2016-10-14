package nl.getthere.formbeans;

import nl.getthere.users.Student;

/**
 * Created by hein.dehaan on 12-10-2016.
 */
public class ContactGegevensBean {
    private String emailAddress;
    private String phoneNumber;
    private String linkedIn;

    public ContactGegevensBean(){}

    public ContactGegevensBean(Student student){
        this.emailAddress = student.getEmailAddress();
    }

    public Student fillStudent(Student student){
        student.setPhoneNumber(phoneNumber);
        student.setLinkedIn(linkedIn);
        return student;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }
}
