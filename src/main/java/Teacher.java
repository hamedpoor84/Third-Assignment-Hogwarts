import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Teacher extends Account
{
    public ArrayList<Teacher> Teachers = new ArrayList<>() ;
    private ArrayList<Course> Teachers_courses = new ArrayList<>() ;
    public Teacher(String username, String password) {
        super(username, password);
    }

    @Override
    public void Log_In(String name, String password) {

    }

    @Override
    public void Sign_Up(String name, String password) {

    }

    public void Take_Courses(Course course , Teacher teacher)// i shoud print all courses than I
    // want a course for taking .
    {
        course.setTeacher(teacher);
        Teachers_courses.add(course);
    }
    public void Score_Students(){
        System.out.println("Select the course you want .");
        Courses_List();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int choose_course = myObj.nextInt();  // Read user input
        System.out.println("Please get the name of student you want .");
        Teachers_courses.get(choose_course-1).Show_Course_student();
        String choose_student = myObj.nextLine();
        Map<String, Integer> Course_Students = Teachers_courses.get(choose_course-1).getCourse_Students() ;
        System.out.println("enter the score");
        int score = myObj.nextInt();
        Course_Students.put(choose_student , score) ;
        Teachers_courses.get(choose_course-1).setCourse_Students(Course_Students);
    }
    public void Courses_List(){
        for (int i = 0 ; i < Teachers_courses.size() ; i++)
        {
            System.out.println(i+1 + " " + Teachers_courses.get(i));
        }
    }
    public void Courses_Student(Course course){
        course.Show_Course_student();
    }
    public void Show_Teachers_Score(){

    }
    public void Remove_Teacher (Teacher teacher)
    {
        teacher = null ;
    }

}
