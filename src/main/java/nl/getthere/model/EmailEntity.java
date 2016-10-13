package nl.getthere.model;

import nl.getthere.users.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by hein.dehaan on 13-10-2016.
 */

@Entity
public class EmailEntity {
    private Long id;
    private ArrayList<Student> receivers = new ArrayList<Student>();
    private String subject;
    private String message;

    public EmailEntity(){}

    public EmailEntity(ArrayList<Student> receivers, String subject, String message){
        this.receivers = receivers;
        this.subject = subject;
        this.message = message;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public ArrayList<Student> getReceivers() {
        return receivers;
    }

    public void setReceivers(ArrayList<Student> receivers) {
        this.receivers = receivers;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
