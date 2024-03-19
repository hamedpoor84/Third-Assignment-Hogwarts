import java.util.ArrayList;

public class Assistant extends Account {
    public ArrayList<Assistant> Assistant = new ArrayList<>() ;

    public Assistant(String username, String password) {
        super(username, password);
    }

    @Override
    public void Log_In(String username, String password) {
    }

    @Override
    public void Sign_Up(String username, String password) {
    }

    public void Remove_Teacher (Teacher teacher)
    {
        teacher.Remove_Teacher(teacher);
    }
    public void Courses_List ()
    {
    }
    public void Courses_Students ()
    {

    }
    public void View_Profiles ()
    {

    }
    public void Creat_course ()
    {

    }

 }
