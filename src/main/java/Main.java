/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//    public ArrayList<Student> Student = new ArrayList<>() ;

    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        Hogwarts hogwarts = new Hogwarts();
        while (true) {
            boolean access = false;
            Scanner scanner = new Scanner(System.in);
            String character = null;
            String user_name = null;
            String password= null;
            System.out.println("welcome to hogwarts school");
            System.out.println("Sigh_up or Log_in");
            while (!access) {
                String option = scanner.next();
                if (option.equals("Log_in")) {
                    character = scanner.next();
                    user_name = scanner.next();
                    password = scanner.next();
                    if (character.equals("Manager") && user_name.equals("hamed") && password.equals("1234"))
                    {
                        access = true ;
                    }
                    if (character.equals("Teacher"))
                    {
                        if (hogwarts.Teacher_existance(user_name))
                        {
                            Teacher teacher = hogwarts.Find_teacher(user_name);
                            if (teacher.getPassword() == password.hashCode())
                            {
                                access = true ;
                            }
                        }
                    }
                    if (character.equals("Assistant"))
                    {
                        if (hogwarts.Teacher_existance(user_name))
                        {
                            Assistant assistant = hogwarts.Find_Assistant(user_name);
                            if (assistant.getPassword() == password.hashCode())
                            {
                                access = true ;
                            }
                        }
                    }
                    if (character.equals("Student"))
                    {
                        if (hogwarts.Student_existance(user_name))
                        {
                            Students students = hogwarts.Find_Student(user_name);
                            if (students.getPassword() == password.hashCode())
                            {
                                access = true ;
                            }
                        }
                    }
                } else if (option.equals("Sign_up")) {
                    while (!access) {
                        character = scanner.next();
                        user_name = scanner.next();
                        password = scanner.next();
                        String request = user_name + " " + password ;
                        if (character.equals("Teacher"))
                        {
                            hogwarts.Teacher_Requests(request);
                        }
                        if (character.equals("Student"))
                        {
                            user_name = scanner.next();
                            password = scanner.next();
                            hogwarts.Add_Student(user_name, password);
                            System.out.println("Registration was successful");
                            access = true ;
                        }
                    }
                }
            }
            switch (character) {
                case "Manager" -> {
                    System.out.println("Log in successfully");
                    while (true) {
                        System.out.println("give command");
                        String mode = scanner.next();
                        if (mode.equals("manager")) {
                            String command = scanner.next();
                            if (command.equals("show")) {
                                String ob = scanner.next();
                                if (ob.equals("teachers")) {
                                    hogwarts.viewAllTeachers();
                                } else if (ob.equals("courses")) {
                                    hogwarts.viewAllCourses();
                                } else if (ob.equals("students")) {
                                    hogwarts.viewAllStudents();
                                } else if (ob.equals("assistants")) {
                                    hogwarts.viewAllAssistant();
                                } else if (ob.equals("teacher")) {
                                    String name = scanner.next();
                                    if (hogwarts.Teacher_existance(name)) {
                                        Teacher teacher = hogwarts.Find_teacher(name);
                                        String information = scanner.next();
                                        if (information.equals("comments")) {
                                            teacher.View_Teacher_comments(teacher);
                                        } else if (information.equals("score")) {
                                            System.out.println(teacher.getScore());
                                        } else if (information.equals("courses")) {
                                            hogwarts.View_Teacher_Courses(teacher);
                                        }
                                    } else {
                                        System.out.println("teacher not found");
                                    }
                                } else if (ob.equals("course")) {
                                    String name = scanner.next();
                                    if (hogwarts.Teacher_existance(name)) {
                                        Course course = hogwarts.Find_Course(name);
                                        String information = scanner.next();
                                        if (information.equals("teacher")) {
                                            course.getTeacher();
                                        }
//                                    else if (information.equals("score")) {
//                                        System.out.println(teacher.getScore());
//                                    }
                                        else if (information.equals("students")) {
                                            course.Show_Course_student();
                                        }
                                    } else {
                                        System.out.println("teacher not found");
                                    }

                                }
                            } else if (command.equals("Remove")) {
                                String ob = scanner.next();
                                if (ob.equals("teacher")) {

                                } else if (ob.equals("course")) {

                                } else if (ob.equals("assistant")) {

                                } else if (ob.equals("student")) {

                                }
                            } else if (command.equals("add")) {
                                String ob = scanner.next();
                                if (ob.equals("teacher")) {
                                    user_name = scanner.next();
                                    password = scanner.next();
                                    hogwarts.Add_Teacher(user_name, password);
                                } else if (ob.equals("course")) {
                                    String Titel = scanner.next();
                                    String Teacher_name = scanner.next();
                                    if (hogwarts.Teacher_existance(Teacher_name)) {
                                        hogwarts.Add_course(Titel, hogwarts.Find_teacher(Teacher_name));
                                    } else {
                                        System.out.println("teacher not found");
                                    }
                                } else if (ob.equals("assistant")) {
                                    user_name = scanner.next();
                                    password = scanner.next();
                                    hogwarts.Add_Assistant(user_name, password);
                                } else if (ob.equals("student")) {
                                    user_name = scanner.next();
                                    password = scanner.next();
                                    hogwarts.Add_Student(user_name, password);
                                } else if (ob.equals("comment")) {
                                    String cf = scanner.next();
                                    if (cf.equals("teacher")) {
                                        String name = scanner.next();
                                        if (hogwarts.Teacher_existance(name)) {
                                            String comment = scanner.next("");
                                            hogwarts.Find_teacher(name).Add_comment(comment);
                                        } else {
                                            System.out.println("teacher not found");
                                        }
                                    }
                                }
                            } else if (command.equals("set")) {
                                String ob = scanner.next();
                                String name = scanner.next();
                                if (ob.equals("teacher")) {
                                    if (hogwarts.Teacher_existance(name)) {
                                        Teacher teacher = hogwarts.Find_teacher(name);
                                        String attribute = scanner.next();
                                        if (attribute.equals("score")) {
                                            int score = scanner.nextInt();
                                            hogwarts.Find_teacher(name).setScore(score);
                                        }
                                    } else {
                                        System.out.println("teacher not found");
                                    }
                                } else if (ob.equals("")) {

                                }
                            } else if (command.equals("exit")) {
                                break;
                            } else {
                                System.out.println("command not find");
                            }
                        }
                    }
                }
                case "Assistant" -> {
                    System.out.println("Log in successfully");
                    while (true) {
                        System.out.println("give command");
                        String mode = scanner.next();
                        if (mode.equals("assistant")) {
                            String command = scanner.next();
                            if (command.equals("show")) {
                                String ob = scanner.next();
                                if (ob.equals("teachers")) {
                                    hogwarts.viewAllTeachers();
                                } else if (ob.equals("courses")) {
                                    hogwarts.viewAllCourses();
                                } else if (ob.equals("students")) {
                                    hogwarts.viewAllStudents();
                                } else if (ob.equals("teacher")) {
                                    String name = scanner.next();
                                    if (hogwarts.Teacher_existance(name)) {
                                        Teacher teacher = hogwarts.Find_teacher(name);
                                        String information = scanner.next();
                                        if (information.equals("comments")) {
                                            teacher.View_Teacher_comments(teacher);
                                        } else if (information.equals("score")) {
                                            System.out.println(teacher.getScore());
                                        } else if (information.equals("courses")) {
                                            hogwarts.View_Teacher_Courses(teacher);
                                        }
                                    } else {
                                        System.out.println("teacher not found");
                                    }
                                } else if (ob.equals("course")) {
                                    String name = scanner.next();
                                    if (hogwarts.Teacher_existance(name)) {
                                        Course course = hogwarts.Find_Course(name);
                                        String information = scanner.next();
                                        if (information.equals("teacher"))
                                        {
                                            if (!course.isAccess_to_take())
                                                System.out.println(course.getTeacher());
                                            else {
                                                System.out.println("no teacher define.");
                                            }
                                        }
//                                    else if (information.equals("score")) {
//                                        System.out.println(teacher.getScore());
//                                    }
                                        else if (information.equals("students")) {
                                            course.Show_Course_student();
                                        }
                                    } else {
                                        System.out.println("teacher not found");
                                    }

                                }
                            } else if (command.equals("Remove")) {
                                String ob = scanner.next();
                                if (ob.equals("teacher")) {

                                } else if (ob.equals("course")) {

                                } else if (ob.equals("assistant")) {

                                } else if (ob.equals("student")) {

                                }
                            } else if (command.equals("add")) {
                                String ob = scanner.next();
                                if (ob.equals("teacher")) {
                                    user_name = scanner.next();
                                    password = scanner.next();
                                    hogwarts.Add_Teacher(user_name, password);
                                } else if (ob.equals("course")) {
                                    String Titel = scanner.next();
                                    String Teacher_name = scanner.next();
                                    if (hogwarts.Teacher_existance(Teacher_name)) {
                                        hogwarts.Add_course(Titel, hogwarts.Find_teacher(Teacher_name));
                                    } else {
                                        System.out.println("teacher not found");
                                    }
                                } else if (ob.equals("student")) {
                                    user_name = scanner.next();
                                    password = scanner.next();
                                    hogwarts.Add_Student(user_name, password);
                                } else if (ob.equals("comment")) {
                                    String cf = scanner.next();
                                    if (cf.equals("teacher")) {
                                        String name = scanner.next();
                                        if (hogwarts.Teacher_existance(name)) {
                                            String comment = scanner.next("");
                                            hogwarts.Find_teacher(name).Add_comment(comment);
                                        } else {
                                            System.out.println("teacher not found");
                                        }
                                    }
                                }
                            } else if (command.equals("set")) {
                                String ob = scanner.next();
                                String name = scanner.next();
                                if (ob.equals("teacher")) {
                                    if (hogwarts.Teacher_existance(name)) {
                                        Teacher teacher = hogwarts.Find_teacher(name);
                                        String attribute = scanner.next();
                                        if (attribute.equals("score")) {
                                            int score = scanner.nextInt();
                                            hogwarts.Find_teacher(name).setScore(score);
                                        }
                                    } else {
                                        System.out.println("teacher not found");
                                    }
                                }
                            } else if (command.equals("exit")) {
                                break;
                            } else {
                                System.out.println("command not find");
                            }
                        }
                    }
                }
                case "Teacher" -> {
                    System.out.println("Log in successfully");
                    while (true) {
                        System.out.println("give command");
                        String mode = scanner.next();
                        if (mode.equals("teacher")) {
                            String command = scanner.next();
                            if (command.equals("show")) {
                                String ob = scanner.next();
                                if (ob.equals("courses")) {
                                    hogwarts.viewAllCourses();
                                } else if (ob.equals("comments")) {
                                    hogwarts.Find_teacher(user_name).View_Teacher_comments(hogwarts.Find_teacher(user_name));
                                } else if (ob.equals("score")) {
                                    System.out.println(hogwarts.Find_teacher(user_name).getScore());
                                } else if (ob.equals("mycourses")) {
                                    hogwarts.View_Teacher_Courses(hogwarts.Find_teacher(user_name));
                                } else if (ob.equals("course")) {
                                    String name = scanner.next() ;
                                    if(hogwarts.Course_Existence(name))
                                    {
                                        if (hogwarts.Find_teacher(user_name).Course_Take(name))
                                        {
                                            hogwarts.Find_Course(name).Show_Course_student();
                                        }
                                    }
                                }
                            } else if (command.equals("Remove")) {
                                String ob = scanner.next();
                                if (ob.equals("teacher")) {

                                } else if (ob.equals("course")) {

                                } else if (ob.equals("assistant")) {

                                } else if (ob.equals("student")) {

                                }
                            } else if (command.equals("set")) {
                                String attribute = scanner.next() ;
                                String course_name = scanner.next() ;
                                String student_name = scanner.next() ;
                                int score = scanner.nextInt() ;
                                if (attribute.equals("score"))
                                {
                                    if (hogwarts.Find_teacher(user_name).Course_Take(course_name))
                                    {
                                        hogwarts.Find_Course(course_name).
                                    }
                                }
                            } else if (command.equals("exit")) {
                                break;
                            } else {
                                System.out.println("command not find");
                            }
                        }
                    }
                }
                case "Student" -> {
                }
                default -> System.out.println("Account mode not found :(");
            }

        }
    }
}
