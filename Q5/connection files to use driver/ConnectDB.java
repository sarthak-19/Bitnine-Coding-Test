import java.sql.*;
public class ConnectDB 
{
    public  Connection getConnection() 
    {
        Connection connection = null;
        try 
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            
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