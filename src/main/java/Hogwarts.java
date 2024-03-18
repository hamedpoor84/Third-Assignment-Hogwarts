import java.util.ArrayList;

public class Hogwarts {

    // TODO: Define Attributes



    // TODO: Define Functionalities
    public void viewAllTeachers(ArrayList<String> Teachers) {
        for (int i = 0 ; i < Teachers.size() - 1 ; i++ )
        {
            System.out.println(Teachers.get(i));
        }
    }

    public void viewAllStudents(ArrayList<String> Students) {
        for (int i = 0 ; i < Students.size() - 1 ; i++ )
        {
            System.out.println(Students.get(i));
        }
    }

    public void viewAllCourses(ArrayList<String> Courses) {
        for (int i = 0 ; i < Courses.size() - 1 ; i++ )
        {
            System.out.println(Courses.get(i));
        }
    }
}
