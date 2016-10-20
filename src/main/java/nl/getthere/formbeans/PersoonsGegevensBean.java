package nl.getthere.formbeans;

import nl.getthere.model.DataChange;
import nl.getthere.model.DataChangeRepository;
import nl.getthere.users.Student;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hein.dehaan on 12-10-2016.
 */
public class PersoonsGegevensBean {
    private String firstName;
    private String lastName;
    private Date gebDatum;
    private Date afstudeerDatum;

    public Date getAfstudeerDatum() {
        return afstudeerDatum;
    }

    public void setAfstudeerDatum(Date afstudeerDatum) {
        this.afstudeerDatum = afstudeerDatum;
    }

    private String woonplaats;

    public PersoonsGegevensBean(){}

    public PersoonsGegevensBean(Student student){
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
    }

    public Student fillStudent(Student student, DataChangeRepository dataChangeRepo){
        if(!firstName.equals(student.getFirstName())){
            DataChange dataChange = new DataChange(student.getEmailAddress(), student.getFirstName(), student.getLastName(), "voornaam", student.getFirstName(), firstName);
            dataChangeRepo.save(dataChange);
        }
        if(!lastName.equals(student.getLastName())){
            DataChange dataChange = new DataChange(student.getEmailAddress(), student.getFirstName(), student.getLastName(), "achternaam", student.getLastName(), lastName);
            dataChangeRepo.save(dataChange);
        }

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        if(!gebDatum.equals(student.getGebDatum())){
            DataChange dataChange = new DataChange(student.getEmailAddress(), student.getFirstName(), student.getLastName(), "geboorteDatum", df.format(student.getGebDatum()), df.format(gebDatum));
            dataChangeRepo.save(dataChange);
        }
        if(!afstudeerDatum.equals(student.getAfstudeerDatum())){
            DataChange dataChange = new DataChange(student.getEmailAddress(), student.getFirstName(), student.getLastName(), "afstudeerDatum", df.format(student.getAfstudeerDatum()), df.format(afstudeerDatum));
            dataChangeRepo.save(dataChange);
        }


        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGebDatum(gebDatum);
        student.setAfstudeerDatum(afstudeerDatum);
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
