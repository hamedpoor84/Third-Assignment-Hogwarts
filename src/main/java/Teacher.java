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
            System.out.println(i+1 + "- " + Teacher_comments.get(i));
        }
    }

    public void View_Teacher_Courses (Teacher teacher)
    {
        for (int i = 0 ; i < Teacher_courses.size() ; i++ )
        {
            System.out.println(i+1 + " " + Teacher_courses.get(i));
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
        if(!course.isAccess_to_take())
        {
            System.out.println("This course already has teacher ");
            return;
        }
        course.setTeacher(teacher);
        Teacher_courses.add(course);
    }
    public void Remove_course (String Title)
    {
        Teacher_courses.removeIf(course -> course.getTitle().equals(Title)) ;
    }


    public void Add_comment (String comment)
    {
        Teacher_comments.add(comment) ;
    }
    public boolean Course_Take (String Title)
    {
        for(Course course : Teacher_courses)
        {
            if (course.getTitle().equals(Title))
            {
                return true ;
            }
        }
        return false ;
    }
}
