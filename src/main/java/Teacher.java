import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Teacher extends Account
{
    private int score ;
    private ArrayList<Course> Teacher_courses = new ArrayList<>() ;
    private ArrayList<String> Teacher_comments = new ArrayList<>() ;
    public Teacher(String username, String password)
    {
        super(username, password);
        score = -1 ;
    }
    public int getScore() {
        return score;
    }

    public void View_Teacher_comments (Teacher teacher)
    {
        for (int i = 0 ; i < Teacher_comments.size() ; i++ )
        {
            System.out.println(i+1 + " " + Teacher_comments.get(i));
        }
    }

    public ArrayList<String> getTeacher_comments() {
        return Teacher_comments;
    }

    public void setTeacher_comments(ArrayList<String> teacher_comments) {
        Teacher_comments = teacher_comments;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Course> getTeacher_courses() {
        return Teacher_courses;
    }

    public void setTeacher_courses(ArrayList<Course> teacher_courses) {
        Teacher_courses = teacher_courses;
    }

    public void Take_Courses(Course course , Teacher teacher)// i shoud print all courses than I
    // want a course for taking .
    {
        course.setTeacher(teacher);
        Teacher_courses.add(course);
    }

    public void Courses_Student(Course course){
        course.Show_Course_student();
    }
    public void Remove_Teacher (Teacher teacher)
    {
        teacher = null ;
    }

    public void Add_comment (String comment)
    {
        Teacher_comments.add(comment) ;
    }
}
