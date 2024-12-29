import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        try {
            Scanner scanner = new Scanner(new File("main/data/students.txt"));
            String line;

            while (scanner.hasNextLine()) {
                Student student = new Student();
                line = scanner.nextLine();

                String[] attributes = line.split("\\s+");
                student.setName(attributes[0]);
                student.setSurname(attributes[1]);
                student.setAge(Integer.parseInt(attributes[2]));
                student.setGender(attributes[3]);

                for (int i = 4; i < attributes.length; i++) {
                    student.addGrade(Integer.parseInt(attributes[i]));
                }

                school.addMember(student);
            }

            scanner = new Scanner(new File("main/data/teachers.txt"));

            while (scanner.hasNextLine()) {
                Teacher teacher = new Teacher();
                line = scanner.nextLine();

                String[] attributes = line.split("\\s+");
                teacher.setName(attributes[0]);
                teacher.setSurname(attributes[1]);
                teacher.setAge(Integer.parseInt(attributes[2]));
                teacher.setGender(attributes[3]);
                teacher.setSubject(attributes[4]);
                teacher.setYearsOfExperience(Integer.parseInt(attributes[5]));
                teacher.setSalary(Integer.parseInt(attributes[6]));

                school.addMember(teacher);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(school.toString());
        System.out.printf("GPA - %.2f\n", school.getStudents().get(1).calculateGPA());

        System.out.println("Before raise - $" + school.getTeachers().getFirst().getSalary());
        school.getTeachers().getFirst().giveRaise(10);
        System.out.println("After raise - $" + school.getTeachers().getFirst().getSalary());
    }
}
