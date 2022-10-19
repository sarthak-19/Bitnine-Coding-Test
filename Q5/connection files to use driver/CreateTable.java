import java.sql.*;
public class CreateTable
{
    public static void main(String args[])
    {
        Connection connection=null;
        Statement statement=null;
        ConnectDB connectDB = new ConnectDB();
        connection=connectDB.getConnection();

        try
        {
            String query="CREATE TABLE IF NOT EXISTS public.user_table(user_id numeric(10,0) NOT NULL,name character varying(50) COLLATE pg_catalog.\"default\" NOT NULL,age numeric(3,0) NOT NULL,phone character varying(20) COLLATE pg_catalog.\"default\",CONSTRAINT user_table_pkey PRIMARY KEY (user_id))";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created successfully");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}