import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//using create statement -reviewing the data from a db table
public class App {
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        //making the Driver(loading the driver file)
        Class.forName("com.mysql.jdbc.Driver");

        //making the bridge (making the connection)
        //3306 means the port number that runs the mysql
        //thogakade means the database name
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade","root" , "1998415Nethu#");
    
        //statement allows to issue SQL queries to the DB
        Statement stmt = connection.createStatement();
        
        //getting results set after executing the statement
        ResultSet rs=stmt.executeQuery("SELECT * FROM Customer");

        //reading the data through a while loop
        //re.next = in result set ,if there is a value next (if the results set is not empty)
        //according to this println statement (inside the loop), it will show only 3 columns from the customer table
        while(rs.next()){

            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
    
        }
    }

}
