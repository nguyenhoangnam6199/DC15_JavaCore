import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    public static Connection connection = ConnectDB.getConnect();
    public static PreparedStatement preparedStatement;

    public void getAllStudents() {
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


    public void insertStudent(String student_name, String class_id) {
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

    public void updateStudent(int id, String student_name, String class_id) {
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

    public void deleteStudent(int id) {
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

    public boolean checkIdClass(String id) {
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

    public boolean checkID(int id) {
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

    public boolean checkName(String name) {
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
}
