/**
 * @(#)MenuPane.java
 *
 *
 * @author
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.text.*;

public class MenuPane extends JFrame {

	private JButton registerB, viewByCtgB, viewCredB, viewRaceStatB, elecRaffleB, logoutB;

	private RegisterButtonHandler rbHandler;
	private ViewByCtgButtonHandler vbcbHandler;
	private ViewCredButtonHandler vcbHandler;
	private ViewRaceStatButtonHandler vrsbHandler;
	private ElecRaffleButtonHandler erbHandler;
	private LogoutButtonHandler lbHandler;

	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;


    public MenuPane() {
    		// Create the Buttons
		registerB = new JButton("Register a Runner");
		rbHandler = new RegisterButtonHandler();
		registerB.addActionListener(rbHandler);

		viewByCtgB = new JButton("View Runners by Category");
		vbcbHandler = new ViewByCtgButtonHandler();
		viewByCtgB.addActionListener(vbcbHandler);

		viewCredB = new JButton("View Runner Credentials");
		vcbHandler = new ViewCredButtonHandler();
		viewCredB.addActionListener(vcbHandler);

		viewRaceStatB = new JButton("View Race Statistics");
		vrsbHandler = new ViewRaceStatButtonHandler();
		viewRaceStatB.addActionListener(vrsbHandler);

		elecRaffleB = new JButton("Raffle Draw");
		erbHandler = new ElecRaffleButtonHandler();
		elecRaffleB.addActionListener(erbHandler);

		logoutB = new JButton("Logout");
		lbHandler = new LogoutButtonHandler();
		logoutB.addActionListener(lbHandler);

			// Set the title of the window
		setTitle("Runner\'s Circle Inc.");

			// Get the container
		Container pane = getContentPane();

			// Set the layout
		pane.setLayout(new GridLayout(3,2));

			// Place the components in the pane
		pane.add(registerB);
		pane.add(viewByCtgB);
		pane.add(viewCredB);
		pane.add(viewRaceStatB);
		pane.add(elecRaffleB);
		pane.add(logoutB);

			// Set the size of the window and display it
		setSize(WIDTH,HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
		// Register
    private class RegisterButtonHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){
			RegisterPane rp = new RegisterPane();

		}
	}
		// view by category
	private class ViewByCtgButtonHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){

		}
	}
		// view credentials
	private class ViewCredButtonHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){

		}
	}
		// view statistics
	private class ViewRaceStatButtonHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){

		}
	}
		// raffle
	private class ElecRaffleButtonHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){

		}
	}
		// logout
	private class LogoutButtonHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){
			setVisible(false);
			dispose();
			JOptionPane.showMessageDialog(null,"You are now logged out.");
			System.exit(0);
			// must return to login form
		}
	}

}