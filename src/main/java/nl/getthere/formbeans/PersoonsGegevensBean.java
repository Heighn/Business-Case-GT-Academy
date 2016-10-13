package nl.getthere.formbeans;

import nl.getthere.users.Student;

import java.util.Date;

/**
 * Created by hein.dehaan on 12-10-2016.
 */
public class PersoonsGegevensBean {
    private String firstName;
    private String lastName;
    private Date gebDatum;
    private String woonplaats;

    public PersoonsGegevensBean(){}

    public PersoonsGegevensBean(Student student){
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
    }

    public Student fillStudent(Student student){
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGebDatum(gebDatum);
        student.setWoonplaats(woonplaats);
        return student;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getGebDatum() {
        return gebDatum;
    }

    public void setGebDatum(Date gebDatum) {
        this.gebDatum = gebDatum;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }
}
