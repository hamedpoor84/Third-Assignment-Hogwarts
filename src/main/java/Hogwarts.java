import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;

public class Hogwarts {
    public ArrayList<Teacher> Teachers = new ArrayList<>() ;
    public ArrayList<Assistant> Assistant = new ArrayList<>() ;
    public ArrayList<Course> Courses = new ArrayList<>() ;
    public ArrayList<Students> Students = new ArrayList<>() ;

    // TODO: Define Functionalities
    public void viewAllTeachers() {
        for (int i = 0 ; i < Teachers.size()  ; i++ )
        {
            System.out.println(i+1 + "_ " + Teachers.get(i).getUsername());
        }
    }

    public void viewAllStudents() {
        for (int i = 0 ; i < Students.size() ; i++ )
        {
            System.out.println(i+1 + "_ " + Students.get(i).getUsername());
        }
    }
    public void viewAllAssistant() {
        for (int i = 0 ; i < Assistant.size() ; i++ )
        {
            System.out.println(i+1 + "_ " + Assistant.get(i).getUsername());
        }
    }

    public void viewAllCourses() {
        for (int i = 0 ; i < Courses.size() ; i++ )
        {
            System.out.println(i+1 + "_ " + Courses.get(i).getTitel());
        }
    }
    public boolean maneger_Log_in (String user_name , String password )
    {
        if(user_name.equals("hamed") && password.equals("1234"))
            return true;
        else
            return false;
    }
//    public boolean Teacher_Log_In(String user_name , String password)
//    {
//
//    }
//    public boolean Assistant_Log_In(String username , String password)
//    {
//
//    }
    public void Remove_Teacher (Teacher teacher)// i shoud to remove teacher from every where .
    {
        teacher = null ;
    }
    public void rating_teacher (Teacher teacher , int score )
    {
        teacher.setScore(score);
    }
    public void commenting_teachers (Teacher teacher , String comment)
    {
        ArrayList<String > comments = new ArrayList<>() ;
        comments = teacher.getTeacher_comments();
        comments.add(comment);
        teacher.setTeacher_comments(comments);
    }
    public void rating_students (Students student, int score )
    {
        student.setScore(score);
    }
    public void Add_Teacher (String username , String password)
    {
        Teacher teacher = new Teacher(username , password) ;
        Teachers.add(teacher);
        System.out.println("teacher add sucessfully");
    }
    public void Add_Assistant (String username , String password)
    {
        Assistant assistant = new Assistant(username , password) ;
        Assistant.add(assistant);
        System.out.println("teacher add sucessfully");
    }
    public void Add_Student (String username , String password)
    {
        Students student = new Students(username , password) ;
        Students.add(student);
        System.out.println("Student add sucessfully");
    }
    public void Show_Teachers_Score(){
        for (int i = 0 ; i < Teachers.size()  ; i++ )
        {
            System.out.println(i+1 + " " + Teachers.get(i).getUsername() + "   " + Teachers.get(i).getScore());
        }
    }
    public void Score_Students(Teacher teacher){
        System.out.println("Select the course you want .");
        viewAllTeachers();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int choose_course = myObj.nextInt();  // Read user input
        System.out.println("Please get the name of student you want .");
        teacher.getTeacher_courses().get(choose_course-1).Show_Course_student();
        String choose_student = myObj.nextLine();
        Map<String, Integer> Course_Students = teacher.getTeacher_courses().get(choose_course-1).getCourse_Students() ;
        System.out.println("enter the score");
        int score = myObj.nextInt();
        Course_Students.put(choose_student , score) ;
        teacher.getTeacher_courses().get(choose_course-1).setCourse_Students(Course_Students);
    }
    public boolean Teacher_existance (String name)
    {
        for (int i = 0 ; i < Teachers.size()  ; i++ )
        {
            if (name.equals(Teachers.get(i).getUsername()))
                return true ;
        }
        return false ;
    }
    public Teacher Find_teacher (String name )
    {
        for (int i = 0 ; i < Teachers.size()  ; i++ )
        {
            if (name.equals(Teachers.get(i).getUsername()))
                return Teachers.get(i) ;
        }
        return Teachers.get(0) ;
    }
    public boolean Student_existance (String name)
    {
        for (int i = 0 ; i < Teachers.size()  ; i++ )
        {
            if (name.equals(Teachers.get(i).getUsername()))
                return true ;
        }
        return false ;
    }
    public Students Find_Student (String name)
    {
        for (int i = 0 ; i < Students.size()  ; i++ )
        {
            if (name.equals(Students.get(i).getUsername()))
                return Students.get(i) ;
        }
        return Students.get(0) ;
    }
    public void Add_course (String Title , Teacher teacher)
    {
        Course course = new Course(Title , teacher) ;
        Courses.add(course) ;
        System.out.println("course add sucessfully");
    }
}

