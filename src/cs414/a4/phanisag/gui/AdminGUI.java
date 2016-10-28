package cs414.a4.phanisag.gui;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import cs414.a4.phanisag.controller.AdminLoginActionListener;
import cs414.a4.phanisag.utils.ComponentNames;



public class AdminGUI extends JPanel {

	GridBagConstraints gbc = new GridBagConstraints();

	// JLabel

	private JLabel adminUserNameLabel = new JLabel("Username");
	private JLabel adminPasswordLabel = new JLabel("Password");
	
	private JTextField adminUserNameTextField = new JTextField(15);
	private JPasswordField adminPasswordTextField = new JPasswordField(15);
	
	private JButton loginButton = new JButton("Login");
	
	static JFrame f;

	public AdminGUI() {

		doTheLayout();
		
		adminUserNameTextField.setName(ComponentNames.ADMIN_USERNAME);
		adminPasswordTextField.setName(ComponentNames.ADMIN_PASSWORD);
		loginButton
		.addActionListener(new AdminLoginActionListener());

	} // end of constructor



	

	private void doTheLayout()
	{

		try {

			GridBagLayout gbl = new GridBagLayout();
			setLayout(gbl);

			gbc.insets = new Insets(10, 10, 10, 10);

			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.EAST;
			add(adminUserNameLabel, gbc);
			
			
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.EAST;
			add(adminUserNameTextField, gbc);
			
			
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.EAST;
			add(adminPasswordLabel, gbc);
			
			
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.EAST;
			add(adminPasswordTextField, gbc);

			
			
			
			
			
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.WEST;
			add(loginButton, gbc);
			
			

		} catch (Exception e) {

		}

	}// end of Layout method


	public static void openAdminLogin() {

		f = new JFrame("Administrator Login");
		Container contentPane = f.getContentPane();
		f.setResizable(false);
		contentPane.add(new AdminGUI());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		f.setResizable(false);
		// f.setSize(400, 200);
		f.setVisible(true);

	}
	public static void dispose(){
		f.dispose();
		
	}
}
