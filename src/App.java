import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GenericCRUD<Student> studentCRUD = new GenericCRUD<>();
        GenericCRUD<Course> courseCRUD = new GenericCRUD<>();
        GenericCRUD<Transcript> transcriptCRUD = new GenericCRUD<>();

        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Transcript> transcripts = new ArrayList<>();

        while (true) {
            System.out.println("\nChoose entity:");
            System.out.println("1. Student");
            System.out.println("2. Course");
            System.out.println("3. Transcript");
            System.out.println("4. Reports (StudentService)");
            System.out.println("0. Exit");
            int entityChoice = Integer.parseInt(sc.nextLine());
            if (entityChoice == 0) break;

            switch (entityChoice) {
                case 1 -> {
                    System.out.println("\nStudent:");
                    System.out.println("1. Add");
                    System.out.println("2. Delete");
                    System.out.println("3. ShowAll");
                    System.out.println("4. Search by ID");
                    System.out.println("0. Exit");
                    int c = Integer.parseInt(sc.nextLine());
                    switch (c) {
                        case 1 -> {
                            Student s = new Student();
                            s.input();
                            studentCRUD.add(s);
                            students.add(s);
                        }
                        case 2 -> {
                            System.out.print("Enter student ID to delete: ");
                            String id = sc.nextLine();
                            if (studentCRUD.delete(id)) {
                                students.removeIf(st -> st.getStudentId().equalsIgnoreCase(id));
                                System.out.println("Deleted.");
                            } else {
                                System.out.println("Not found.");
                            }
                        }
                        case 3 -> studentCRUD.showAll();
                        case 4 -> {
                            System.out.print("Enter student ID to search: ");
                            String id = sc.nextLine();
                            Student found = studentCRUD.search(id);
                            if (found != null) {
                                System.out.println("Found student:");
                                System.out.println(found);
                            } else {
                                System.out.println("Student not found.");
                            }
                        }
                    }
                }
                case 2 -> {
                    System.out.println("\nCourse:");
                    System.out.println("1. Add");
                    System.out.println("2. Delete");
                    System.out.println("3. ShowAll");
                    System.out.println("4. Search by ID");
                    System.out.println("0. Exit");
                    int c = Integer.parseInt(sc.nextLine());
                    switch (c) {
                        case 1 -> {
                            Course course = new Course();
                            course.input();
                            courseCRUD.add(course);
                            courses.add(course);
                        }
                        case 2 -> {
                            System.out.print("Enter course ID to delete: ");
                            String id = sc.nextLine();
                            if (courseCRUD.delete(id)) {
                                courses.removeIf(co -> co.getCourseID().equalsIgnoreCase(id));
                                System.out.println("Deleted.");
                            } else {
                                System.out.println("Not found.");
                            }
                        }
                        case 3 -> courseCRUD.showAll();
                        case 4 -> {
                            System.out.print("Enter course ID to search: ");
                            String id = sc.nextLine();
                            Course found = courseCRUD.search(id);
                            if (found != null) {
                                System.out.println("Found course:");
                                System.out.println(found);
                            } else {
                                System.out.println("Course not found.");
                            }
                        }
                    }
                }
                case 3 -> {
                    System.out.println("\nTranscript:");
                    System.out.println("1. Add");
                    System.out.println("2. Delete");
                    System.out.println("3. ShowAll");
                    System.out.println("4. Search by ID (studentId-courseId)");
                    System.out.println("0. Exit");
                    int c = Integer.parseInt(sc.nextLine());
                    switch (c) {
                        case 1 -> {
                            Transcript t = new Transcript();
                            t.input();
                            transcriptCRUD.add(t);
                            transcripts.add(t);
                        }
                        case 2 -> {
                            System.out.print("Enter transcript ID to delete (studentId-courseId): ");
                            String id = sc.nextLine();
                            if (transcriptCRUD.delete(id)) {
                                transcripts.removeIf(tr -> tr.getId().equalsIgnoreCase(id));
                                System.out.println("Deleted.");
                            } else {
                                System.out.println("Not found.");
                            }
                        }
                        case 3 -> transcriptCRUD.showAll();
                        case 4 -> {
                            System.out.print("Enter transcript ID to search (studentId-courseId): ");
                            String id = sc.nextLine();
                            Transcript found = transcriptCRUD.search(id);
                            if (found != null) {
                                System.out.println("Found transcript:");
                                System.out.println(found);
                            } else {
                                System.out.println("Transcript not found.");
                            }
                        }
                    }
                }
                case 4 -> {
                    System.out.println("\nReports:");
                    System.out.println("1. Display students in semester");
                    System.out.println("2. Display courses taken by student");
                    System.out.println("3. Display grade report by semester");
                    System.out.println("0. Exit");
                    int c = Integer.parseInt(sc.nextLine());
                    switch (c) {
                        case 1 -> {
                            System.out.print("Enter semester: ");
                            String semester = sc.nextLine();
                            StudentService.displayStudentsInSemester(transcripts, students, semester);
                        }
                        case 2 -> {
                            System.out.print("Enter student ID: ");
                            String studentId = sc.nextLine();
                            StudentService.displayCoursesByStudentId(transcripts, courses, studentId);
                        }
                        case 3 -> {
                            System.out.print("Enter semester: ");
                            String semester = sc.nextLine();
                            StudentService.displayGradeReport(transcripts, students, courses, semester);
                        }
                    }
                }
            }
        }

        sc.close();
    }
}
