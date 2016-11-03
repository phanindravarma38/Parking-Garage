package cs414.a4.phanisag.model;

import java.util.Date;

public class PaymentDetails {

	private String paymentMethod;
	private String cardNumber;
	
	private String fullName;
	private String cardType;
	private Date expiryDate;
	private String accountNumber;
	private String routingNumber;
	private String cvv1;
	private String cvv2;
	private Double amount;
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public String getFullName() {
		return fullName;
	}
	public String getCardType() {
		return cardType;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getRoutingNumber() {
		return routingNumber;
	}
	public String getCvv1() {
		return cvv1;
	}
	public String getCvv2() {
		return cvv2;
	}
	public Double getAmount() {
		return amount;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}
	public void setCvv1(String cvv1) {
		this.cvv1 = cvv1;
	}
	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
	
}
