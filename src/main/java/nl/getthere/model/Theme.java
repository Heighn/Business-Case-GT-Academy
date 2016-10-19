package nl.getthere.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by hein.dehaan on 18-10-2016.
 */

@Entity
public class Theme {
    private Long id;
    private String description;

//    @ManyToMany(mappedBy="themes", cascade=CascadeType.ALL)
//    private ArrayList<Student> students;
    private ArrayList<Long> studentIDs = new ArrayList<Long>();


    public Theme(){}

    public Theme(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public ArrayList<Long> getStudentIDs() {
        return studentIDs;
    }

    public void setStudentIDs(ArrayList<Long> studentIDs) {
        this.studentIDs = studentIDs;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
