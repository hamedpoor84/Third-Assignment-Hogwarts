import java.util.*;

public class Course {
    private String Titel ;
    private UUID courseID ;
    private static Map<String, Integer> Course_Students
            = new HashMap<>();
    private Teacher teacher ;

    public Course(String titel, Teacher teacher) {
        Titel = titel;
        this.teacher = teacher;
        courseID = UUID.randomUUID();
    }

    public void Add_student (String name){
        Course_Students.put("name" , -1) ;
    }

    public void Show_Course_student ()
    {
        int i = 0 ;
        for (Map.Entry<String, Integer> e : Course_Students.entrySet()) { // Printing key-value pairs
            System.out.print(i+1 + " " + e.getKey() + " ");
            if (e.getValue() == -1 )
                System.out.println("no score");
            else
                System.out.println(e.getValue());
            i++ ;
        }
    }

    public String getTitel() {
        return Titel;
    }

    public void setTitel(String titel) {
        Titel = titel;
    }

    public UUID getCourseID() {
        return courseID;
    }

    public void setCourseID(UUID courseID) {
        this.courseID = courseID;
    }

    public Map<String, Integer> getCourse_Students() {
        return Course_Students;
    }

    public void setCourse_Students(Map<String, Integer> course_Students) {
        Course_Students = course_Students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
