import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection getConnect(){
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String pass = "123456";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,pass);
            if(connection == null){
                System.out.println("Failed to connect Database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
