import java.io.StringWriter;
import org.json.*;
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