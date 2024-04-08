import java.security.Key;
import java.util.*;

public class Hogwarts {
    public ArrayList<Teacher> Teachers = new ArrayList<>() ;
    public ArrayList<Assistant> Assistants = new ArrayList<>() ;
    public ArrayList<Course> Courses = new ArrayList<>() ;
    public ArrayList<Students> Students = new ArrayList<>() ;

    // TODO: Define Functionalities
    public void viewAllTeachers() {
        if (!Teachers.isEmpty()) {
            for (int i = 0; i < Teachers.size(); i++) {
                System.out.println(i + 1 + "- " + Teachers.get(i).getUsername());
            }
        } else {
            System.out.println("no teacher yet");
        }
    }

    public void fake_information ()
    {
        Students students = new Students("ali" , "aaaa");
        Students students1 = new Students("omid" , "oooo");
        Students students2 = new Students("mamad" , "mmmm") ;
        Teacher teacher = new Teacher("mobin" , "mmmm") ;
        Teacher teacher1 = new Teacher("peyman" , "pppp") ;
        Teacher teacher2 = new Teacher("sobhan" , "ssss");
        Course course = new Course("math");
        Course course1 = new Course("math1");
        Course course2 = new Course("math2");
        Students.add(students);
        Students.add(students1);
        Students.add(students2);
        Teachers.add(teacher);
        Teachers.add(teacher1);
        Teachers.add(teacher2);
        Courses.add(course);
        Courses.add(course1);
        Courses.add(course2);
    }
    public void viewAllStudents() {
        if(!Students.isEmpty()) {
            for (int i = 0; i < Students.size(); i++) {
                System.out.println(i + 1 + "- " + Students.get(i).getUsername());
            }
        } else {
            System.out.println("no student yet");
        }
    }
    public void viewAllAssistant() {
        if (Teachers.isEmpty()) {
            for (int i = 0; i < Assistants.size(); i++) {
                System.out.println(i + 1 + "- " + Assistants.get(i).getUsername());
            }
        } else {
            System.out.println("no assistant yet");
        }
    }

    public void viewAllCourses() {
        if (!Courses.isEmpty()) {
            for (int i = 0; i < Courses.size(); i++) {
                System.out.print(i + 1 + "- " + Courses.get(i).getTitle() + "      Teacher : ");
                if (!Courses.get(i).isAccess_to_take()) {
                    System.out.println(Courses.get(i).getTeacher().getUsername());
                } else {
                    System.out.println("no teacher define .");
                }
            }
        } else {
            System.out.println("not course yet");
        }
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
        System.out.println("Student add successfully");
    }
//    public void Show_Teachers_Score(){
//        for (int i = 0 ; i < Teachers.size()  ; i++ )
//        {
//            System.out.println(i+1 + " " + Teachers.get(i).getUsername() + "   " + Teachers.get(i).getScore());
//        }
//    }
    public void Score_Students(Teacher teacher){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        teacher.View_Teacher_Courses(teacher);
        System.out.println("Select the course you want .");
        int choose_course = myObj.nextInt();  // Read user input
        teacher.getTeacher_courses().get(choose_course-1).Show_Course_student();
        System.out.println("Select the student you want");
        int choose_student = myObj.nextInt();
        Map<String, Integer> Course_Students = teacher.getTeacher_courses().get(choose_course-1).getCourse_Students() ;
        System.out.print("enter the score : ");
        int score = myObj.nextInt();
        List<String> keysList = new ArrayList<>(Course_Students.keySet());
        Course_Students.replace(keysList.get(choose_student-1)  , score ) ;
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
        return Teachers.getFirst() ;
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
        return Assistants.getFirst() ;
    }
    public boolean Student_Existance (String name)
    {
        for (Students students : Students) {
            if (name.equals(students.getUsername()))
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
        return Students.getFirst() ;
    }
    public boolean Course_Existence (String name)
    {
        for (Course course : Courses) {
            if (name.equals(course.getTitle()))
                return true;
        }
        return false ;
    }
    public Course Find_Course (String name)
    {
        for (Course course : Courses) {
            if (name.equals(course.getTitle()))
                return course;
        }
        return Courses.getFirst() ;
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
        if (!courses.isEmpty()) {
            for (int i = 0; i < courses.size(); i++) {
                System.out.println(i + 1 + "- " + courses.get(i).getTitle());
            }
        } else {
            System.out.println("no course yet");
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
            for (Course course : Find_teacher(user_name).getTeacher_courses()) {
                course.setTeacher(null);
                course.setAccess_to_take(true);
            }

            Teacher teacherToRemove = Find_teacher(user_name);
            Teachers.removeIf(teacher -> teacher == teacherToRemove);
        } else {
            System.out.println("teacher not find");
        }
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
            System.out.println("course not find");
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

    public void takeCourse (String course , String teacher)
    {
        if (Course_Existence(course) && Teacher_Existence(teacher))
        Find_teacher(teacher).Take_Courses(Find_Course(course) , Find_teacher(teacher));
        else {
            System.out.println("WRONG!!!");
        }
    }
}

