import java.security.Key;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;

public class Hogwarts {
    public ArrayList<Teacher> Teachers = new ArrayList<>() ;
    public ArrayList<Assistant> Assistants = new ArrayList<>() ;
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
        for (int i = 0 ; i < Assistants.size() ; i++ )
        {
            System.out.println(i+1 + "_ " + Assistants.get(i).getUsername());
        }
    }

    public void viewAllCourses() {
        for (int i = 0 ; i < Courses.size() ; i++ )
        {
            System.out.print(i+1 + "_ " + Courses.get(i).getTitle() + "      Teacher : ");
            if (!Courses.get(i).isAccess_to_take())
            {
                System.out.println(Courses.get(i).getTeacher());
            }
            else {
                System.out.println("no teacher define .");
            }
        }
    }
    public boolean maneger_Log_in (String user_name , String password )
    {
        if(user_name.equals("hamed") && password.equals("1234"))
            return true;
        else
            return false;
    }
    public void commenting_teachers (Teacher teacher , String comment)
    {
        ArrayList<String > comments = new ArrayList<>() ;
        comments = teacher.getTeacher_comments();
        comments.add(comment);
        teacher.setTeacher_comments(comments);
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
        Assistants.add(assistant);
        System.out.println("assistant add sucessfully");
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
        System.out.println();
        System.out.println("Select the course you want .");
        teacher.View_Teacher_Courses(teacher);
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
    public boolean Teacher_Existence (String name)
    {
        for (Teacher teacher : Teachers) {
            if (name.equals(teacher.getUsername()))
                return true;
        }
        return false ;
    }
    public Teacher Find_teacher (String name )
    {
        for (Teacher teacher : Teachers) {
            if (name.equals(teacher.getUsername()))
                return teacher;
        }
        return Teachers.get(0) ;
    }
    public boolean Assistant_Existence (String name)
    {
        for (Assistant assistant : Assistants) {
            if (name.equals(assistant.getUsername()))
                return true;
        }
        return false ;
    }
    public Assistant Find_Assistant (String name)
    {
        for (Assistant assistant : Assistants) {
            if (name.equals(assistant.getUsername()))
                return assistant;
        }
        return Assistants.get(0) ;
    }
    public boolean Student_Existance (String name)
    {
        for (Teacher teacher : Teachers) {
            if (name.equals(teacher.getUsername()))
                return true;
        }
        return false ;
    }
    public Students Find_Student (String name)
    {
        for (Students student : Students) {
            if (name.equals(student.getUsername()))
                return student;
        }
        return Students.get(0) ;
    }
    public boolean Course_Existence (String name)
    {
        for (Course cours : Courses) {
            if (name.equals(cours.getTitle()))
                return true;
        }
        return false ;
    }
    public Course Find_Course (String name)
    {
        for (Course cours : Courses) {
            if (name.equals(cours.getTitle()))
                return cours;
        }
        return Courses.get(0) ;
    }
    public void Add_Course (String Title)
    {
        Course course = new Course(Title) ;
        Courses.add(course) ;
        System.out.println("course add successfully");
    }
    public void View_Teacher_Courses (Teacher teacher)
    {
        ArrayList<Course> courses = teacher.getTeacher_courses() ;
        for (int i = 0 ; i < courses.size() ; i++ )
        {
            System.out.println(i+1 + "_ " + courses.get(i));
        }
    }
    public void Teacher_Requests (String request)
    {
        for (Assistant assistant : Assistants)
        {
            assistant.Add_Request(request);
        }
    }
    public void Remove_Teacher (String user_name)
    {
        if(Teacher_Existence(user_name))
        {
            for (Course course : Find_teacher(user_name).getTeacher_courses())
            {
                course.setTeacher(null);
                course.setAccess_to_take(true);
            }
            for (Teacher teacher : Teachers)
            {
                Teachers.remove(Find_teacher(user_name)) ;
            }
        } else {
            System.out.println("teacher not find");
        }
    }
    public void Remove_Student (String user_name)
    {
       for (Course course : Find_Student(user_name).getStudent_courses())
           course.getCourse_Students().remove(user_name) ;
       Students.removeIf(students -> students.getUsername().equals(user_name));
    }
    public void Remove_Course (String Title)
    {
        if(Course_Existence(Title))
        {
            for (String Key : Find_Course(Title).getCourse_Students().keySet())
            {
                Find_Student(Key).Remove_Course(Title);
            }
            Find_Course(Title).getTeacher().Remove_course(Title);
        } else {
            System.out.println("teacher not find");
        }
        Courses.removeIf(course -> course.getTitle().equals(Title)) ;
    }
    public void Add_Student_Course(Course course , Students students)
    {
        course.Add_student(students.getUsername());
        ArrayList<Course> student_courses = students.getStudent_courses() ;
        student_courses.add(course) ;
        students.setStudent_courses(student_courses);
    }
}

