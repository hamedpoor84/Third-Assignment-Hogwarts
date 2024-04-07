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
        hogwarts.fake_information();
        while (true) {
            boolean access = false;
            Scanner scanner = new Scanner(System.in);
            String character = null;
            String user_name = null;
            String password = null;
            while (!access) {
                System.out.println("welcome to hogwarts school");
                System.out.println("1- Login");
                System.out.println("2- Signup");
                String option = scanner.next();
                if (option.equals("1")) {
                    System.out.println("job : ");
                    System.out.println("1- Manager");
                    System.out.println("2- Assistant");
                    System.out.println("3- Teacher");
                    System.out.println("4- Student");
                    character = scanner.next();
                    System.out.println("user name :");
                    user_name = scanner.next();
                    System.out.println("password :");
                    password = scanner.next();
                    if (character.equals("1") && user_name.equals("hamed") && password.equals("1234")) {
                        access = true;
                    }
                    if (character.equals("3")) {
                        if (hogwarts.Teacher_Existence(user_name)) {
                            Teacher teacher = hogwarts.Find_teacher(user_name);
                            if (teacher.getPassword() == password.hashCode()) {
                                access = true;
                            } else {
                                System.out.println("your password is not correct");
                            }
                        } else {
                            System.out.println("your user name doesn't exist");
                        }
                    }
                    if (character.equals("2")) {
                        if (hogwarts.Assistant_Existence(user_name)) {
                            Assistant assistant = hogwarts.Find_Assistant(user_name);
                            if (assistant.getPassword() == password.hashCode()) {
                                access = true;
                            } else {
                                System.out.println("your password is not correct");
                            }
                        } else {
                            System.out.println("your user name doesn't exist");
                        }
                    }
                    if (character.equals("4")) {
                        if (hogwarts.Student_Existance(user_name)) {
                            Students students = hogwarts.Find_Student(user_name);
                            if (students.getPassword() == password.hashCode()) {
                                access = true;
                            } else {
                                System.out.println("your password is not correct");
                            }
                        } else {
                            System.out.println("your user name doesn't exist");
                        }
                    }
                } else if (option.equals("2")) {
                    while (!access) {
                        System.out.println("job you want : ");
                        System.out.println("1- Teacher");
                        System.out.println("2- Student");
                        character = scanner.next();
                        if (character.equals("1")) {
                            System.out.println("username you want : ");
                            user_name = scanner.next();
                            System.out.println("password you want : ");
                            password = scanner.next();
                            String request = user_name + " " + password;
                            hogwarts.Teacher_Requests(request);
                            break;
                        }
                        if (character.equals("2")) {
                            System.out.println("username you want : ");
                            user_name = scanner.next();
                            System.out.println("password you want : ");
                            password = scanner.next();
                            hogwarts.Add_Student(user_name, password);
                            access = true;
                        }
                    }
                }
                if (!access) {
                    System.out.println("Log in not successfully");
                }
            }
            switch (character) {
                case "1" -> {
                    System.out.println("Log in successfully");
                    while (true) {
                        System.out.println("give command");
                        System.out.println("1- Show");
                        System.out.println("2- Remove");
                        System.out.println("3- Add");
                        System.out.println("4- Set");
                        System.out.println("5- Exit");
                        String command = scanner.next();
                        if (command.equals("1")) {
                            System.out.println("1- Teachers");
                            System.out.println("2- Courses");
                            System.out.println("3- Students");
                            System.out.println("4- Assistants");
                            System.out.println("5- Teacher");
                            System.out.println("6- Course");
                            String ob = scanner.next();
                            if (ob.equals("1")) {
                                hogwarts.viewAllTeachers();
                            } else if (ob.equals("2")) {
                                hogwarts.viewAllCourses();
                            } else if (ob.equals("3")) {
                                hogwarts.viewAllStudents();
                            } else if (ob.equals("4")) {
                                hogwarts.viewAllAssistant();
                            } else if (ob.equals("5")) {
                                System.out.println("Name : ");
                                String name = scanner.next();
                                if (hogwarts.Teacher_Existence(name)) {
                                    Teacher teacher = hogwarts.Find_teacher(name);
                                    System.out.println("what information you want :");
                                    System.out.println("1- Comments");
                                    System.out.println("2- Score");
                                    System.out.println("3- Courses");
                                    String information = scanner.next();
                                    if (information.equals("1")) {
                                        teacher.View_Teacher_comments(teacher);
                                    } else if (information.equals("2")) {
                                        System.out.println(teacher.getScore());
                                    } else if (information.equals("3")) {
                                        hogwarts.View_Teacher_Courses(teacher);
                                    }
                                } else {
                                    System.out.println("teacher not found");
                                }
                            } else if (ob.equals("6")) {
                                System.out.println("name : ");
                                String name = scanner.next();
                                if (hogwarts.Teacher_Existence(name)) {
                                    Course course = hogwarts.Find_Course(name);
                                    System.out.println("what information you want : ");
                                    String information = scanner.next();
                                    System.out.println("1- Teacher");
                                    System.out.println("2- Students");
                                    if (information.equals("1")) {
                                        System.out.println(course.getTeacher());
                                    } else if (information.equals("2")) {
                                        course.Show_Course_student();
                                    }
                                } else {
                                    System.out.println("teacher not found");
                                }

                            }
                        } else if (command.equals("2")) {
                            System.out.println("1- Teacher");
                            System.out.println("2- Course");
                            System.out.println("3- Assistant");
                            System.out.println("4- Student");
                            String ob = scanner.next();
                            System.out.println("name : ");
                            String name = scanner.next();
                            if (ob.equals("1")) {
                                hogwarts.Remove_Teacher(name);
                            } else if (ob.equals("2")) {
                                hogwarts.Remove_Course(name);
                            } else if (ob.equals("3")) {

                            } else if (ob.equals("4")) {

                            }
                        } else if (command.equals("3")) {
                            System.out.println("1- Teacher");
                            System.out.println("2- Course");
                            System.out.println("3- Assistant");
                            System.out.println("4- Student");
                            System.out.println("5- Comment");
                            String ob = scanner.next();
                            if (ob.equals("1")) {
                                System.out.println("username : ");
                                user_name = scanner.next();
                                System.out.println("password : ");
                                password = scanner.next();
                                while (password.length() > 8) {
                                    System.out.println("your password might be more than 7 characters");
                                    System.out.println("Password : ");
                                    password = scanner.next();
                                }
                                hogwarts.Add_Teacher(user_name, password);
                            } else if (ob.equals("2")) {
                                System.out.println("Title : ");
                                String Title = scanner.next();
                                hogwarts.Add_Course(Title);
                            } else if (ob.equals("3")) {
                                System.out.println("username: ");
                                user_name = scanner.next();
                                System.out.println("password: ");
                                password = scanner.next();
                                while (password.length() > 8) {
                                    System.out.println("your password might be more than 7 characters");
                                    System.out.println("password :");
                                    password = scanner.next();
                                }
                                hogwarts.Add_Assistant(user_name, password);
                            } else if (ob.equals("4")) {
                                System.out.println("username: ");
                                user_name = scanner.next();
                                System.out.println("password");
                                password = scanner.next();
                                while (password.length() > 8) {
                                    System.out.println("your password might be more than 7 characters");
                                    System.out.println("password: ");
                                    password = scanner.next();
                                }
                                hogwarts.Add_Student(user_name, password);
                            } else if (ob.equals("5")) {
                                System.out.println("Comment for : ");
                                System.out.println("1- Teacher");
                                String cf = scanner.next();
                                if (cf.equals("1")) {
                                    System.out.println("Name: ");
                                    String name = scanner.next();
                                    if (hogwarts.Teacher_Existence(name)) {
                                        System.out.print("comment: ");
                                        scanner.nextLine(); // Consume the newline character
                                        String comment = scanner.nextLine();
                                        System.out.println(comment);
                                        hogwarts.Find_teacher(name).Add_comment(comment);
                                        System.out.println("comment successfully");
                                    } else {
                                        System.out.println("teacher not found");
                                    }
                                }
                                //TODO
                            }
                        } else if (command.equals("4")) {
                            System.out.println("job: ");
                            System.out.println("1- Teacher");
                            System.out.println("2- Student");
                            String ob = scanner.next();
                            System.out.println("name: ");
                            String name = scanner.next();
                            if (ob.equals("1")) {
                                if (hogwarts.Teacher_Existence(name)) {
                                    System.out.println("what information ?");
                                    System.out.println("1- Score");
//                                    System.out.println("2- Course");
                                    String attribute = scanner.next();
                                    if (attribute.equals("1")) {
                                        System.out.println("new score: ");
                                        int score = scanner.nextInt();
                                        hogwarts.Find_teacher(name).setScore(score);
                                    } else if (attribute.equals("2")) {
                                        //TODO
                                    }
                                } else {
                                    System.out.println("teacher not found");
                                }
                            } else if (ob.equals("2")) {
                                if (hogwarts.Student_Existance(name)) {
                                    System.out.println("what information ?");
                                    System.out.println("1- Score");
                                    String attribute = scanner.next();
                                    if (attribute.equals("score")) {
                                        int score = scanner.nextInt();
                                        hogwarts.Find_Student(name).setScore(score);
                                        System.out.println("score change successfully");
                                    }
                                } else {
                                    System.out.println("Student not found");
                                }
                            }
                        } else if (command.equals("5")) {
                            break;
                        } else {
                            System.out.println("command not find");
                        }
                    }
                }
                case "2" -> {
                    System.out.println("Log in successfully");
                    while (true) {
                        System.out.println("give command");
                        System.out.println("1- Show");
                        System.out.println("2- Remove");
                        System.out.println("3- Add");
                        System.out.println("4- Set");
                        System.out.println("5- Exit");
                        String command = scanner.next();
                        if (command.equals("1")) {
                            System.out.println("1- Teachers");
                            System.out.println("2- Courses");
                            System.out.println("3- Students");
                            System.out.println("4- Teacher");
                            System.out.println("5- Course");
                            String ob = scanner.next();
                            if (ob.equals("1")) {
                                hogwarts.viewAllTeachers();
                            } else if (ob.equals("2")) {
                                hogwarts.viewAllCourses();
                            } else if (ob.equals("3")) {
                                hogwarts.viewAllStudents();
                            } else if (ob.equals("4")) {
                                System.out.println("Name : ");
                                String name = scanner.next();
                                if (hogwarts.Teacher_Existence(name)) {
                                    Teacher teacher = hogwarts.Find_teacher(name);
                                    System.out.println("what information you want :");
                                    System.out.println("1- Comments");
                                    System.out.println("2- Score");
                                    System.out.println("3- Courses");
                                    String information = scanner.next();
                                    if (information.equals("1")) {
                                        teacher.View_Teacher_comments(teacher);
                                    } else if (information.equals("2")) {
                                        System.out.println(teacher.getScore());
                                    } else if (information.equals("3")) {
                                        hogwarts.View_Teacher_Courses(teacher);
                                    }
                                } else {
                                    System.out.println("teacher not found");
                                }
                            } else if (ob.equals("5")) {
                                System.out.println("name : ");
                                String name = scanner.next();
                                if (hogwarts.Teacher_Existence(name)) {
                                    Course course = hogwarts.Find_Course(name);
                                    System.out.println("what information you want : ");
                                    String information = scanner.next();
                                    System.out.println("1- Teacher");
                                    System.out.println("2- Students");
                                    if (information.equals("1")) {
                                        System.out.println(course.getTeacher());
                                    } else if (information.equals("2")) {
                                        course.Show_Course_student();
                                    }
                                } else {
                                    System.out.println("teacher not found");
                                }

                            }
                        } else if (command.equals("2")) {
                            System.out.println("1- Teacher");
                            System.out.println("2- Course");
                            System.out.println("3- Student");
                            String ob = scanner.next();
                            System.out.println("name : ");
                            String name = scanner.next();
                            if (ob.equals("1")) {
                                hogwarts.Remove_Teacher(name);
                            } else if (ob.equals("2")) {
                                hogwarts.Remove_Course(name);
                            } else if (ob.equals("3")) {

                            }
                        } else if (command.equals("3")) {
                            System.out.println("1- Teacher");
                            System.out.println("2- Course");
                            System.out.println("3- Student");
                            System.out.println("4- Comment");
                            String ob = scanner.next();
                            if (ob.equals("1")) {
                                System.out.println("username : ");
                                user_name = scanner.next();
                                System.out.println("password : ");
                                password = scanner.next();
                                while (password.length() > 8) {
                                    System.out.println("your password might be more than 7 characters");
                                    System.out.println("Password : ");
                                    password = scanner.next();
                                }
                                hogwarts.Add_Teacher(user_name, password);
                            } else if (ob.equals("2")) {
                                System.out.println("Title : ");
                                String Title = scanner.next();
                                hogwarts.Add_Course(Title);
                            } else if (ob.equals("3")) {
                                System.out.println("username: ");
                                user_name = scanner.next();
                                System.out.println("password");
                                password = scanner.next();
                                while (password.length() > 8) {
                                    System.out.println("your password might be more than 7 characters");
                                    System.out.println("password: ");
                                    password = scanner.next();
                                }
                                hogwarts.Add_Student(user_name, password);
                            } else if (ob.equals("4")) {
                                System.out.println("Comment for : ");
                                System.out.println("1- Teacher");
                                String cf = scanner.next();
                                if (cf.equals("1")) {
                                    System.out.println("Name: ");
                                    String name = scanner.next();
                                    if (hogwarts.Teacher_Existence(name)) {
                                        System.out.print("comment: ");
                                        scanner.nextLine(); // Consume the newline character
                                        String comment = scanner.nextLine();
                                        System.out.println(comment);
                                        hogwarts.Find_teacher(name).Add_comment(comment);
                                        System.out.println("comment successfully");
                                    } else {
                                        System.out.println("teacher not found");
                                    }
                                }
                                //TODO
                            }
                        } else if (command.equals("4")) {
                            System.out.println("job: ");
                            System.out.println("1- Teacher");
                            System.out.println("2- Student");
                            String ob = scanner.next();
                            System.out.println("name: ");
                            String name = scanner.next();
                            if (ob.equals("1")) {
                                if (hogwarts.Teacher_Existence(name)) {
                                    System.out.println("what information ?");
                                    System.out.println("1- Score");
//                                    System.out.println("2- Course");
                                    String attribute = scanner.next();
                                    if (attribute.equals("1")) {
                                        System.out.println("new score: ");
                                        int score = scanner.nextInt();
                                        hogwarts.Find_teacher(name).setScore(score);
                                    } else if (attribute.equals("2")) {
                                        //TODO
                                    }
                                } else {
                                    System.out.println("teacher not found");
                                }
                            } else if (ob.equals("2")) {
                                if (hogwarts.Student_Existance(name)) {
                                    System.out.println("what information ?");
                                    System.out.println("1- Score");
                                    String attribute = scanner.next();
                                    if (attribute.equals("1")) {
                                        int score = scanner.nextInt();
                                        hogwarts.Find_Student(name).setScore(score);
                                        System.out.println("score change successfully");
                                    }
                                } else {
                                    System.out.println("Student not found");
                                }
                            }
                        } else if (command.equals("5")) {
                            break;
                        } else {
                            System.out.println("command not find");
                        }
                    }
                }
                case "3" -> {
                    System.out.println("Log in successfully");
                    while (true) {
                        System.out.println("give command");
                        System.out.println("1- Show");
                        System.out.println("2- Set score");
                        System.out.println("3- Send request");
                        System.out.println("4- Take course");
                        System.out.println("5- Exit");
                        String command = scanner.next();
                        if (command.equals("1")) {
                            System.out.println("Show what ? ");
                            System.out.println("1- Courses");
                            System.out.println("2- Comments");
                            System.out.println("3- Score");
                            System.out.println("4- My courses");
                            System.out.println("5- Course");
                            String ob = scanner.next();
                            if (ob.equals("1")) {
                                hogwarts.viewAllCourses();
                            } else if (ob.equals("2")) {
                                hogwarts.Find_teacher(user_name).View_Teacher_comments(hogwarts.Find_teacher(user_name));
                            } else if (ob.equals("3")) {
                                System.out.println(hogwarts.Find_teacher(user_name).getScore());
                            } else if (ob.equals("4")) {
                                hogwarts.View_Teacher_Courses(hogwarts.Find_teacher(user_name));
                            } else if (ob.equals("5")) {
                                System.out.println("course name :");
                                String name = scanner.next();
                                if (hogwarts.Course_Existence(name)) {
                                    if (hogwarts.Find_teacher(user_name).Course_Take(name)) {
                                        hogwarts.Find_Course(name).Show_Course_student();
                                    } else {
                                        System.out.println("you don't have access to this course!!!");
                                    }
                                } else {
                                    System.out.println("course not exist");
                                }
                            }
                        } else if (command.equals("2")) {
                            hogwarts.Score_Students(hogwarts.Find_teacher(user_name));
                        } else if (command.equals("3")) {
                            scanner.nextLine();
                            System.out.println("request : ");
                            String request = scanner.nextLine();
                            hogwarts.Teacher_Requests(request);
                        }  else if (command.equals("4")) {
                            System.out.println("course name : ");
                            String course = scanner.next() ;
                            hogwarts.takeCourse(course,user_name);
                            System.out.println("mission accomplished");
                        } else if (command.equals("5")) {
                            break;
                        } else {
                            System.out.println("command not find");
                        }
                    }
                }
                case "4" -> {
                    System.out.println("Log in successfully");
                    while (true) {
                        System.out.println("give command");
                        System.out.println("1- Show");
                        System.out.println("2- Send massage");
                        System.out.println("3- take course");
                        System.out.println("4- Exit");
                        String command = scanner.next();
                        if (command.equals("1")) {
                            System.out.println("1- courses");
                            System.out.println("2- score");
                            System.out.println("3- my courses");
                            String ob = scanner.next();
                            if (ob.equals("1")) {
                                hogwarts.viewAllCourses();
                            } else if (ob.equals("2")) {
                                System.out.println(hogwarts.Find_teacher(user_name).getScore());
                            } else if (ob.equals("3")) {
                                hogwarts.View_Teacher_Courses(hogwarts.Find_teacher(user_name));
                            }
                        } else if (command.equals("2")) {
                            System.out.print("massage : ");
                            scanner.nextLine() ;
                            String request = scanner.nextLine();
                            hogwarts.Teacher_Requests(request);
                        } else if (command.equals("3")) {
                            System.out.println("title: ");
                            String title = scanner.next();
                            if (hogwarts.Course_Existence(title)) {
                                hogwarts.Add_Student_Course(hogwarts.Find_Course(title), hogwarts.Find_Student(user_name));
                            }
                        } else if (command.equals("4")) {
                            break;
                        } else {
                            System.out.println("command not find");
                        }
                    }
                }
                default -> System.out.println("Account mode not found :(");
            }
        }
    }
}



