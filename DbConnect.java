/**
 * @(#)DbConnect.java
 *
 *
 * @author
 */

import java.sql.*;
import javax.swing.*;

public class DbConnect {

    public DbConnect() {
    	Connection conn = null;

    	System.out.println("SQL Test");

    	try {
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		conn = DriverManager.getConnection(
    				"jdbc:mysql://localhost/runnerscircleinc?user=root&password=");
    	}
    	catch (Exception e) {
    		System.out.println(e);
    		System.exit(0);
    	}

    	JOptionPane.showMessageDialog(null,"Connection established.");
    }


}