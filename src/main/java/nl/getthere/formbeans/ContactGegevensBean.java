package nl.getthere.formbeans;

import nl.getthere.model.DataChange;
import nl.getthere.model.DataChangeRepository;
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

    public Student fillStudent(Student student, DataChangeRepository dataChangeRepo){
        student.setPhoneNumber(phoneNumber);
        student.setLinkedIn(linkedIn);

        if(!emailAddress.equals(student.getEmailAddress())){
            DataChange dataChange = new DataChange(student.getEmailAddress(), student.getFirstName(), student.getLastName(), "emailadres", student.getEmailAddress(), emailAddress);
            dataChangeRepo.save(dataChange);
        }
        if(!phoneNumber.equals(student.getPhoneNumber())){
            DataChange dataChange = new DataChange(student.getEmailAddress(), student.getFirstName(), student.getLastName(), "telefoonnummer", student.getPhoneNumber(), phoneNumber);
            dataChangeRepo.save(dataChange);
        }
        if(!linkedIn.equals(student.getLinkedIn())){
            DataChange dataChange = new DataChange(student.getEmailAddress(), student.getFirstName(), student.getLastName(), "LinkedIn-pagina", student.getLinkedIn(), linkedIn);
            dataChangeRepo.save(dataChange);
        }




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
