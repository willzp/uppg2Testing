package org.example.service;

public class bankTransaction {
    private UserInfo user;

    public bankTransaction(UserInfo user) {
        this.user = user;
    }

    public int checkBalance(){
       return user.getBalance();
    }



    public void addMoney(int sum){
        if(user.isLoggedIn() == true){
            user.setBalance(user.getBalance()+ sum);
        }
    }
    public String takeOutMoney(int sum){
        if(sum < user.getBalance() && user.isLoggedIn() == true) {
            user.setBalance(user.getBalance()-sum);
        }
        if(sum > user.getBalance() && user.isLoggedIn() == true){
            return "there is not enough money";
        }
        return null;
    }



}
