import java.util.ArrayList;

public class Assistant extends Account {

    private ArrayList<String> Teacher_Requests = new ArrayList<>() ;
    public Assistant(String username, String password) {
        super(username, password);
    }
    public void Add_Request (String request)
    {
        Teacher_Requests.add(request) ;
    }
    public void View_Teacher_Requests ()
    {
        for (int i = 0 ; i < Teacher_Requests.size()  ; i++ )
        {
            System.out.println(i+1 + "_ " + Teacher_Requests.get(i));
        }
    }
 }
