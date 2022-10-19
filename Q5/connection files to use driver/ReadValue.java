import java.io.StringWriter;
import org.json.*;
import java.sql.*;
import java.util.*;
import java.lang.reflect.Field;
public class ReadValue
{
    public static void main(String args[])
    {
        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;
        ResultSetMetaData rsmd=null;

        JSONObject jsonObject=new JSONObject();
        JSONArray array = new JSONArray();

        try 
        {
            Field changeMap = jsonObject.getClass().getDeclaredField("map");
            changeMap.setAccessible(true);
            changeMap.set(jsonObject, new LinkedHashMap<>());
            changeMap.setAccessible(false);
        } catch (IllegalAccessException | NoSuchFieldException e) 
        {
            System.out.println(e.getMessage());
        }

        ConnectDB connectDB = new ConnectDB();
        connection=connectDB.getConnection();
        try
        {
            String query="SELECT * FROM user_table";
            statement = connection.createStatement();
            rs=statement.executeQuery(query);
            rsmd = rs.getMetaData();

            jsonObject.put("status",200);
            while(rs.next())
            {
                JSONObject item = new JSONObject();
                for(int x=0;x<rsmd.getColumnCount();x++)
                {
                    String columnName=rsmd.getColumnName(x+1); 
                    int type = rsmd.getColumnType(x+1);

                    if (type == Types.VARCHAR || type == Types.CHAR) 
                    {
                        String data=rs.getString(x+1);
                        item.put(columnName,data);
                    } 
                    else 
                    {
                        long data=rs.getLong(x+1);
                        item.put(columnName,data);
                    }
                }
                array.put(item);
                //System.out.println();
            }
            jsonObject.put("data",array);
            String jobject=jsonObject.toString();
            System.out.println(jobject);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}