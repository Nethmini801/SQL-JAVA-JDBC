import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//create statement-Inserting the data to a db table
public class App2 {

    public static void main (String[] args) throws ClassNotFoundException, SQLException{

        //making the Driver(loading the driver file)
        Class.forName("com.mysql.cj.jdbc.Driver");

        //making the bridge (making the connection)
        //3306 means the port number that runs the mysql
        //thogakade means the database name
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade","root" , "1998415Nethu#");
    
        //statement allows to issue SQL queries to the DB
        Statement stmt = connection.createStatement();

//method 01
/*     
        whenever we want to insert values into particular table  we must use executeUpdate (hard code)
        int executeUpdate = stmt.executeUpdate("INSERT INTO Customer VALUES('C033','Mr','Amal','1998-08-15',65800.00,'Galle','Galle','Southern',11600)"); 
    
        if above details inserters to the table successfully the output will be 1
        System.out.println(executeUpdate);  
*/  
       

// method 02 - Another method to do above task - by getting keyboard inputs

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

       // when using this method we must use '' in between " " otherwise it will give an syntax error 
       String sql = "INSERT INTO Customer(CustID,CustTitle,CustName,DOB,salary,CustAddress,City,Province,PostalCode) VALUES ('"+custID +"','"+cusTitle+"','"
       +cusName+"','"+DOB+"','"+Sal+"','"+adress+"','"+city+"','"+pro+"','"+PC +"')";
   
       System.out.println(sql);

       int executeUpdate =stmt.executeUpdate(sql);

       if(executeUpdate >0){

        System.out.println("data saved successfully");

       }
   
    }
    
}
