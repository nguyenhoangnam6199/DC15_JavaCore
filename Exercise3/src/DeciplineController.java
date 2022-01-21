import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeciplineController {
    public static Connection connection = ConnectDB.getConnect();
    public static PreparedStatement preparedStatement;

    //Get All Data
    public static void GetAllStudent(){
        String sql = "SELECT * FROM decipline";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs =  preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println("decipline_id: "+rs.getString(1)+" - decipline_name: "
                        +rs.getString(2)+" - numberOfLecture: "+rs.getString(3)+" - numberOfExecrise: "
                        +rs.getString(4)+" - teacher_id: "+rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Insert Data
    public static void InsertDecipline(String decipline_name,int numOfLecture, int numOfExercie, int teacher_id){
        String sql = "INSERT INTO decipline (decipline_name,numberOfLecture,numberOfExecrise, teacher_id) VALUES(?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,decipline_name);
            preparedStatement.setInt(2,numOfLecture);
            preparedStatement.setInt(3,numOfExercie);
            preparedStatement.setInt(4,teacher_id);
            preparedStatement.executeUpdate();
            System.out.println("Insert successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void UpdateDecipline(int id, String name, int numOfLecture, int numOfExercie, int teacher_id){
        String sql = "UPDATE decipline SET decipline_name=?, numberOfLecture=?, numberOfExecrise=?, teacher_id=?  WHERE decipline_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,numOfLecture);
            preparedStatement.setInt(3,numOfExercie);
            preparedStatement.setInt(4,teacher_id);
            preparedStatement.setInt(5,id);
            preparedStatement.executeUpdate();
            System.out.println("Update successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void DeleteDecipline(int id){
        String sql = "DELETE FROM decipline WHERE decipline_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Delete successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean CheckIdTeacher(int id){
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

    public static boolean CheckID(int id){
        boolean kt = false;
        String sql = "SELECT * FROM decipline WHERE decipline_id=?";
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
        String sql = "SELECT * FROM decipline WHERE decipline_name=?";
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

    public static boolean CheckRecord(String name, int id){
        boolean kt = false;
        String sql = "SELECT * FROM decipline WHERE decipline_name=? AND teacher_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
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
            System.out.println("1. Insert decipline");
            System.out.println("2. List of decipline");
            System.out.println("3. Update decipline");
            System.out.println("4. Delete decipline");
            System.out.println("0. Exit");
            System.out.println("Choose function: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 0:{
                    System.err.println(" Ending ! ");
                    break;
                }
                case 1:{
                    String name;
                    int k,h,g;
                    do {
                        System.out.println("enter decipline name: ");
                        name = sc.nextLine();
                    }while (name.isEmpty() || CheckName(name)==true);
                    System.out.println("enter number of lecture: ");
                    k = Integer.parseInt(sc.nextLine());
                    System.out.println("enter number of execrise: ");
                    h = Integer.parseInt(sc.nextLine());

                    do{
                        System.out.println("enter teacher id: ");
                        g = Integer.parseInt(sc.nextLine());
                    }while(CheckIdTeacher(g)==false);


                    InsertDecipline(name,k,h,g);
                    break;
                }
                case 2:{
                    System.out.println("List of deci[line: ");
                    GetAllStudent();
                    break;
                }
                case 3:{
                    int id;
                    String name;
                    int k, h, g;
                    System.out.println("enter id decipline: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    if(CheckID(id)==true){
                        do {
                            System.out.println("enter decipline name: ");
                            name = sc.nextLine();
                        }while (name.isEmpty());

                        System.out.println("enter number of lecture: ");
                        k = Integer.parseInt(sc.nextLine());
                        System.out.println("enter number of execrise: ");
                        h = Integer.parseInt(sc.nextLine());

                        do{
                            System.out.println("enter teacher id: ");
                            g = Integer.parseInt(sc.nextLine());
                        }while(CheckIdTeacher(g)==false);

                        if(CheckRecord(name,g)==true){
                            System.out.println("Decipline has already existed");
                        }
                        else{
                            UpdateDecipline(id,name,k,h,g);
                        }
                    }
                    else{
                        System.out.println("Can not find decipline with id= "+id);
                    }
                    break;
                }
                case 4:{
                    int id;
                    System.out.println("enter decipline id: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    if(CheckID(id)==true){
                        DeleteDecipline(id);
                    }
                    else{
                        System.out.println("Can not find decipline with id= "+id);
                    }
                }
            }
        }while (choose != 0);
    }
}
