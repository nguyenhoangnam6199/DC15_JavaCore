package Exercise_3;

import java.util.Comparator;

public class Student extends Human implements Comparator<Student>{
    private Integer grade;
    public Integer getGrade() {
        return grade;
    }
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }
    public Student(String firstName, String lastName, Integer grade) {
        super(firstName, lastName);
        this.grade = grade;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student [" + this.getFirstName() + "--" + this.getLastName() + " grade=" + grade + "]";
    }


    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGrade()-o2.getGrade();
    }
}
