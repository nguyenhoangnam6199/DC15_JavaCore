import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TeacherController {
    public static Connection connection = ConnectDB.getConnect();
    public static PreparedStatement preparedStatement;

    //Get All Data
    public static void GetAllTeacher(){
        String sql = "SELECT * FROM teacher";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs =  preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println("teacher_id: "+rs.getString(1)+" - teacher_name: "
                        +rs.getString(2)+" - class_id: "+rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Insert Data
    public static void InsertTeacher(String teacher_name,String class_id){
        String sql = "INSERT INTO teacher (teacher_name,class_id) VALUES(?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,teacher_name);
            preparedStatement.setString(2, class_id);
            preparedStatement.executeUpdate();
            System.out.println("Insert successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void UpdateTeacher(int id, String teacher_name, String class_id){
        String sql = "UPDATE teacher SET teacher_name=?, class_id=? WHERE teacher_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,teacher_name);
            preparedStatement.setString(2,class_id);
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
            System.out.println("Update successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void DeleteTeacher(int id){
        String sql = "DELETE FROM teacher WHERE teacher_id=?";
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
        String sql = "SELECT * FROM teacher WHERE teacher_id=?";
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
        String sql = "SELECT * FROM teacher WHERE teacher_name=?";
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
            System.out.println("1. Insert teacher");
            System.out.println("2. List of teacher");
            System.out.println("3. Update teacher");
            System.out.println("4. Delete teacher");
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
                        System.out.println("enter teacher name: ");
                        name = sc.nextLine();
                    }while (name.isEmpty() || CheckName(name)==true);
                    do {
                        System.out.println("enter class id: ");
                        class_id = sc.nextLine();
                    }while (class_id.isEmpty() || CheckIdClass(class_id)==false);


                    InsertTeacher(name,class_id);
                    break;
                }
                case 2:{
                    System.out.println("List of teacher: ");
                    GetAllTeacher();
                    break;
                }
                case 3:{
                    int id;
                    String class_id, name;
                    System.out.println("enter id teacher: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    if(CheckID(id)==true){
                        do {
                            System.out.println("enter teacher name: ");
                            name = sc.nextLine();
                        }while (name.isEmpty() || CheckName(name)==true);

                        do {
                            System.out.println("enter class id: ");
                            class_id = sc.nextLine();
                        }while(class_id.isEmpty() || CheckIdClass(class_id)==false);

                        UpdateTeacher(id, name, class_id);
                    }
                    else{
                        System.out.println("Can not find teacher with id= "+id);
                    }
                    break;
                }
                case 4:{
                    int id;
                    System.out.println("enter teacher id: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    if(CheckID(id)==true){
                        DeleteTeacher(id);
                    }
                    else{
                        System.out.println("Can not find teacher with id= "+id);
                    }
                }
            }
        }while (choose != 0);
    }
}
