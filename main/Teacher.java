public class Teacher extends Person {
    private String subject;
    private int yearsOfExperience;
    private int salary;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (subject == null || subject.isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be null or empty");
        }
        this.subject = subject;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Years of experience cannot be negative");
        }
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    public void giveRaise(int percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Raise percentage cannot be negative");
        }
        this.salary += salary * percentage / 100.0;
    }

    @Override
    public String toString() {
        return super.toString() + ". I teach " + subject + " with " + yearsOfExperience + " years of experience.";
    }
}
