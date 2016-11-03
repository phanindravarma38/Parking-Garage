package cs414.a4.phanisag.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cs414.a4.phanisag.bo.AttendantBO;
import cs414.a4.phanisag.dao.AdminDAO;
import cs414.a4.phanisag.dao.AttendantDAO;
import cs414.a4.phanisag.utils.ComponentNames;
import cs414.a4.phanisag.utils.CreditCardValidation;
import cs414.a4.phanisag.utils.Utilities;

public class PaymentGUI extends JPanel {

	GridBagConstraints gbc = new GridBagConstraints();

	// JLabel

	JLabel expiryDateLabel = new JLabel("Expiry Date");
	JLabel cvvNumberLabel = new JLabel("CVV");
	AttendantBO attendantBo = new AttendantBO();

	// JRadioButton

	JRadioButton creditCardRadioButton = new JRadioButton("Credit/Debit Card");

	JRadioButton cashRadioButton = new JRadioButton("Cash");

	// JTextField

	JTextField creditCardTextFieldOne = new JTextField(4);

	JTextField creditCardTextFieldTwo = new JTextField(4);
	JTextField creditCardTextFieldThree = new JTextField(4);
	JTextField creditCardTextFieldFour = new JTextField(4);

	JTextField expiryDateTextFieldOne = new JTextField(4);

	JTextField expiryDateTextFieldTwo = new JTextField(4);

	JPasswordField cvvNumberTextField = new JPasswordField(4);

	public static JLabel billAmount = new JLabel("Amount: ");
	// JButton

	JButton payButton = new JButton("Pay and Exit");

	static JFrame f;

	public PaymentGUI() {

		initGUI();
		doTheLayout();
		disableAllFields();
		setNames();
		
		
		creditCardRadioButton
				.addActionListener(new java.awt.event.ActionListener() {
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

		creditCardTextFieldOne.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (creditCardTextFieldOne.getText().length() >= 3) // limit
																	// textfield
																	// to 3
																	// characters
					creditCardTextFieldTwo.grabFocus();
			}
		});

		creditCardTextFieldTwo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (creditCardTextFieldTwo.getText().length() >= 3) // limit
																	// textfield
																	// to 3
																	// characters
					creditCardTextFieldThree.grabFocus();
			}
		});

		creditCardTextFieldThree.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (creditCardTextFieldThree.getText().length() >= 3) // limit
																		// textfield
																		// to 3
																		// characters
					creditCardTextFieldFour.grabFocus();
			}
		});

		cashRadioButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				disableAllFields();

			}

		});

		payButton.addActionListener(new ActionListener() {

			AttendantBO attendantBo = new AttendantBO();
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
				boolean creditCardPayment = creditCardRadioButton.isSelected();
				boolean cash = cashRadioButton.isSelected();
				if (creditCardPayment) {

					String creditCard = Utilities.handleNullPointerException(
							creditCardTextFieldOne.getText()).trim()
							+ Utilities
									.handleNullPointerException(creditCardTextFieldTwo
											.getText().trim())
							+ Utilities
									.handleNullPointerException(creditCardTextFieldThree
											.getText().trim())
							+ Utilities
									.handleNullPointerException(creditCardTextFieldFour
											.getText().trim());

					validateCreditCard(creditCard);

				} else if (cash){
					attendantBo.updateEndDate(UserGUI.ticketNumberTextArea.getText());
					
					PaymentGUI.dispose();
					JOptionPane.showMessageDialog(null,
							"Payment Successful !!!");
					
					
					int numberofAvailableCars = AdminDAO.getNumberOfAvailableSlots();
					
					UserGUI.numberofAvailableCars.setText("Number of Available Lots = " + numberofAvailableCars);
				}

			}

			private void validateCreditCard(String creditCard) {

				CreditCardValidation validate = new CreditCardValidation();

				String month = expiryDateTextFieldOne.getText().trim();
				String year = expiryDateTextFieldTwo.getText().trim();
				String cvv = cvvNumberTextField.getText().trim();

				boolean isEmpty = false;

				if (creditCard.trim().equals("")) {
					isEmpty = true;
					JOptionPane.showMessageDialog(null,
							"Credit Card cannot be empty", "Credit Card Error",
							JOptionPane.ERROR_MESSAGE);
				}

				if (!isEmpty) {
					if (validate.aValidNumber(creditCard)) {

						boolean validateOtherDetails = validateOtherDetails();

						if (validateOtherDetails) {
							attendantBo.updateEndDate(UserGUI.ticketNumberTextArea.getText());
							int numberOfHours = AttendantDAO
									.getNumberOfHours(UserGUI.ticketNumberTextArea
											.getText());
							double amountToDeduct = numberOfHours * 10;
							boolean isCreditCardExists = AttendantDAO
									.checkCreditCardExists(creditCard, month,
											year, cvv, amountToDeduct);
							if (isCreditCardExists) {
								UserGUI.dispose();
								AttendantDAO.updateBalance(creditCard, month,
										year, cvv, amountToDeduct);
								JOptionPane.showMessageDialog(null,
										"Payment Successful !!!");
								String[] strings = null;
								UserGUI.main(strings);
								
								int numberofAvailableCars = AdminDAO.getNumberOfAvailableSlots();
								UserGUI.numberofAvailableCars.setText("Number of Available Lots = " + numberofAvailableCars);
							}
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Not a valid Credit Card.",
								"Credit Card Error", JOptionPane.ERROR_MESSAGE);

						creditCardTextFieldOne.setText("");
						creditCardTextFieldTwo.setText("");
						creditCardTextFieldThree.setText("");
						creditCardTextFieldFour.setText("");
					}
				}

			}

			private boolean validateOtherDetails() {
				boolean validateOtherDetails = true;

				String month = expiryDateTextFieldOne.getText().trim();
				String year = expiryDateTextFieldTwo.getText().trim();
				String cvv = cvvNumberTextField.getText().trim();

				int currentYear = 2016;

				if (month.equals("")) {
					JOptionPane.showMessageDialog(null,
							"Credit Card Expiry Month cannot be empty",
							"Credit Card Error", JOptionPane.ERROR_MESSAGE);
					validateOtherDetails = false;
				} else if (!checkInteger(month)) {
					JOptionPane.showMessageDialog(null,
							"Not a valid Credit Card Expiry Month (1-12)",
							"Credit Card Error", JOptionPane.ERROR_MESSAGE);
					validateOtherDetails = false;
					expiryDateTextFieldOne.setText("");
				} else if (!validMonth(month)) {
					JOptionPane.showMessageDialog(null,
							"Not a valid Credit Card Expiry Month (1-12)",
							"Credit Card Error", JOptionPane.ERROR_MESSAGE);
					validateOtherDetails = false;
					expiryDateTextFieldOne.setText("");
				} else if (!checkInteger(year)) {
					JOptionPane.showMessageDialog(null,
							"Not a valid Credit Card Expiry Year",
							"Credit Card Error", JOptionPane.ERROR_MESSAGE);
					validateOtherDetails = false;
					expiryDateTextFieldTwo.setText("");
				} else if ((Integer.parseInt(year) < currentYear)) {
					JOptionPane.showMessageDialog(null,
							"Card Expiry Year cannot be in the past",
							"Credit Card Error", JOptionPane.ERROR_MESSAGE);
					validateOtherDetails = false;
					expiryDateTextFieldTwo.setText("");
				} else if (cvv.equals("")) {
					JOptionPane.showMessageDialog(null, "Cvv cannot be empty",
							"Credit Card Error", JOptionPane.ERROR_MESSAGE);
					validateOtherDetails = false;
				} else if (!checkInteger(cvv)) {
					JOptionPane.showMessageDialog(null, "Not a valid Cvv",
							"Credit Card Error", JOptionPane.ERROR_MESSAGE);
					validateOtherDetails = false;
					cvvNumberTextField.setText("");
				} else if (Integer.parseInt(cvv) > 999) {
					JOptionPane.showMessageDialog(null, "Not a valid Cvv",
							"Credit Card Error", JOptionPane.ERROR_MESSAGE);
					validateOtherDetails = false;
					cvvNumberTextField.setText("");
				}

				return validateOtherDetails;
			}

			private boolean validMonth(String month) {

				boolean validMonth = false;

				for (int i = 1; i <= 12; i++) {

					if (i == Integer.parseInt(month)) {
						validMonth = true;
						break;
					}

				}
				return validMonth;
			}

			private boolean checkInteger(String input) {

				boolean checkInteger = true;

				try {

					Integer.parseInt(input);

				} catch (Exception e) {
					checkInteger = false;
				}
				return checkInteger;
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

	public static void dispose() {

		if (f != null)
			f.dispose();

	}

	private void initGUI() {

		ButtonGroup group = new ButtonGroup();
		group.add(creditCardRadioButton);
		group.add(cashRadioButton);

	}// end of creating objects method

	private void doTheLayout() {

		try {

			GridBagLayout gbl = new GridBagLayout();
			setLayout(gbl);

			gbc.insets = new Insets(10, 10, 10, 10);

			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.EAST;
			add(creditCardRadioButton, gbc);

			gbc.gridx = 2;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.EAST;
			add(billAmount,gbc);
			
			gbc.gridx = 4;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.EAST;
			add(cashRadioButton, gbc);

			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.WEST;
			add(creditCardTextFieldOne, gbc);

			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.WEST;
			add(creditCardTextFieldTwo, gbc);

			gbc.gridx = 2;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.WEST;
			add(creditCardTextFieldThree, gbc);

			gbc.gridx = 3;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.WEST;
			add(creditCardTextFieldFour, gbc);

			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.WEST;
			add(expiryDateLabel, gbc);

			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.WEST;
			add(expiryDateTextFieldOne, gbc);

			gbc.gridx = 2;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.WEST;
			add(expiryDateTextFieldTwo, gbc);

			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.anchor = GridBagConstraints.WEST;
			add(cvvNumberLabel, gbc);

			gbc.gridx = 1;
			gbc.gridy = 3;
			gbc.anchor = GridBagConstraints.WEST;
			add(cvvNumberTextField, gbc);

			gbc.gridx = 2;
			gbc.gridy = 4;
			gbc.anchor = GridBagConstraints.WEST;
			add(payButton, gbc);

		} catch (Exception e) {

		}

	}// end of Layout method

	public static void main(String[] args) {

		f = new JFrame("Payment Info");
		Container contentPane = f.getContentPane();
		f.setResizable(false);
		contentPane.add(new PaymentGUI());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		f.setResizable(false);
		// f.setSize(400, 200);
		f.setVisible(true);

	}

	public static void openPayment() {

		f = new JFrame("Payment Info");
		Container contentPane = f.getContentPane();
		f.setResizable(false);
		contentPane.add(new PaymentGUI());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		f.setResizable(false);
		// f.setSize(400, 200);
		f.setVisible(true);

	}
	
	private void setNames(){

		expiryDateLabel.setName(ComponentNames.EXPIRY_DATE_LABEL);
		cvvNumberLabel.setName(ComponentNames.CVV_NUMBER_LABEL);
		// JRadioButton

		creditCardRadioButton.setName(ComponentNames.CREDIT_CARD_RADIO_BUTTON);

		cashRadioButton.setName(ComponentNames.CASH_RADIO_BUTTON);
		// JTextField

		creditCardTextFieldOne.setName(ComponentNames.CREDIT_CARD_TEXT_FIELD_ONE);

		creditCardTextFieldTwo.setName(ComponentNames.CREDIT_CARD_TEXT_FIELD_TWO);
		creditCardTextFieldThree.setName(ComponentNames.CREDIT_CARD_TEXT_FIELD_THREE);
		creditCardTextFieldFour.setName(ComponentNames.CREDIT_CARD_TEXT_FIELD_FOUR);

		expiryDateTextFieldOne.setName(ComponentNames.EXPIRY_DATE_TEXT_FIELD_ONE);

		expiryDateTextFieldTwo.setName(ComponentNames.EXPIRY_DATE_TEXT_FIELD_TWO);

		cvvNumberTextField.setName(ComponentNames.CVV_NUMBER_TEXT_FIELD);
		billAmount.setName(ComponentNames.BILL_AMOUNT_LABEL);
	}
	public static void setBillAmount(Double amount){
		billAmount.setText("Amount: " + amount);
	}

}
