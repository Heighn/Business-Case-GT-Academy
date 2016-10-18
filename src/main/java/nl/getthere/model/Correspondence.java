package nl.getthere.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hein.dehaan on 13-10-2016.
 */

@Entity
public class Correspondence {
    private Long id;
    private String receivers;
    private String subject;
    private String message;
    private String type; //Email, phone conversation or personal visit
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(Date date) { //NOTE: this method gets a date and returns a String
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.date = dateFormat.format(date);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Correspondence(){}

    public Correspondence(String receivers, String subject, String message, String type){
        this.receivers = receivers;
        this.subject = subject;
        this.message = message;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getReceivers() {
        return receivers;
    }

    public void setReceivers(String receivers) {
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