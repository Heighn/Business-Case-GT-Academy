package nl.getthere.formbeans;

import nl.getthere.model.Theme;
import nl.getthere.model.ThemeRepository;
import nl.getthere.users.Student;

import java.util.ArrayList;

/**
 * Created by hein.dehaan on 12-10-2016.
 */

public class ThemeBean {
    private String[] themes;


    public Student fillStudent(Student student, ThemeRepository themeRepo){
        ArrayList<Theme> themesList = new ArrayList<Theme>();

        for(String theme : themes){
            themesList.add(themeRepo.findByDescription(theme));
        }
//        student.setThemes(themesList);

        return student;
    }

    public String[] getThemes() {
        return themes;
    }

    public void setThemes(String... themes) {
        this.themes = themes;
    }
}
