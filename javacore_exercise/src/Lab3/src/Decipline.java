import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Decipline
{
    public static Connection connection = ConnectDB.getConnect();
    public static PreparedStatement preparedStatement;

    public void getAllDeciplines() {
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

    public void insertDecipline(String decipline_name, int numOfLecture, int numOfExercie, int teacher_id) {
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

    public void updateDecipline(int id, String name, int numOfLecture, int numOfExercie, int teacher_id) {
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

    public void deleteDecipline(int id) {
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

    public boolean checkIdTeacher(int id) {
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

    public boolean checkID(int id) {
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

    public boolean checkName(String name) {
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
}
