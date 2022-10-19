# Instructions For Driver :
## Download Modified Driver :
[Jar File](https://github.com/sarthak-19/PostgreSql-JDBC-Driver/releases/download/driver/postgresql-42.5.1-SNAPSHOT-all.jar)
## Development Environment :

 -  Operating System - MX Linux antiX 5.10 64bit (systemd)
 - Code Editor - Microsoft Visual Studio Code
 - Java IDE - BlueJ (for including driver jar file )
 - JDK 11
 - SQL - PosrgreSql 13 , pgadmin3
## Modifications in Driver:
 - Added new interface **NewStatement** inside **p1 package** which inherits from **Statement** interface from **java.sql** package to add more functions.
 - Added support for **org.json** [maven repository](https://mvnrepository.com/artifact/org.json/json) in build.gradel file for including JSON related operations without adding external **org-json.jar** file.
 - Added function **executeQueryStringJson(String query)** which returns JSON String as output.
## Driver Setup :
- To  use the driver you'll have to add the driver .jar file to [classpath](https://www.geeksforgeeks.org/how-to-add-jar-file-to-classpath-in-java/)  if executing java script using terminal use :
>java.exe -classpath D:\lib\*Main script.java
- If Using an IDE, add external jar file to IDE environment , Google Search ("how to add/import external jar file in xyz IDE ")
 ## How to Use :
 ### Connect To Database 
 ```
 import java.sql.*;
public class ConnectDB 
{
    public  Connection getConnection() 
    {
        Connection connection = null;
        try 
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root"); //provide your password in place of root
	         if(connection != null)
            {
                System.out.println("Connected to the database!");
            }
            else
            {
                System.out.println("Failed to make connection!");
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return connection;
    } 
    public static void main(String args[])
    {
        ConnectDB connectDB = new ConnectDB();
        System.out.println(connectDB.getConnection());
    }
}
```
### Read From Database :
#### To get ResultSet return type
```
import java.sql.*;
import java.util.*;
public class readOld
{
    public static void main(String args[])
    {
        Connection connection=null;
        Statement statement=null;
        ConnectDB connectDB = new ConnectDB();
        connection=connectDB.getConnection();
        try
        {
            String query="SELECT * FROM user_table";
            statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            System.out.println(rs);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
```
#### To get JSON String return type :
```
import java.sql.*;
import java.util.*;
import p1.NewStatement;
public class ReadValue2
{
    public static void main(String args[])
    {
        Connection connection=null;
        NewStatement statement=null;
        ConnectDB connectDB = new ConnectDB();
        connection=connectDB.getConnection();
        try
        {
            String query="SELECT * FROM user_table";
            statement = (NewStatement)connection.createStatement();
            ResultSet rs=statement.executeQuery(query);   
            String s=statement.executeQueryStringJson(query);
            System.out.println(s);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
```
####
Note we have to use "**NewStatement**" imported form "**p1**" package instead of "**Statement**" previously imported from "**java.sql**" package

## Working Demo :
![Screenshot_20220921_185907](https://user-images.githubusercontent.com/69689387/191517279-6585cf58-fcc8-4916-b040-46892ad4d834.jpg)