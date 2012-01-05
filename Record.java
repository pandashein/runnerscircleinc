/**
 * @(#)Record.java
 *
 *
 * @author
 */
import javax.swing.*;
import java.text.*;
import java.util.*;

import java.sql.*;
public class Record {

    public Record() {

    }

    public static void registerRunner(String fnameV, String lnameV, String bdayV, int ageV, String emailV, int contactNoV, String addressV, String genderV, int raceCategoryV, String eNameV, int eContactNoV, String eRelationV){
    	//connect to database
			Connection conn = null;
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver").newInstance();
	    		conn = DriverManager.getConnection(
	    				"jdbc:mysql://localhost/runnerscircleinc?user=root&password=");
	    	}
	    	catch (Exception a) {
	    		System.out.println(a);
	    		System.exit(0);
	    	}

			// insert to table runner
	    	try {
    			Statement s = conn.createStatement();
	    		s.executeUpdate("INSERT INTO runner (id, runner_num, firstname, lastname, birthdate, age, email, phone, address, gender, category_id, ec_name, ec_phone, ec_relation) VALUES ('','123','" + fnameV + "','" + lnameV + "','" + bdayV + "','" + ageV + "','" + emailV + "','" + contactNoV + "','" + addressV + "','" + genderV + "','" + raceCategoryV + "','" + eNameV + "','" + eContactNoV + "','" + eRelationV + "')");
				JOptionPane.showMessageDialog(null,"Registration successful");
	    	}catch (Exception a){
	    		System.out.println(a);
	    		System.exit(0);
	    	}
    }


}