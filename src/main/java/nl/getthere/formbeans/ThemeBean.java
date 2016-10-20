package nl.getthere.formbeans;

import nl.getthere.users.Student;

/**
 * Created by hein.dehaan on 12-10-2016.
 */

public class ThemeBean {
    private String[] themeDescriptions;


    public Student fillStudent(Student student){
        student.setThemeDescriptions(themeDescriptions);

        return student;
    }

    public String[] getThemeDescriptions() {
        return themeDescriptions;
    }

    public void setThemeDescriptions(String... themeDescriptions) {
        this.themeDescriptions = themeDescriptions;
    }
}
