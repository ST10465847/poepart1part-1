package com.mycompany.poepart1;

import java.util.Scanner;

public class Poepart1 {
    
    public static void main(String[] args) {
        
        //scanner 
        Scanner input = new Scanner(System.in);
        
        //Registration Process 
        System.out.println("=== Register ===");
       
        System.out.print("Please enter First Name >> ");
        String firstName = input.nextLine();
        
        System.out.print("Please enter Last Name >> ");
        String lastName = input.nextLine();
        
        System.out.print("Please enter Username >> ");
        String username = input.nextLine();
        
        System.out.print("Please enter Password >> ");
        String password = input.nextLine();
        
        System.out.print("Please enter Cell Phone Number >> ");
        String cellPhone = input.nextLine();
        
        account user = new account(username, password, cellPhone, firstName, lastName);
  
        String result = user.registerUser();
        System.out.println(result);
        
        // If registration failed, stop the program 
        if (result.contains("invalid") || result.contains("weak")) {
            input.close();
            return;
        }
        
        //login process 
        System.out.println("\n=== Login ===");
      
        System.out.print("Enter your Username >> ");
        String logUsername = input.nextLine();
      
        System.out.print("Enter your Password >> ");
        String logPassword = input.nextLine();
        
        // Check login and show message
        String loginStatus = user.returnLoginStatus(logUsername, logPassword);
        System.out.println(loginStatus);
        
        // Close scanner
        input.close();
    }
}