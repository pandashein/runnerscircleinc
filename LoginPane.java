import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.text.*;

import java.sql.*;

public class LoginPane extends JFrame {

	private JLabel userL, passL;

	private JTextField userTF, passTF;

	private JButton loginB, cancelB;

	private LoginButtonHandler lbHandler;
	private CancelButtonHandler cbHandler;

	private static final int WIDTH = 350;
	private static final int HEIGHT = 125;

    public LoginPane() {
    		// Create the labels
		userL 		= new JLabel("Username: ", SwingConstants.RIGHT);
		passL		= new JLabel("Password: ", SwingConstants.RIGHT);

			// Create the textfields
		userTF		= new JTextField(20);
		passTF		= new JTextField(20);

			// Create the Login Button
		loginB = new JButton("Login");
		lbHandler = new LoginButtonHandler();
		loginB.addActionListener(lbHandler);

			// Create the Cancel Button
		cancelB = new JButton("Cancel");
		cbHandler = new CancelButtonHandler();
		cancelB.addActionListener(cbHandler);

			// Set the title of the window
		setTitle("Runner\'s Circle Inc.");

			// Get the container
		Container pane = getContentPane();

			// Set the layout
		pane.setLayout(new GridLayout(3,2));

			// Place the components in the pane
		pane.add(userL);
		pane.add(userTF);
		pane.add(passL);
		pane.add(passTF);
		pane.add(loginB);
		pane.add(cancelB);

			// Set the size of the window and display it
		setSize(WIDTH,HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class LoginButtonHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){

			String  userV="", passV="";

			userV = userTF.getText();
			passV = passTF.getText();

				// connect to db
			Connection conn = null;
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver").newInstance();
	    		conn = DriverManager.getConnection(
	    				"jdbc:mysql://localhost/runnerscircleinc?user=root&password=");
	    	}
	    	catch (Exception c) {
	    		System.out.println(c);
	    		System.exit(0);
	    	}
				// check if username and password match
			try {
    			Statement s = conn.createStatement();
    			// READ
    			ResultSet r = s.executeQuery("SELECT * FROM runnerscircleinc.user WHERE username = \'" + userV + "\'");
    			if(r.next()){
	    			if(r.getString("password").equals(passV)){
						setVisible(false);
						dispose();
	    				JOptionPane.showMessageDialog(null,"AUTHENTICATED");
	    				MenuPane mp = new MenuPane();
	    			}
	    			else {
	    				JOptionPane.showMessageDialog(null,"Wrong password. Please try again.");
	    			}
    			} else {
    				JOptionPane.showMessageDialog(null,"Username not found. Please try again.");
    			}
			}
    		catch (Exception a){
	    		System.out.println(a);
	    		System.exit(0);
    		}

		}
	}

	private class CancelButtonHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}


}