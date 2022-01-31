package ru.korchevoyeo.lesson5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.korchevoyeo.lesson5.config.AppConfig;
import ru.korchevoyeo.lesson5.entity.Student;
import ru.korchevoyeo.lesson5.service.StudentService;

import java.util.Scanner;

import static java.util.Objects.nonNull;

public class MainApp {

    private static StudentService studentService;
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean interrupt = false;
    private static Student student;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        studentService = context.getBean(StudentService.class);

        while (true) {
            System.out.println("Type \"help\" for get available commands list. Waiting for command: ");
            String command = scanner.nextLine();
            try {
                processCommand(command.toLowerCase());
            } catch (Exception exception) {
                System.out.println("Error! " + exception.getMessage());
                continue;
            }
            if (interrupt) {
                break;
            }
        }
        context.close();
    }

    private static void processCommand(String command) throws Exception {
        String[] args = command.trim().split("\\s+");
        switch (args[0]) {
            case "":
                break;
            case "help":
                printHelp();
                break;
            case "exit":
                interrupt = true;
                System.out.println("Bye");
                break;
            case "new":
                student = new Student(null, args[1], Integer.parseInt(args[2]));
                System.out.println("New student created: " + student);
                break;
            case "save":
                if (nonNull(student)) {
                    student = studentService.save(student);
                    System.out.println("New student: " + student.toString() + " - saved!");
                    student = null;
                } else {
                    System.out.println("Error! Create new student first!");
                }
                break;
            case "delete":
                studentService.deleteById(Long.valueOf(args[1]));
                System.out.println("Student with id " + Long.valueOf(args[1]) + " was deleted!");
                break;
            case "update":
                Student studentForUpdate = new Student(Long.valueOf(args[1]), args[2], Integer.parseInt(args[3]));
                studentService.update(studentForUpdate);
                System.out.println("Student updated!");
                break;
            case "find":
                Student student = studentService.findById(Long.valueOf(args[1]));
                System.out.println("Student: " + student.toString());
                break;
            case "all":
                System.out.println("All students: ");
                System.out.println(studentService.findAll());
                break;
            default:
                throw new Exception("Wrong command: " + command);
        }
    }

    private static void printHelp() {
        System.out.println("********************");
        System.out.println("Available commands:");
        System.out.println("help - print this help;");
        System.out.println("exit - close app;");
        System.out.println("new <name> <mark> - create new student with <name> and <mark>;");
        System.out.println("save - save new student, which was created by command \"new\";");
        System.out.println("delete <id> - delete student with <id>;");
        System.out.println("update <id> <name> <mark> - update student;");
        System.out.println("find <id> - get student by <id>;");
        System.out.println("all - get list of all students;");
        System.out.println("********************");
    }
}
