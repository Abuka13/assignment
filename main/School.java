import java.util.ArrayList;

public class School {
    private ArrayList<Person> members;

    public School() {
        this.members = new ArrayList<>();
    }

    public ArrayList<Person> getMembers() {
        return new ArrayList<>(members); // Return a copy to protect encapsulation
    }

    public ArrayList<Teacher> getTeachers() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (Person member : members) {
            if (member instanceof Teacher) {
                teachers.add((Teacher) member);
            }
        }
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (Person member : members) {
            if (member instanceof Student) {
                students.add((Student) member);
            }
        }
        return students;
    }

    public void addMember(Person member) {
        if (member != null) {
            members.add(member);
        } else {
            throw new IllegalArgumentException("Member cannot be null");
        }
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        for (Person member : members) {
            msg.append(member.toString()).append("\n");
        }
        return msg.toString();
    }
}
