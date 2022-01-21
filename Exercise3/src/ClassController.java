import java.sql.*;
import java.util.Scanner;

public class ClassController {
    public static Connection connection = ConnectDB.getConnect();
    public static PreparedStatement preparedStatement;

    //Get All Data
    public static void GetAllClass(){
        String sql = "SELECT * FROM class";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs =  preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println("class_id: "+rs.getString(1)+" - class_name: "+rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Insert Data
    public static void InsertClass(String class_id,String class_name){
        String sql = "INSERT INTO class (class_id,class_name) VALUES(?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,class_id);
            preparedStatement.setString(2, class_name);
            preparedStatement.executeUpdate();
            System.out.println("Insert successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void UpdateClass(String id, String new_name){
        String sql = "UPDATE class SET class_name=? WHERE class_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,new_name);
            preparedStatement.setString(2,id);
            preparedStatement.executeUpdate();
            System.out.println("Update successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void DeleteClass(String id){
        String sql = "DELETE FROM class WHERE class_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Delete successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean CheckID(String id){
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

    public static boolean CheckName(String name){
        boolean kt = false;
        String sql = "SELECT * FROM class WHERE class_name=?";
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

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        do{
            System.out.println("=====MENU======");
            System.out.println("1. Insert class");
            System.out.println("2. List of class");
            System.out.println("3. Update class");
            System.out.println("4. Delete class");
            System.out.println("0. Exit");
            System.out.println("Choose function: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 0:{
                    System.err.println(" Ending ! ");
                    break;
                }
                case 1:{
                    String id;
                    String name;
                    do {
                        System.out.println("enter class id: ");
                        id = sc.nextLine();
                    }while (id.isEmpty() || CheckID(id)==true);
                    do {
                        System.out.println("enter class name: ");
                        name = sc.nextLine();
                    }while (name.isEmpty() || CheckName(name)==true);

                    InsertClass(id.toUpperCase(),name);
                    break;
                }
                case 2:{
                    System.out.println("List of classes: ");
                    GetAllClass();
                    break;
                }
                case 3:{
                    String id, name;
                    do {
                        System.out.println("enter class id: ");
                        id = sc.nextLine();
                    }while (id.isEmpty());
                    if(CheckID(id)==true){
                        do {
                            System.out.println("enter class name: ");
                            name = sc.nextLine();
                        }while (name.isEmpty() || CheckName(name)==true);

                        UpdateClass(id,name);
                    }
                    else{
                        System.out.println("Can not find class with id= "+id);
                    }
                    break;
                }
                case 4:{
                    String id;
                    do {
                        System.out.println("enter class id: ");
                        id = sc.nextLine();
                    }while (id.isEmpty());
                    if(CheckID(id.toUpperCase())){
                        DeleteClass(id);
                    }
                    else{
                        System.out.println("Can not find class with id= "+id);
                    }
                }
            }
        }while (choose != 0);
    }
}
