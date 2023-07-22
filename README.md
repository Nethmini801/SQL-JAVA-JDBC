# SQL-JAVA-JDBC
Java app utilizing Visual Studio Code, with Create and Prepared Statements. 6 classes enable effortless data insertion, deletion, updating &amp; reviewing in the database. GitHub repository showcasing efficient DB operations.

#JDBC (JAVA DATABASE CONNECTIVITY)

This means the method of how we connect our database with our Java application.  Here, I have used Java with a MySQL database. 
You can use any other database if you want, but when it comes to the process of making the connection it will be slightly a bit different from this method.

#To do this ,
First, we need to have a library (jar file), This will contain everything that you need to make this connectivity, you can download your jar file, by using the below link.

Link : https://mvnrepository.com/artifact/mysql/mysql-connector-java

After downloading this file, you have to insert it into the lib folder in  your Java app.

#Create statements and Prepared Statements 

1. **Prepared Statements in SQL JDBC:**
   Prepared statements in SQL JDBC are a feature used to execute parameterized queries. They are precompiled SQL statements that can be reused with different parameters. The SQL code is sent to the database server only once during the preparation phase, and subsequent executions with different parameters reuse the compiled statement. Prepared statements offer several advantages in the SQL JDBC context:

   **a. Performance Optimization:**
   Since prepared statements are precompiled and cached on the database server, subsequent executions with different parameter values can be more efficient. This can lead to performance improvements, especially when the same query is executed multiple times with varying parameter values.

   **b. Security (Protection Against SQL Injection):**
   As with any prepared statement, SQL JDBC prepared statements provide protection against SQL injection attacks. By using parameter placeholders, the SQL code and the user-provided data are kept separate, reducing the risk of malicious SQL injection.

   **c. Reusability:**
   Prepared statements can be reused across different parts of an application or within a loop, reducing the overhead of recompiling the same SQL statement repeatedly.

   **d. Maintainability:**
   The use of prepared statements promotes cleaner code and better separation of concerns since the SQL queries are separate from the parameter values.

3. **CREATE Statements in SQL JDBC:**
   In SQL JDBC, CREATE statements are used to create new database objects, such as tables, views, indexes, stored procedures, and so on. They are not used for query execution but rather for defining the structure and properties of these database objects.

   **a. Schema and Database Setup:**
   CREATE statements are essential for setting up the database schema and creating the necessary tables, views, and other objects that applications need to function correctly.

   **b. Database Administration:**
   Database administrators use CREATE statements to manage and modify the database schema and its objects.

In summary, prepared statements in SQL JDBC are beneficial for executing parameterized queries, offering performance improvements and protection against SQL injection. On the other hand, CREATE statements are used for database setup, schema management, and creating database objects. Both prepared statements and CREATE statements play important roles in developing and maintaining applications using SQL JDBC, but they serve different purposes and cannot be directly compared as being "better" than each other.
