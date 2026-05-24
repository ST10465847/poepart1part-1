package com.mycompany.poepart1;

public class account {
   
    private String username;
    private String password;
    private String cellPhone;
    private String firstName;
    private String lastName;
    
    // Constructor
    public account(String username, String password, String cellPhone, 
                   String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    // CHECKING FOR  uSERNAME
    public boolean checkUserName() {
        boolean hasUnderscore = this.username.contains("_");
        boolean isShortEnough = this.username.length() <= 5;
        
        if (hasUnderscore && isShortEnough) {
            return true;
        } else {
            return false;
        }
    }
    
    // CHECK PASSWORD TO PROCESSED  to the next step
    public boolean checkPasswordComplexity() {
        
        if (this.password.length() < 8) {
            return false;
        }
        
        boolean hasCapital = false;
        for (int i = 0; i < this.password.length(); i++) {
            char c = this.password.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                hasCapital = true;
                break;
            }
        }
        if (hasCapital == false) {
            return false;
        }
        
        boolean hasNumber = false;
        for (int i = 0; i < this.password.length(); i++) {
            char c = this.password.charAt(i);
            if (c >= '0' && c <= '9') {
                hasNumber = true;
                break;
            }
        }
        if (hasNumber == false) {
            return false;
        }
        
        boolean hasSpecial = false;
        for (int i = 0; i < this.password.length(); i++) {
            char c = this.password.charAt(i);
            boolean isLetter = (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
            boolean isNumber = (c >= '0' && c <= '9');
            
            if (isLetter == false && isNumber == false) {
                hasSpecial = true;
                break;
            }
        }
        if (hasSpecial == false) {
            return false;
        }
        
        return true;
    }
    
    // CHECK PHONE NUMBER IF IT STARTS WITH +27 plus it must be 9 digts
    public boolean checkCellPhoneNumber() {
       
        if (this.cellPhone.startsWith("+27") == false) {
            return false;
        }
        
        if (this.cellPhone.length() != 12) {
            return false;
        }
       
        for (int i = 3; i < this.cellPhone.length(); i++) {
            char c = this.cellPhone.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        
        return true;
    }
    
    // REGISTER USER TO COLLECT USER DETAILS 
    public String registerUser() {
      
        if (checkUserName() == false) {
            return "Username invalid. Make sure it has an _ and is 5 characters or less.";
        }
        
        if (checkPasswordComplexity() == false) {
            return "Your Password is too weak. Needs 8+ chars, a CAPITAL letter, a number, and a special character like !@#.";
        }
       
        if (checkCellPhoneNumber() == false) {
            return "The Phone number is invalid. Must start with +27 and have 9 digits after.";
        }
        
        return "Registration complete! Account created successfully.";
    }
    
    //  LOGIN USER wanted details
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    //RETURN LOGIN STATUS TO processed 
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + this.firstName + " " + this.lastName + " it's good to have you back!";
        } else {
            return "Wrong username or password. Please try again.";
        }
    }
    
    // GETTER METHODS 
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getCellPhone() {
        return cellPhone;
    }
}