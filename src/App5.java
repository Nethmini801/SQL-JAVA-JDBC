//using prepared statement -Updating the data of a table

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//Prepared statement - update database table details.
public class App5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade","root" , "1998415Nethu#");
    
        /*Usage of TYPE_SCROLL_INSENSITIVE - if another 
        transaction modifies the underlying data while you are traversing the result set, the result set will not reflect those changes.
        
        Usage of CONCUR_READ_ONLY -
        meaning you cannot modify the data through this result set.
        You can only retrieve data from the database, but not perform updates, inserts, or deletes.

        Usage of TYPE_FORWARD ONLY -
        You cannot move backward or reposition the cursor to a previous row.
        */
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Customer", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_FORWARD_ONLY);

        ResultSet rs=pstmt.executeQuery();

         while(rs.next()){
            System.out.println(rs.getString(1)+ " "+rs.getString(2) + " " + rs.getString(3) + " " + rs.getDate(4));
        }

        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the Customer Id to update customer's details :");
        String custID = sc.nextLine();

        boolean found =false;

        // Reset the cursor to the beginning of the result set
        rs.beforeFirst();

        while(rs.next()){
            
            String  custIdFromDB =rs.getString(1);

            if(custID.equals(custIdFromDB)){

                found=true;
                
                String customerTitle =rs.getString(2);
                String customerName = rs.getString(3);
                String customerDOB = rs.getString(4);
                    
                System.out.println("Customer ID: " + custID);
                System.out.println("Customer Title: " + customerTitle);
                System.out.println("Customer name : "+customerName);
                System.out.println("Customer Date of Birth: " + customerDOB);
               
                // Now, perform the update

                System.out.println("Enter the updated Title:");
                String updatedTitle = sc.nextLine();

                System.out.println("Enter the updated name:");
                String updatedName = sc.nextLine();

                System.out.println("Enter the updated DOB:");
                String updatedDOB = sc.nextLine();

                // Create an update query using prepared statement
                String updateQuery = "UPDATE Customer SET custTitle=? , custName = ?, DOB = ? WHERE  CustID = ?";
                PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                updateStmt.setString(1, updatedTitle);
                updateStmt.setString(2, updatedName);
                updateStmt.setString(3, updatedDOB);
                updateStmt.setString(4, custID);

                int rowsAffected = updateStmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Customer details updated successfully.");
                } else {
                    System.out.println("Failed to update customer details.");
                }

                break; // No need to continue searching once found
            }
        }

        // Close resources
        rs.close();
        pstmt.close();
        connection.close();
    }
}




       





    
    

