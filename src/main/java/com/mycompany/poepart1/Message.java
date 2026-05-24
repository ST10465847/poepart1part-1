package com.mycompany.poepart1;

public class Message  {
    
    // Create random message ID (10 digits)
    public String createMessageID() {
        String id = "";
        for (int i = 0; i < 10; i++) {
            int num = (int)(Math.random() * 10);
            id = id + num;
        }
        return id;
    }
    
    // Create message HASH
    public String createMsgHash(String messageID, String message, int msgNumber) {
        // Get first 2 digits of ID
        String firstTwo = messageID.substring(0, 2);
        
        // Get first word
        String firstWord = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                firstWord = message.substring(0, i);
                break;
            }
        }
        
        // Get last word of the meaage 
        String lastWord = "";
        int lastSpace = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                lastSpace = i;
            }
        }
        lastWord = message.substring(lastSpace + 1);
        
        // Make uppercase in oder to processed 
        firstWord = firstWord.toUpperCase();
        lastWord = lastWord.toUpperCase();
        
        return firstTwo + ":" + msgNumber + ":" + firstWord + lastWord;
    }
    
    // Check user cell number if its good to procced
    public String checkRecipientCell(String cellNumber) {
        if (cellNumber.startsWith("+27") && cellNumber.length() == 12) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again to aviod being sent to wron number .";
        }
    }
    
    // Check message length to processed to send message
    public String checkMessageLength(String message) {
        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            int excess = message.length() - 250;
            return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
        }
    }
    
    // Get user choice (Send, Delete, Store)
    public String getUserChoice(java.util.Scanner scan) {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Send Message");
        System.out.println("2. Delete Message");
        System.out.println("3. Store Message");
        System.out.print("Choose >> ");
        
        int choice = scan.nextInt();
        
        if (choice == 1) {
            return "Message successfully sent.";
        } else if (choice == 2) {
            return "Press 0 to delete the message.";
        } else if (choice == 3) {
            return "Message successfully stored.";
        } else {
            return "Invalid choice.";
        }
    }
}