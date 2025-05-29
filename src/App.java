import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GenericCRUD<Student> studentCRUD = new GenericCRUD<>();
        GenericCRUD<Course> courseCRUD = new GenericCRUD<>();
        GenericCRUD<Transcript> transcriptCRUD = new GenericCRUD<>();

        while (true) {
            System.out.println("\nChoose entity:");
            System.out.println("1. Student");
            System.out.println("2. Course");
            System.out.println("3. Transcript");
            System.out.println("0. Exit");
            int entityChoice = Integer.parseInt(sc.nextLine());
            if (entityChoice == 0) break;

            switch (entityChoice) {
                case 1 -> {
                    System.out.println("\nStudent:");
                    System.out.println("1. Add");
                    System.out.println("2. Delete");
                    System.out.println("3. ShowAll");
                    System.out.println("0. Exit");
                    int c = Integer.parseInt(sc.nextLine());
                    switch (c) {
                        case 1 -> {
                            Student s = new Student();
                            s.input();
                            studentCRUD.add(s);
                        }
                        case 2 -> {
                            System.out.print("Enter student ID to delete: ");
                            String id = sc.nextLine();
                            if (studentCRUD.delete(id))
                                System.out.println("Deleted.");
                            else
                                System.out.println("Not found.");
                        }
                        case 3 -> studentCRUD.showAll();
                    }
                }
                case 2 -> {
                    System.out.println("\nCourse:");
                    System.out.println("1. Add");
                    System.out.println("2. Delete");
                    System.out.println("3. ShowAll");
                    System.out.println("0. Exit");
                    int c = Integer.parseInt(sc.nextLine());
                    switch (c) {
                        case 1 -> {
                            Course course = new Course();
                            course.input();
                            courseCRUD.add(course);
                        }
                        case 2 -> {
                            System.out.print("Enter course ID to delete: ");
                            String id = sc.nextLine();
                            if (courseCRUD.delete(id))
                                System.out.println("Deleted.");
                            else
                                System.out.println("Not found.");
                        }
                        case 3 -> courseCRUD.showAll();
                    }
                }
                case 3 -> {
                    System.out.println("\nTranscript:");
                    System.out.println("1. Add");
                    System.out.println("2. Delete");
                    System.out.println("3. ShowAll");
                    System.out.println("0. Exit");
                    int c = Integer.parseInt(sc.nextLine());
                    switch (c) {
                        case 1 -> {
                            Transcript t = new Transcript();
                            t.input();  // Nhập student, course, điểm...
                            transcriptCRUD.add(t);
                        }
                        case 2 -> {
                            System.out.print("Enter transcript ID (studentId-courseId): ");
                            String id = sc.nextLine();
                            if (transcriptCRUD.delete(id))
                                System.out.println("Deleted.");
                            else
                                System.out.println("Not found.");
                        }
                        case 3 -> transcriptCRUD.showAll();
                    }
                }
            }
        }

        sc.close();
    }
}
