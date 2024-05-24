//$Id$
package com.letsCode.Model;

public class Card {
	private int AccountNumber;
	private int CardNumber;
	private String ExpiryDate;
	private int Cvv;
	private String NameOnCard;
	private int ATMPIn;
	private String CardType;
	private int CreditLimit ;
	

	public Card(int AccountNumber, int CardNumber, String ExpiryDate, int Cvv , String NameOnCard, int ATMPIn, String CardType, int CreditLimit) {
		this.setAccountNumber(AccountNumber);
		this.setCardNumber(CardNumber);
        this.setExpiryDate(ExpiryDate);
        this.setCvv(Cvv);
        this.setNameOnCard(NameOnCard);
        this.setATMPIn(ATMPIn);
        this.setCardType(CardType);
        this.setCreditLimit(CreditLimit);


	}
	
	public Card() {
		this.setAccountNumber(0);
		this.setCardNumber(0);
        this.setExpiryDate("");
        this.setCvv(0);
        this.setNameOnCard("");
        this.setATMPIn(0);
        this.setCardType("");
        this.setCreditLimit(0);
	}

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getExpiryDate() {
		return ExpiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}

	public int getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(int cardNumber) {
		CardNumber = cardNumber;
	}

	public int getCvv() {
		return Cvv;
	}

	public void setCvv(int cvv) {
		Cvv = cvv;
	}

	public String getNameOnCard() {
		return NameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		NameOnCard = nameOnCard;
	}

	public int getCreditLimit() {
		return CreditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		CreditLimit = creditLimit;
	}

	public int getATMPIn() {
		return ATMPIn;
	}

	public void setATMPIn(int aTMPIn) {
		ATMPIn = aTMPIn;
	}

	public String getCardType() {
		return CardType;
	}

	public void setCardType(String cardType) {
		CardType = cardType;
	}
}
