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
            String user_name;
            String password;
            System.out.println("welcome to hogwarts school");
            System.out.println("please Sigh_up or Log_in");
            System.out.println("choose an Account mode");
            System.out.println("1- Manager   2- Assitant   3- Teacher   4- Student");
            Scanner scanner = new Scanner(System.in);
            String character = scanner.next();
            if (character.equals("Manager")) {
                while (!access) {
                    System.out.println("get the user name and password : ");
                    user_name = scanner.next();
                    password = scanner.next();
                    access = hogwarts.maneger_Log_in(user_name, password);
                }
                System.out.println("Log in sucessfully");
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
                                if (hogwarts.Teacher_existance(name))
                                {
                                    Teacher teacher = hogwarts.Find_teacher(name) ;
                                    String information = scanner.next() ;
                                    if (information.equals("comments"))
                                    {
                                        teacher.View_Teacher_comments(teacher);
                                    } else if (information.equals("score")) {
                                        System.out.println(teacher.getScore());
                                    } else if (information.equals("courses")) {
                                        teacher.View_Teacher_comments(teacher);
                                    }
                                }else {
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
                                String Titel = scanner.next() ;
                                String Teacher_name = scanner.next() ;
                                if (hogwarts.Teacher_existance(Teacher_name))
                                {
                                    hogwarts.Add_course(Titel ,hogwarts.Find_teacher(Teacher_name));
                                }else {
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
                            }
                        } else if (command.equals("exit")) {
                            break ;
                        } else {
                            System.out.println("command not find");
                        }
                    }
                }
            } else if (character.equals("Assitant")) {

            } else if (character.equals("Teacher")) {

            } else if (character.equals("Student")) {

            } else {
                System.out.println("Account mode not found :(");
            }

        }
    }
}
