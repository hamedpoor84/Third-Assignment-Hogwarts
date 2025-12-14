import java.util.*;

public class Course {
    private String Title;
    private UUID courseID ;
    private boolean access_to_take ;
    private static Map<String, Integer> Course_Students
            = new HashMap<>();
    private Teacher teacher ;

    public Course(String Title) {
        access_to_take = true ;
        this.Title = Title;
        courseID = UUID.randomUUID();
    }

    public void Add_student (String name){
        Course_Students.put(name , -1) ;
    }

    public void Show_Course_student ()
    {
        int i = 0 ;
        for (Map.Entry<String, Integer> e : Course_Students.entrySet()) { // Printing key-value pairs
            System.out.print(i+1 + "- " + e.getKey() + "   ");
            if (e.getValue() == -1 )
                System.out.println("no score");
            else
                System.out.println(e.getValue());
            i++ ;
        }
    }

    public Map<String, Integer> getCourse_Students() {
        return Course_Students;
    }

    public void setCourse_Students(Map<String, Integer> course_Students) {
        Course_Students = course_Students;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public UUID getCourseID() {
        return courseID;
    }

    public void setCourseID(UUID courseID) {
        this.courseID = courseID;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        access_to_take = false ;
    }

    public boolean isAccess_to_take() {
        return access_to_take;
    }

    public void setAccess_to_take(boolean access_to_take) {
        this.access_to_take = access_to_take;
    }
}
