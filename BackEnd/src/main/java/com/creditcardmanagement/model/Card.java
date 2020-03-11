package com.creditcardmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {
    @Id
    private Long cardNumber;
    private String userName;
    private int cardLimit;
    private int cardBalance;

    public int getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(int cardBalance) {
		this.cardBalance = cardBalance;
	}

	public Card() {
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(int cardLimit) {
        this.cardLimit = cardLimit;
    }
}
