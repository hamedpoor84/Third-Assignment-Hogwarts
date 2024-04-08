* # Third Assignment: Hogwarts School Management System 🧙‍♂️

  Welcome to my little project for managing the Hogwarts school. In this report you will learn how to work 
  with this system and learn the commands you should use with.

  ## Prerequisites ✅

  Before diving into the enchanting world of Hogwarts, ensure you have the following prerequisites installed on your magical workstation:

  - Java 21
  - Git
  - Gradle as a package manager

  ## Working With The Classes 💡

  In this section you will learn about each class accessibility and features each of them have
  to manage and work with.

  ### Manager(Hogwarts) class:

  Serving as a central management system for Hogwarts School of Witchcraft and Wizardry, the Hogwarts class facilitates various actions for teachers, students, and administrators.

  - Managing lists of teachers, courses, assistants, and students. for these actions there are several commands you can use explained below :
    - **add**: with this command you can add a student or teacher or assistant or a creating a new course. you can see a template of that below:
      ```
      Manager add <object> <username> <password> // for adding account
      Manager add coures <title> // to add a course
      ```
      for example now I create an account of "hamed" as an student with password "1234":
      ```
      Manager add student hamed 1234
      ```
    - **delete**: with this command you can delete any account that exists from database:
      ```
      Manager delete <object> <username>
      ```
    
  - Rating teachers and leaving comments for them. For that matter you can use commands:
    - **comment**: comment any one you want with any accounts you want!
      
      ```
      comment <object> <username> <message text> 
      ```
    
  - Viewing all teachers, students, and courses:
    - **set**: if you set something you shoud use this command 
    
    - ```
      manager set teacher <user_name> score <number>
      ```
    
    - ```
      manager set student <user_name> score <number>
      ```
    
    - **show**: you can show every thing of every one if you get correct command . for example 
    
      - ```
        manager show students   or   manager show assistant <user_name> requests
        ```
    
      - ```
        manager show teachers   or   manger show teacher <user_name> comments
        ```
    
      - ```
        manager show courses   or   manager show teacher <user_name> courses
        ```
    
      - ```
        manager show assistants   or   manger show teacher <user_name> score
        ```

  ### Teacher class:

  - **Sign Up**: Teachers can sign up by following these steps:
    - choose signup option 
    - type username and password. Then the informations will be sent to assistant ,then the he make decision about create account .  
  - **Take Courses**: Teachers can explore and enroll in courses they wish to teach,to do that the command is like below :
      ```
      teacher take_coures <course title>
      ```
  - **View Courses List**: Access a comprehensive list of courses they teach for an overview of current teaching assignments.
      
      ```
      teacher show courses
      ```
  - **View Course's List of Students**: Check the list of students enrolled in specific courses to monitor their progress.
      
      ```
      teahcer show course <Title> students
      ```
  ### Assistant class:

  The assistant serves as an administrative tool, allowing administrators to create accounts, manage users, courses, and perform various administrative tasks to ensure smooth operation of the platform.

  mostly of assistant command is as same as manager command.

  - **Add Account**: Like managers ,assistants also can add account from each group.
  - **Remove a Teacher/Student**: Like managers, assistants also can remove an account from database.Follow command like managers.
  - **View Courses and Their List of Students**: Follow mangers commands for this matter too.
  - **Check Student/Teacher Profile**: Follow mangers commands for this matter too.

  ### Student class:

  Students can perform various actions within the Hogwarts School Management System, including taking courses, viewing teachers, and participating in sorting quizzes.

  - **Taking Courses**: 
      
      ```
      student take_course
      ```
  - **Viewing All Courses Taken**: View a list of all courses taken.
      
      ```
      student show mycourses
      ```
      
  - **send_request**: send massage for assistants.
      
      ```
      student send_request 
      massager : <massage>
      ```

  - **Viewing All Courses**: View a list of all courses .

    ```
    student show courses
    ```

  - 

  ## Authors

  * [hamed_pouraghniaei](blahblah.com)
  * [mohammad jafari](blahblah.com)

  ## Contact with us
  For any problem or suggestion contact with us!
  * [telegram](https://t.me/hamedpoor84)
  * [instagram](https://t.me/hamedpoor84)
  * [personal website](https://t.me/hamedpoor84)