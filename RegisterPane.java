/**
 * @(#)RegisterPane.java
 *
 *
 * @author
 * @version 1.00 2011/12/5
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.text.*;

public class RegisterPane extends JFrame {

	private JLabel nameL, bdayL, emailL, contactNoL, addressL, genderL, raceCategoryL, eNameL, eContactNoL, blankL;

	private JTextField nameTF, bdayTF, emailTF, contactNoTF, addressTF, raceCategoryTF, eNameTF, eContactNoTF;
	private JTextField yearTF;

	private JButton registerB, cancelB;

	private JComboBox ctgC,genderC, monthC, dayC;

	private RegisterButtonHandler rbHandler;
	private CancelButtonHandler cbHandler;

	private CategoryComboHandler ctgCHandler;
	private GenderComboHandler gndCHandler;
	private MonthComboHandler mthCgHandler;
	private DayComboHandler dayCHandler;

	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;

	private static String gGender = "", gCategory = "";
	private static String gMonth = "", gDay = "";

    public RegisterPane() {
    		// Create the labels
		nameL 		= new JLabel("Name: ", SwingConstants.RIGHT);
		bdayL		= new JLabel("Birthdate: ", SwingConstants.RIGHT);
		emailL 		= new JLabel("Email: ", SwingConstants.RIGHT);
		contactNoL 	= new JLabel("Contact No: ", SwingConstants.RIGHT);
		addressL 	= new JLabel("Address: ", SwingConstants.RIGHT);
		genderL 	= new JLabel("Gender: ", SwingConstants.RIGHT);
		raceCategoryL = new JLabel("Race Category: ", SwingConstants.RIGHT);
		eNameL 		= new JLabel("Emergency Contact Person:", SwingConstants.RIGHT);
		eContactNoL = new JLabel("Emergency Contact No: ", SwingConstants.RIGHT);
		blankL		= new JLabel("asd ", SwingConstants.RIGHT);

			// Create the textfields
		nameTF		= new JTextField(15);
		bdayTF		= new JTextField(15);
		emailTF		= new JTextField(15);
		contactNoTF	= new JTextField(15);
		addressTF	= new JTextField(15);
		yearTF		= new JTextField(15);
		eNameTF		= new JTextField(15);
		eContactNoTF = new JTextField(11);

			// create the combo boxes
		String categories[] = {"-- Please Select --","3K", "5K", "10K", "21K"	};
		String gender[] = {"-- Please Select --","M", "F"	};
		String month[] = {"Month","1","2","3","4","5","6","7","8","9","10","11","12"};
		String day[] = {"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

		ctgC	= new JComboBox(categories);
		genderC = new JComboBox(gender);
		monthC	= new JComboBox(month);
		dayC	= new JComboBox(day);

		ctgCHandler = new CategoryComboHandler();
		ctgC.addItemListener(ctgCHandler);

		gndCHandler = new GenderComboHandler();
		genderC.addItemListener(gndCHandler);

		mthCgHandler = new MonthComboHandler();
		monthC.addItemListener(mthCgHandler);

		dayCHandler = new DayComboHandler();
		dayC.addItemListener(dayCHandler);


			// Create the Register Button
		registerB = new JButton("Register");
		rbHandler = new RegisterButtonHandler();
		registerB.addActionListener(rbHandler);

			// Create the Cancel Button
		cancelB = new JButton("Cancel");
		cbHandler = new CancelButtonHandler();
		cancelB.addActionListener(cbHandler);

			// Set the title of the window
		setTitle("Runner\'s Circle Inc.");

			// Get the container
		Container pane = getContentPane();

			// Set the layout
		pane.setLayout(new GridLayout(11,4));

			// Place the components in the pane
		pane.add(nameL);
		pane.add(nameTF);
		pane.add(blankL);
		pane.add(blankL);
		pane.add(bdayL);
		pane.add(monthC);
		pane.add(dayC);
		pane.add(yearTF);
		pane.add(emailL);
		pane.add(emailTF);	pane.add(blankL);	pane.add(blankL);
		pane.add(contactNoL);
		pane.add(contactNoTF);	pane.add(blankL);	pane.add(blankL);
		pane.add(addressL);
		pane.add(addressTF);	pane.add(blankL);	pane.add(blankL);
		pane.add(genderL);
		pane.add(genderC);		pane.add(blankL);	pane.add(blankL);
		pane.add(raceCategoryL);
		pane.add(ctgC);		pane.add(blankL);	pane.add(blankL);
		pane.add(eNameL);
		pane.add(eNameTF);		pane.add(blankL);	pane.add(blankL);
		pane.add(eContactNoL);
		pane.add(eContactNoTF);		pane.add(blankL);	pane.add(blankL); 	pane.add(blankL);
		pane.add(registerB);
		pane.add(cancelB);




			// Set the size of the window and display it
		setSize(WIDTH,HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private class CategoryComboHandler implements ItemListener{
		public void itemStateChanged(ItemEvent ie){
		 	String ctg = (String)ctgC.getSelectedItem();
		  	gCategory = ctg;

		}
	}

	private class GenderComboHandler implements ItemListener{
		public void itemStateChanged(ItemEvent ie){
		 	String ctg = (String)genderC.getSelectedItem();
		 	gGender = ctg;

		}
	}

	private class MonthComboHandler implements ItemListener{
		public void itemStateChanged(ItemEvent ie){
		 	String ctg = (String)monthC.getSelectedItem();
		 	gMonth = ctg;

		}
	}
	private class DayComboHandler implements ItemListener{
		public void itemStateChanged(ItemEvent ie){
		 	String ctg = (String)dayC.getSelectedItem();
		 	gDay = ctg;

		}
	}

	private class RegisterButtonHandler implements ActionListener{
		int allowC=0;
		int allowG=0;

		public void actionPerformed(ActionEvent e){
		}
	}

	private class CancelButtonHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){
			//System.exit(0);
			setVisible(false);
			dispose();
		}
	}


}