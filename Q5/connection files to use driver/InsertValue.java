import java.sql.*;
public class InsertValue
{
    public static void main(String args[])
    {
        Connection connection=null;
        Statement statement=null;
        ConnectDB connectDB = new ConnectDB();
        connection=connectDB.getConnection();

        try
        {
            String query="INSERT INTO public.user_table (user_id, name, age, phone) VALUES (3, 'Jenny', 34, NULL);";
            String query2="INSERT INTO public.user_table (user_id, name, age, phone) VALUES (2, 'Tom', 29, '1-800-123-1234')";
            String query3="INSERT INTO public.user_table (user_id, name, age, phone) VALUES (1, 'John', 28, NULL)";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            //statement.executeUpdate(query3);
            System.out.println("Value inserted successfully");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}