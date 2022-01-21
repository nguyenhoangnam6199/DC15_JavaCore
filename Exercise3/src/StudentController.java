import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentController {
    public static Connection connection = ConnectDB.getConnect();
    public static PreparedStatement preparedStatement;

    //Get All Data
    public static void GetAllStudent(){
        String sql = "SELECT * FROM student";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs =  preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println("student_id: "+rs.getString(1)+" - student_name: "
                        +rs.getString(2)+" - class_id: "+rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Insert Data
    public static void InsertStudent(String student_name,String class_id){
        String sql = "INSERT INTO student (student_name,class_id) VALUES(?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student_name);
            preparedStatement.setString(2, class_id);
            preparedStatement.executeUpdate();
            System.out.println("Insert successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void UpdateStudent(int id, String student_name, String class_id){
        String sql = "UPDATE student SET student_name=?, class_id=? WHERE student_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student_name);
            preparedStatement.setString(2,class_id);
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
            System.out.println("Update successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void DeleteStudent(int id){
        String sql = "DELETE FROM student WHERE student_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Delete successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean CheckIdClass(String id){
        boolean kt = false;
        String sql = "SELECT * FROM class WHERE class_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                kt = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kt;
    }

    public static boolean CheckID(int id){
        boolean kt = false;
        String sql = "SELECT * FROM student WHERE student_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                kt = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kt;
    }

    public static boolean CheckName(String name){
        boolean kt = false;
        String sql = "SELECT * FROM student WHERE student_name=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                kt = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        do{
            System.out.println("=====MENU======");
            System.out.println("1. Insert student");
            System.out.println("2. List of student");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("0. Exit");
            System.out.println("Choose function: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 0:{
                    System.err.println(" Ending ! ");
                    break;
                }
                case 1:{
                    String class_id;
                    String name;
                    do {
                        System.out.println("enter student name: ");
                        name = sc.nextLine();
                    }while (name.isEmpty() || CheckName(name)==true);
                    do {
                        System.out.println("enter class id: ");
                        class_id = sc.nextLine();
                    }while (class_id.isEmpty() || CheckIdClass(class_id)==false);


                    InsertStudent(name,class_id);
                    break;
                }
                case 2:{
                    System.out.println("List of student: ");
                    GetAllStudent();
                    break;
                }
                case 3:{
                    int id;
                    String class_id, name;
                    System.out.println("enter id student: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    if(CheckID(id)==true){
                        do {
                            System.out.println("enter student name: ");
                            name = sc.nextLine();
                        }while (name.isEmpty() || CheckName(name)==true);

                        do {
                            System.out.println("enter class id: ");
                            class_id = sc.nextLine();
                        }while(class_id.isEmpty() || CheckIdClass(class_id)==false);

                        UpdateStudent(id, name, class_id);
                    }
                    else{
                        System.out.println("Can not find student with id= "+id);
                    }
                    break;
                }
                case 4:{
                    int id;
                    System.out.println("enter student id: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    if(CheckID(id)==true){
                        DeleteStudent(id);
                    }
                    else{
                        System.out.println("Can not find student with id= "+id);
                    }
                }
            }
        }while (choose != 0);
    }
}
