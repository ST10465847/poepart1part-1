package com.mycompany.poepart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class poeUnitTest {
    
    account acc;
    
    @Test
    public void testValidUsername() {
        acc = new account("sin_9", "Sithol_@9", "+27799495626", "Sinethemba", "Sithole");
        assertEquals(true, acc.checkUserName());
    }
    
    @Test
    public void testInvalidUsername() {
        acc = new account("sinethe", "Sithol_@9", "+27799495626", "Sinethemba", "Sithole");
        assertEquals(false, acc.checkUserName());
    }
    
    @Test
    public void testValidPassword() {
        acc = new account("sin_9", "Sithol_@9", "+27799495626", "Sinethemba", "Sithole");
        assertEquals(true, acc.checkPasswordComplexity());
    }
    
    @Test
    public void testInvalidPassword() {
        acc = new account("sin_9", "sithol_@9", "+27799495626", "Sinethemba", "Sithole");
        assertEquals(false, acc.checkPasswordComplexity());
    }
    
    @Test
    public void testValidPhone() {
        acc = new account("sin_9", "Sithol_@9", "+27799495626", "Sinethemba", "Sithole");
        assertEquals(true, acc.checkCellPhoneNumber());
    }
    
    @Test
    public void testInvalidPhone() {
        acc = new account("sin_9", "Sithol_@9", "0799495626", "Sinethemba", "Sithole");
        assertEquals(false, acc.checkCellPhoneNumber());
    }
    
    @Test
    public void testLoginSuccess() {
        acc = new account("sin_9", "Sithol_@9", "+27799495626", "Sinethemba", "Sithole");
        assertEquals(true, acc.loginUser("sin_9", "Sithol_@9"));
    }
    
    @Test
    public void testLoginFail() {
        acc = new account("sin_9", "Sithol_@9", "+27799495626", "Sinethemba", "Sithole");
        assertEquals(false, acc.loginUser("sin_9", "wrong"));
    }
}