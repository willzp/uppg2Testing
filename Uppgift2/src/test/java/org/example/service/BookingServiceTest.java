package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class BookingServiceTest {

    private UserInfo user;
    private CheckPinNumber checkPin;
    private bankTransaction transaction;
    private GetUser getUser;




    @BeforeEach
    public void setup() {
        user = mock(UserInfo.class);
        checkPin = mock(CheckPinNumber.class);
        transaction = mock(bankTransaction.class);
        getUser = mock(GetUser.class);
    }

    @Test void TestCheckPinNumber(){
        user = new  UserInfo("adam",123,111,80);
        checkPin = new CheckPinNumber(user);
        String actual = checkPin.logInUser(111);
        String expected = "logged in";
        assertEquals(expected,actual);
    }

    @Test void TestIfCardIsBlocked(){
        user = new  UserInfo("adam",123,123,80);
        checkPin = new CheckPinNumber(user);
        checkPin.logInUser(222);
        checkPin.logInUser(222);
        String actual = checkPin.logInUser(222);
        String expected = "your card has been blocked";
        assertEquals(expected,actual);
        assertEquals(true,user.isCardBlocked() );
    }

    @Test void TestAddMoney(){
        user = new  UserInfo("adam",123,211,80);
        user.setLoggedIn(true);
        transaction = new bankTransaction(user);
        transaction.addMoney(10);
        int actual = user.getBalance();
        int expected = 90;
        assertEquals(expected,actual);
    }

    @Test void TestCheckMoney(){
        user = new  UserInfo("adam",123,211,100);
        transaction = new bankTransaction(user);
        int actual = transaction.checkBalance();;
        int expected = 100;
        assertEquals(expected,actual);
    }

    @Test void TestVerifyAddMoney(){
        transaction.addMoney(10);
        verify(transaction, times(1)).addMoney(anyInt());
    }

    @Test void TestVerifyTakeOutMoney(){
        transaction.takeOutMoney(10);
        verify(transaction, times(1)).takeOutMoney(anyInt());
    }

    @Test void TestTakeOutMoney() {
        user = new UserInfo("adam", 123, 211, 80);
        user.setLoggedIn(true);
        transaction = new bankTransaction(user);
        transaction.takeOutMoney(10);
        int actual = user.getBalance();
        int expected = 70;
        assertEquals(expected, actual);
    }

    @Test void TestTakeOutToMuchMoney() {
        user = new UserInfo("adam", 123, 211, 80);
        user.setLoggedIn(true);
        transaction = new bankTransaction(user);
        String actual = transaction.takeOutMoney(100);
        String expected = "there is not enough money";
        assertEquals(expected, actual);
    }

    @Test void TestGetUserFromPin(){
        ArrayList<UserInfo> users = new ArrayList<>();
        UserInfo user = new UserInfo("emma", 111, 455, 10);
        UserInfo user2 = new UserInfo("john", 222, 233, 20);
        UserInfo user3 = new UserInfo("adam", 333, 811, 80);
        users.add(user);
        users.add(user2);
        users.add(user3);
        getUser = new GetUser(users);
        String actual = getUser.getUserFromCardId(111);
        String expected = "emma";
        assertEquals(expected,actual);
    }
    
}