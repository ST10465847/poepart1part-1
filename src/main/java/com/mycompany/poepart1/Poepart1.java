package com.mycompany.poepart1;

import java.util.Scanner;

public class Poepart1 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        account user = null;
        boolean loggedIn = false;
        
        System.out.println("=== Welcome to QuickChat ===");
        
        // LOGIN OR REGISTER FIRST to processed 
        while (loggedIn == false) {
            System.out.println("\n1. Login");
            System.out.println("2. Register New Account");
            System.out.print("Choose option >> ");
            int loginChoice = scan.nextInt();
            scan.nextLine();
            
            if (loginChoice == 2) {
                // Registration process 
                System.out.println("\n=== Register ===");
                System.out.print("First Name >> ");
                String firstName = scan.nextLine();
                System.out.print("Last Name >> ");
                String lastName = scan.nextLine();
                System.out.print("Username (must contain _ and be 5 or less chars) >> ");
                String username = scan.nextLine();
                System.out.print("Password (8+ chars, capital, number, special) >> ");
                String password = scan.nextLine();
                System.out.print("Cell Phone (+27...) >> ");
                String cellPhone = scan.nextLine();
                
                user = new account(username, password, cellPhone, firstName, lastName);
                String result = user.registerUser();
                System.out.println(result);
                
            } else if (loginChoice == 1) {
                // Login process 
                if (user == null) {
                    System.out.println("No account found. Please register first.");
                } else {
                    System.out.print("Enter Username >> ");
                    String loginUser = scan.nextLine();
                    System.out.print("Enter Password >> ");
                    String loginPass = scan.nextLine();
                    
                    if (user.loginUser(loginUser, loginPass)) {
                        System.out.println(user.returnLoginStatus(loginUser, loginPass));
                        loggedIn = true;
                    } else {
                        System.out.println("Wrong username or password. Try again.");
                    }
                }
            }
        }
        
        // Arrays to store messages 
        String[] savedIDs = new String[100];
        String[] savedHashes = new String[100];
        String[] savedRecipients = new String[100];
        String[] savedMessages = new String[100];
        String[] savedStatus = new String[100];
        int msgCount = 0;
        int totalSent = 0;
        
        Message msgObj = new Message();
        
        // MAIN MENU LOOP
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages (Coming Soon)");
            System.out.println("3. Quit");
            System.out.print("Choose option >> ");
            choice = scan.nextInt();
            scan.nextLine();
            
            if (choice == 1) {
                System.out.print("How many messages do you want to send? >> ");
                int numMessages = scan.nextInt();
                scan.nextLine();
                
                for (int i = 1; i <= numMessages; i++) {
                    System.out.println("\n--- Message " + i + " ---");
                    
                    System.out.print("Enter recipient cell number (+27...) >> ");
                    String recipient = scan.nextLine();
                    
                    System.out.print("Enter your message (max 250 chars) >> ");
                    String messageText = scan.nextLine();
                    
                    // Check phone number
                    String phoneCheck = msgObj.checkRecipientCell(recipient);
                    if (!phoneCheck.equals("Cell phone number successfully captured.")) {
                        System.out.println(phoneCheck);
                        i--;
                        continue;
                    }
                    
                    // Check message length
                    String lengthCheck = msgObj.checkMessageLength(messageText);
                    if (!lengthCheck.equals("Message ready to send.")) {
                        System.out.println(lengthCheck);
                        i--;
                        continue;
                    }
                    
                    // Create message ID and Hash
                    String messageID = msgObj.createMessageID();
                    String messageHash = msgObj.createMsgHash(messageID, messageText, i);
                    
                    // Show message details
                    System.out.println("\n--- Message Details ---");
                    System.out.println("Message ID: " + messageID);
                    System.out.println("Hash Code: " + messageHash);
                    System.out.println("Recipient: " + recipient);
                    System.out.println("Message: " + messageText);
                    
                    // Ask what to do with message
                    String result = msgObj.getUserChoice(scan);
                    System.out.println(result);
                    
                    // Save if sent or stored
                    if (result.equals("Message successfully sent.") || result.equals("Message successfully stored.")) {
                        savedIDs[msgCount] = messageID;
                        savedHashes[msgCount] = messageHash;
                        savedRecipients[msgCount] = recipient;
                        savedMessages[msgCount] = messageText;
                        
                        if (result.equals("Message successfully sent.")) {
                            savedStatus[msgCount] = "Sent";
                            totalSent++;
                        } else {
                            savedStatus[msgCount] = "Stored";
                        }
                        msgCount++;
                    }
                }
                
                // Show all messages
                System.out.println("\n=== All Messages ===");
                for (int i = 0; i < msgCount; i++) {
                    System.out.println("Message ID: " + savedIDs[i]);
                    System.out.println("Hash Code: " + savedHashes[i]);
                    System.out.println("Recipient: " + savedRecipients[i]);
                    System.out.println("Message: " + savedMessages[i]);
                    System.out.println("Status: " + savedStatus[i]);
                    System.out.println("------------------------");
                }
                System.out.println("Total messages sent: " + totalSent);
                
            } else if (choice == 2) {
                System.out.println("Coming Soon - Feature still in development.");
            } else if (choice == 3) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        
        scan.close();
    }
}