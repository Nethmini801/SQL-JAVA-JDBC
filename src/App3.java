import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//using prepared statement -inserting data into a database table
public class App3 {

    public static void main (String[] args) throws ClassNotFoundException, SQLException{

        //making the Driver(loading the driver file)
        Class.forName("com.mysql.cj.jdbc.Driver");

        //making the bridge (making the connection)
        //3306 means the port number that runs the mysql
        //thogakade means the database name
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade","root" , "1998415Nethu#");
    

// method 03 - Another method -Prepared statement (Easiest way)

       Scanner sc =new Scanner(System.in);

       System.out.println("Enter a Customer ID:");
       String custID  =sc.nextLine();

       System.out.println("Enter customer title : ");
       String cusTitle = sc.nextLine() ;

       System.out.println("Enter customer name : ");
       String cusName = sc.nextLine() ;


       System.out.println("Enter the DOB :");
       String DOB=sc.nextLine();

       
       System.out.println("Enter the address :");
       String adress =sc.nextLine();

       System.out.println("Enter the city :");
       String city = sc.nextLine();

       System.out.println("Enter the province :");
       String pro=sc.nextLine();

       System.out.println("Enter the postal code :");
       int PC=sc.nextInt();

       System.out.println("Enter the salary :");
       Double Sal=sc.nextDouble();

       //if there is columns 9 in the table  we must put 9 ?s  here,when writing the sql query.
       PreparedStatement pstm = connection.prepareStatement("INSERT into Customer Values (?,?,?,?,?,?,?,?,?)");
     
       //pstm.setString(column number,column name)
       pstm.setString(1, custID);
       pstm.setString(2, cusTitle);
       pstm.setString(3, cusName);
       pstm.setString(4, DOB);
       pstm.setDouble(5, Sal);
       pstm.setString(6, adress);
       pstm.setString(7, city);
       pstm.setString(8, pro);
       pstm.setInt(9, PC);


        //making the String value as an Int value
        int i = pstm.executeUpdate();


        if(i > 0){
            System.out.println("Data Saved. :D");
        }

       
    }
    
}

    

