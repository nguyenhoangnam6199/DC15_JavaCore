import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Class {
    public static Connection connection = ConnectDB.getConnect();
    public static PreparedStatement preparedStatement;

    public void getAllClasses() {
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


    public void insertClass(String class_id, String class_name) {
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


    public void updateClass(String id, String new_name) {
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

    public void deleteClass(String id) {
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

    public boolean checkID(String id) {
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

    public boolean checkName(String name) {
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
}
