package exno11;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbinsertionravi
{
    public static Statement stmt;
    public static Connection conn;
    public static ResultSet rs;
    
    public static void connect()
    {       
       try{
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
           stmt = conn.createStatement();                                    
       }
       catch(SQLException e){
           System.out.println(e);
       } 
    }
    
    public static void STATE(String a)
    {
        try {
            stmt.execute(a);
        } catch (SQLException e) {
           System.out.println(e);
        }
    }
    
    public static void STATEEXEUP(String a)
    {
        try{
            stmt.executeUpdate(a);
        }
        catch(SQLException e){
           System.out.println(e);
    }
    }
    
    public static ResultSet RSEXEQUE(String a,ResultSet b)
    {
        try{
            rs=stmt.executeQuery(a);
            b=rs;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return b;
    }
    
    public static void main(String[] args) {
       dbinsertionravi.connect();
       dbinsertionravi.STATE("CREATE TABLE books(Id int,Title VARCHAR(50),Author VARCHAR(50),Price float,Quantity int)");
       dbinsertionravi.STATEEXEUP("INSERT INTO books VALUES('1001','Java for dummies','Tan Ah Teck','11.11','11')");
       dbinsertionravi.STATEEXEUP("INSERT INTO books VALUES('1002','More Java for dummies','Tan Ah Teck','22.22','22')");
       dbinsertionravi.STATEEXEUP("INSERT INTO books VALUES('1003','More Java for more dummies','Mohammad Ali','33.33','33')");
       dbinsertionravi.STATEEXEUP("INSERT INTO books VALUES('1004','A Cup of Java','Kumar','44.44','44')");
       dbinsertionravi.STATEEXEUP("INSERT INTO books VALUES('1005','A Teaspoon of Java','Kevin Jones','55.55','55')");
       dbinsertionravi.RSEXEQUE("SELECT * FROM books", rs);
        try {
            while(rs.next())
            {
                String a=rs.getString(1);
                String b=rs.getString(2);
                String c=rs.getString(3);
                String d=rs.getString(4);
                String e=rs.getString(5);
                System.out.println("Id:"+a+"\nTitle:"+b+"\nAuthor:"+c+"\nPrice:"+d+"\nQuantity:"+e);
                System.out.println("-x-x-x-x-x-x-x-x-x-\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        dbinsertionravi.RSEXEQUE("SELECT Title, Author, Price, Quantity FROM books WHERE Author = 'Tan Ah Teck'", rs);
        try{
            while(rs.next())
         {
            
             String b=rs.getString(1);
             String c=rs.getString(2);
             String d=rs.getString(3);
             String e=rs.getString(4);
             System.out.println("\nTitle:"+b+"\nAuthor:"+c+"\nPrice:"+d+"\nQuantity:"+e);
             System.out.println("-x-x-x-x-x-x-x-x-x-\n");
         }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        dbinsertionravi.STATEEXEUP("UPDATE books SET price=price+price*0.5 WHERE Title = 'A Cup of Java'");
        dbinsertionravi.STATEEXEUP("UPDATE books SET quantity=0 WHERE Title = 'A Teaspoon of Java'");
        dbinsertionravi.STATEEXEUP("DELETE FROM books WHERE id = '1001'");
        dbinsertionravi.STATEEXEUP("INSERT INTO books VALUES('8001','Java ABC','Kevin Jones','15.55','55')");
        dbinsertionravi.STATEEXEUP("INSERT INTO books VALUES('8002','Java XYZ','Kevin Jones','25.55','55')");
        dbinsertionravi.STATEEXEUP("DELETE FROM books WHERE author = 'Kevin Jones'");
        System.out.println("Database created successfully...");
    }    
}