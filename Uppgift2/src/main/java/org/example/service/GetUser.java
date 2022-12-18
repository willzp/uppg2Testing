package org.example.service;

import java.util.ArrayList;

public class GetUser {


    public GetUser(ArrayList<UserInfo> users) {
        this.users = users;
    }

    // UserInfo user = new UserInfo();
  private ArrayList<UserInfo> users;


   public String  getUserFromCardId(int id){
       for(int i=0; i< users.size(); i++){

           if(id == users.get(i).getCardId() && users.get(i).isCardBlocked() == false){
               return users.get(i).getUser();
           }
       }

        return null;
   }



}
