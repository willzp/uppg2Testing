package org.example.service;

public class CheckPinNumber {

    public CheckPinNumber(UserInfo user) {
        this.user = user;
    }

    // UserInfo user = new UserInfo();
    private UserInfo user;

    public String logInUser(int pin){
        if(pin == user.getPin()){
            user.setLoggedIn(true);
            return "logged in";
        }
        else{
            user.setPinCount(user.getPinCount() + 1);
        }
        if(user.getPinCount() == 1){
            return "Wrong pin you have 2 more tries";
        }
        if(user.getPinCount() == 2){
            return "Wrong pin you have 1 more tries";
        }
        if(user.getPinCount() == 3){
            user.setCardBlocked(true);
            return "your card has been blocked";
        }

      return null;
    }

}
