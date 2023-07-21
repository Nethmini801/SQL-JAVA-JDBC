import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//Prepared statement-delete values from a database table.
public class App6 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade","root" , "1998415Nethu#");
    
         PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Customer", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_FORWARD_ONLY);

        ResultSet rs=pstmt.executeQuery();

          while(rs.next()){
            System.out.println(rs.getString(1)+ " "+rs.getString(2) + " " + rs.getString(3) + " " + rs.getDate(4)
            +" "+rs.getString(5)+ " " +rs.getString(6)+ " "+rs.getString(7)+ " "+rs.getString(8)+rs.getString(9));
        }

        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the Customer Id to delete customer's details :");
        String custID = sc.nextLine();

        boolean found =false;

        rs.beforeFirst();

        while(rs.next()){
            
            String  custIdFromDB =rs.getString(1);

            if(custID.equals(custIdFromDB)){

                found=true;
                
                rs.getString(2);
                rs.getString(3);
                rs.getString(4);
                rs.getString(5);
                rs.getString(6);
                rs.getString(7);
                rs.getString(8);
                rs.getString(9);
                    
               

                String deleteQuery = "DELETE FROM Customer  WHERE  CustID = ?";
                PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
                deleteStmt.setString(1, custID);

                int rowsAffected = deleteStmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Customer details deleted successfully.");
                } else {
                    System.out.println("Failed to delete the customer details.");
                }

                break; // No need to continue searching once found
            }
        }

    }
    
}
