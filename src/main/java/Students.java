import java.util.ArrayList;
import java. util. Random;

public class Students extends Account {
    private ArrayList<Course> Student_courses = new ArrayList<>() ;
    private int score ;
    private String Hogwarts_House ;
    public Students(String username, String password)
    {
        super(username, password);
    }

    public ArrayList<Course> getStudent_courses() {
        return Student_courses;
    }

    public void setStudent_courses(ArrayList<Course> student_courses) {
        Student_courses = student_courses;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void SetProfile ()
    {

    }
    public void GetProfile ()
    {

    }

}
