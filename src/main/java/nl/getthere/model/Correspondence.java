package nl.getthere.model;

import javax.persistence.*;
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
    private Date date;
    private String dateString;

    public Correspondence(){}

    public Correspondence(String receivers, String dateString, String subject, String message, String type){
        this.receivers = receivers;
        this.dateString = dateString;
        this.subject = subject;
        this.message = message;
        this.type = type;
    }

    @Transient
    public Date getDate() {
        return date;
    }

    @Transient
    public void setDate(Date date) {
        this.date = date;
        DateFormat dateFormat = new SimpleDateFormat();
        this.dateString = dateFormat.format(date);
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public void yearMonthDay(){ //Makes dateString yyyy-mm-dd
        String[] dateSplit = dateString.split("/");

        if(dateSplit[2].length() == 4) {
            dateString = dateSplit[2] + "/" + dateSplit[0] + "/" + dateSplit[1];
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
