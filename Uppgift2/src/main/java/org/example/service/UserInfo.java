package org.example.service;

public class UserInfo {

    private String user;
    private int cardId;
    private int pin;

    public UserInfo(String user, int cardId, int pin, int balance) {
        this.user = user;
        this.cardId = cardId;
        this.pin = pin;
        this.balance = balance;
    }

    private int pinCount;
    private boolean loggedIn;

    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }



    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


    private boolean isCardBlocked;

    public boolean isCardBlocked() {
        return isCardBlocked;
    }

    public void setCardBlocked(boolean cardBlocked) {
        isCardBlocked = cardBlocked;
    }

    public int getPinCount() {
        return pinCount;
    }

    public void setPinCount(int pinCount) {
        this.pinCount = pinCount;
    }



    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }


}
