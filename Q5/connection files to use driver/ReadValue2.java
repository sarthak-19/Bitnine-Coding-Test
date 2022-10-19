import org.json.*;
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
            
            System.out.println("\nQuery Output using ResultSet Type : ");
            System.out.println(rs.getClass()+"\n");
        
            ResultSetMetaData rsmd = null;
            rsmd=rs.getMetaData();

            while(rs.next())
            {
                for(int x=0;x<rsmd.getColumnCount();x++)
                {
                    String columnName=rsmd.getColumnName(x+1); 
                    int type = rsmd.getColumnType(x+1);

                    if (type == Types.VARCHAR || type == Types.CHAR) 
                    {
                        String data=rs.getString(x+1);
                        System.out.print(columnName+" "+data);
                    } 
                    else 
                    {
                        long data=rs.getLong(x+1);
                        System.out.print(columnName+" "+data);
                    }
                }
                System.out.println();
            }
            String s=statement.executeQueryStringJson(query);
            System.out.println("\n Query Output in String JSON Type");
            System.out.println(s);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}