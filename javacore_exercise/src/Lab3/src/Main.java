public class Main {
    private static Class aClass = new Class();
    private static Student student = new Student();
    private static Teacher teacher = new Teacher();
    private static Decipline decipline = new Decipline();
    public static void main(String[] args) {
        System.out.println("List of class: ");
        aClass.getAllClasses();
        System.out.println("List of student: ");
        student.getAllStudents();
        System.out.println("List of teacher: ");
        teacher.getAllTeachers();
        System.out.println("List of decipine: ");
        decipline.getAllDeciplines();
    }
}
