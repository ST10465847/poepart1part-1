package com.mycompany.poepart1;
public class account {
   
    private String username;
    private String password;
    private String cellPhone;
    private String firstName;
    private String lastName;
    
    //contractor
    public account(String username, String password, String cellPhone, 
                   String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    //Cheaking for userName 
    // Username must contain _ and be 5 characters or less
    public boolean checkUserName() {
        //Cheaking if username has underscore and length is 5 or less
        boolean hasUnderscore = this.username.contains("_");
       
        boolean isShortEnough = this.username.length() <= 5;
       //Return if both are true 
        if (hasUnderscore && isShortEnough) {
            return true;
        } else {
            return false;
        }
    }
    
    // Cheaking Password must have: 8+ chars, capital letter, number, special character
    public boolean checkPasswordComplexity() {
        
        if (this.password.length() < 8) {
            return false;
        }
        
       // Check if capital letter (A to Z)are added
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
        
        // cheaking for numbers(0 to 9)
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
        
        //Cheaking for special character (not letter, not number)
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
    
    // Cheaking Number Phone must start with +27 and have 9 digits after
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
    
   //REGISTRATION OUTCOMES 
    public String registerUser() {
      
        if (checkUserName() == false) {
            return "Username invalid. Make sure it has an _ and is 5 characters or less.";
        }
        
        if (checkPasswordComplexity() == false) {
            return " Your Password is too weak. Needs 8+ chars, a CAPITAL letter, a number, and a special character like !@#.";
        }
       
        if (checkCellPhoneNumber() == false) {
            return "The Phone number is invalid. Must start with +27 and have 9 digits after.";
        }
        
        //If all checks passed 
        return "Registration complete! Account created successfully.";
    }
    
    //user loged in
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    // Return Login User Staus 
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return " Welcome " + this.firstName + " " + this.lastName + "its to  good to have you back!.";
        } else {
            return "Wrong username or password. Please try again.";
        }
    }
}
