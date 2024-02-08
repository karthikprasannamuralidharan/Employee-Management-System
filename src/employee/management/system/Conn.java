package employee.management.system;
//1 - Register the Driver class
//2 - Creating the connection String
//3 - Creating statement
//4 - Executing mysql queries
//5 - Closing the connections

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employmanagementsystem", "root", "31103110");
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
