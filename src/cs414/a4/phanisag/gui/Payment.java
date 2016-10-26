package cs414.a4.phanisag.gui;



import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.rmi.CORBA.Util;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Payment extends JPanel {

	GridBagConstraints gbc = new GridBagConstraints();
	
	//JLabel
	
	JLabel expiryDateLabel = new JLabel("Expiry Date");
	JLabel cvvNumberLabel = new JLabel("CVV");
	
	//JRadioButton
	
	JRadioButton creditCardRadioButton = new JRadioButton("Credit/Debit Card");
	
	
	JRadioButton cashRadioButton = new JRadioButton("Cash");
	
	
	//JTextField
	
	JTextField creditCardTextFieldOne = new JTextField(4);
	JTextField creditCardTextFieldTwo = new JTextField(4);
	JTextField creditCardTextFieldThree = new JTextField(4);
	JTextField creditCardTextFieldFour = new JTextField(4);
	
	
	JTextField expiryDateTextFieldOne = new JTextField(4);
	
	JTextField expiryDateTextFieldTwo = new JTextField(4);
	
	JTextField cvvNumberTextField = new JTextField(4);
	
	//JButton
	
	JButton payButton = new JButton("Pay");
	
	
	
	
	static JFrame f;
	



	public Payment() {

		
		
		initGUI();
		doTheLayout();
		
		disableAllFields();
		
		
		
		creditCardRadioButton.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	
	        	
	        	enableAllFields();
	        	
	        }

			private void enableAllFields() {
				
				
				creditCardTextFieldOne.setEnabled(true);
				creditCardTextFieldTwo.setEnabled(true);
				creditCardTextFieldThree.setEnabled(true);
				creditCardTextFieldFour.setEnabled(true);
				
				expiryDateTextFieldOne.setEnabled(true);
				expiryDateTextFieldTwo.setEnabled(true);
				
				cvvNumberTextField.setEnabled(true);
			}

	    });
		
		
		cashRadioButton.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	
	        	
	        	disableAllFields();
	        	
	        }

			

	    });
			
			
			
		
		


	} // end of constructor
	
	
	

	private void disableAllFields() {
		
		
		creditCardTextFieldOne.setEnabled(false);
		creditCardTextFieldTwo.setEnabled(false);
		creditCardTextFieldThree.setEnabled(false);
		creditCardTextFieldFour.setEnabled(false);
		
		expiryDateTextFieldOne.setEnabled(false);
		expiryDateTextFieldTwo.setEnabled(false);
		
		cvvNumberTextField.setEnabled(false);
		
		
		
	}




	static void dispose() {
		
		if(f!=null)
		f.dispose();
		
	}

	private void initGUI(){
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(creditCardRadioButton);
		group.add(cashRadioButton);
		
	}// end of creating objects method


	private void doTheLayout(){

		try{
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);


		gbc.insets=new Insets(10,10,10,10);

			
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.EAST;
		add(creditCardRadioButton,gbc);
		
		
		gbc.gridx=4;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.EAST;
		add(cashRadioButton,gbc);
		
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.WEST;
		add(creditCardTextFieldOne,gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.WEST;
		add(creditCardTextFieldTwo,gbc);
		
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.WEST;
		add(creditCardTextFieldThree,gbc);
		
		
		gbc.gridx=3;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.WEST;
		add(creditCardTextFieldFour,gbc);
		
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.anchor=GridBagConstraints.WEST;
		add(expiryDateLabel,gbc);
		
		
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.anchor=GridBagConstraints.WEST;
		add(expiryDateTextFieldOne,gbc);
		
		
		
		gbc.gridx=2;
		gbc.gridy=2;
		gbc.anchor=GridBagConstraints.WEST;
		add(expiryDateTextFieldTwo,gbc);
		
		
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.anchor=GridBagConstraints.WEST;
		add(cvvNumberLabel,gbc);
		
		
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.anchor=GridBagConstraints.WEST;
		add(cvvNumberTextField,gbc);
		
		
		
		gbc.gridx=2;
		gbc.gridy=4;
		gbc.anchor=GridBagConstraints.WEST;
		add(payButton,gbc);
		
		
		
		
		
		
		
		
		
		}catch(Exception e){
			
		}


	}// end of Layout method




	
	

	public static void main(String[] args) {
		
		f = new JFrame("Payment Info");
		Container contentPane = f.getContentPane();
		f.setResizable(false);
		contentPane.add( new Payment());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	    f.setResizable(false);
		//f.setSize(400, 200);
		f.setVisible(true);
		
		
	}
	
	
	public static void openPayment(){
		
		
		f = new JFrame("Payment Info");
		Container contentPane = f.getContentPane();
		f.setResizable(false);
		contentPane.add( new Payment());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	    f.setResizable(false);
		//f.setSize(400, 200);
		f.setVisible(true);
		
	}

	

}


