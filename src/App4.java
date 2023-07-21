import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//using prepared statement -reviewing the data from a db table
public class App4 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.cj.jdbc.Driver");


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "1998415Nethu#");


       PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Customer");


       ResultSet rs = pstmt.executeQuery();


        //Loop the result set and print them
        while(rs.next()){
            System.out.println(rs.getString(1) + " " + rs.getString(3) + " " + rs.getDouble(5));
        }


    }

    
}
