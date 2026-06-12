package com.mycompany.poepart1;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Poepart1 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        account user = null;
        boolean loggedIn = false;
        
        System.out.println("=== Welcome to QuickChat ====");
        
        // LOGIN OR REGISTER FIRST to processed 
        while (loggedIn == false) {
            System.out.println("\n1. Login");
            System.out.println("2. Register New Account");
            System.out.print("Choose option >> ");
            int loginChoice = scan.nextInt();
            scan.nextLine();
            
            if (loginChoice == 2) {
                // Registration process in order to proceesed with quickChat 
                System.out.println("\n=== Register ===");
                System.out.print("First Name >> ");
                String firstName = scan.nextLine();
                System.out.print("surname >> ");
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
                // Login process after finnshing the registation process  
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
        
        // ARRAYS for storing messages by type===
        String[] sentMessagesArray = new String[100];
        String[] disregardedMessagesArray = new String[100];
        String[] storedMessagesArray = new String[100];
        
        // Arrays to store all message 
        String[] savedIDs = new String[100];
        String[] savedHashes = new String[100];
        String[] savedRecipients = new String[100];
        String[] savedMessages = new String[100];
        String[] savedStatus = new String[100];
        
        int sentCount = 0;
        int disregardedCount = 0;
        int storedCount = 0;
        int msgCount = 0;
        int totalSent = 0;
        
        Message msgObj = new Message();
        
        //========== PART 3 - LOAD TEST DATA FROM ASSIGNMENT ==========
        System.out.println("\n=== Loading Test Data ===");
        
        // Test Message 1 - Sent
        String id1 = msgObj.createMessageID();
        String hash1 = msgObj.createMsgHash(id1, "Did you get the cake?", 1);
        sentMessagesArray[sentCount] = "Did you get the cake?";
        savedIDs[msgCount] = id1;
        savedHashes[msgCount] = hash1;
        savedRecipients[msgCount] = "+27834557896";
        savedMessages[msgCount] = "Did you get the cake?";
        savedStatus[msgCount] = "Sent";
        sentCount++;
        msgCount++;
        totalSent++;
        
        // Test Message 2 - Stored
        String id2 = msgObj.createMessageID();
        String hash2 = msgObj.createMsgHash(id2, "Where are you? You are late! I have asked you to be on time.", 2);
        storedMessagesArray[storedCount] = "Where are you? You are late! I have asked you to be on time.";
        savedIDs[msgCount] = id2;
        savedHashes[msgCount] = hash2;
        savedRecipients[msgCount] = "+27838884567";
        savedMessages[msgCount] = "Where are you? You are late! I have asked you to be on time.";
        savedStatus[msgCount] = "Stored";
        storedCount++;
        msgCount++;
        
        // Test Message 3 - Disregard
        String id3 = msgObj.createMessageID();
        String hash3 = msgObj.createMsgHash(id3, "Yohoooo, I am at your gate.", 3);
        disregardedMessagesArray[disregardedCount] = "Yohoooo, I am at your gate.";
        savedIDs[msgCount] = id3;
        savedHashes[msgCount] = hash3;
        savedRecipients[msgCount] = "+27834484567";
        savedMessages[msgCount] = "Yohoooo, I am at your gate.";
        savedStatus[msgCount] = "Disregard";
        disregardedCount++;
        msgCount++;
        
        // Test Message 4 - Sent
        String id4 = msgObj.createMessageID();
        String hash4 = msgObj.createMsgHash(id4, "It is dinner time!", 4);
        sentMessagesArray[sentCount] = "It is dinner time!";
        savedIDs[msgCount] = id4;
        savedHashes[msgCount] = hash4;
        savedRecipients[msgCount] = "0838884567";
        savedMessages[msgCount] = "It is dinner time!";
        savedStatus[msgCount] = "Sent";
        sentCount++;
        msgCount++;
        totalSent++;
        
        // Test Message 5 - Stored
        String id5 = msgObj.createMessageID();
        String hash5 = msgObj.createMsgHash(id5, "Ok, I am leaving without you.", 5);
        storedMessagesArray[storedCount] = "Ok, I am leaving without you.";
        savedIDs[msgCount] = id5;
        savedHashes[msgCount] = hash5;
        savedRecipients[msgCount] = "+27838884567";
        savedMessages[msgCount] = "Ok, I am leaving without you.";
        savedStatus[msgCount] = "Stored";
        storedCount++;
        msgCount++;
        
        System.out.println("Loaded " + msgCount + " test messages.");
        
        // ======== MAIN MENU LOOP(Updated - Option 3 is now Stored Messages, Option 4 is Quit) ==========
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages (Coming Soon)");
            System.out.println("3. Stored Messages");
            System.out.println("4. Quit");
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
                    
                    // Checking your phone number if it starts with +27
                    String phoneCheck = msgObj.checkRecipientCell(recipient);
                    if (!phoneCheck.equals("Cell phone number successfully captured.")) {
                        System.out.println(phoneCheck);
                        i--;
                        continue;
                    }
                    
                    // Checking message length that will be sent
                    String lengthCheck = msgObj.checkMessageLength(messageText);
                    if (!lengthCheck.equals("Message ready to send.")) {
                        System.out.println(lengthCheck);
                        i--;
                        continue;
                    }
                    
                    // Createing  message ID and Hash
                    String messageID = msgObj.createMessageID();
                    String messageHash = msgObj.createMsgHash(messageID, messageText, i);
                    
                    // Showing message details
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
                            sentMessagesArray[sentCount] = messageText;
                            sentCount++;
                            totalSent++;
                        } else if (result.equals("Message successfully stored.")) {
                            savedStatus[msgCount] = "Stored";
                            storedMessagesArray[storedCount] = messageText;
                            storedCount++;
                        }
                        msgCount++;
                    } else if (result.equals("Press 0 to delete the message.")) {
                        disregardedMessagesArray[disregardedCount] = messageText;
                        disregardedCount++;
                    }
                }
                
                // Show all messages so user can see or CHOSSE
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
                // ========== STORED MESSAGES MENU ==========
                System.out.println("\n=== Stored Messages Menu ===");
                System.out.println("a. Display sender and recipient of all stored messages");
                System.out.println("b. Display the longest stored message");
                System.out.println("c. Search for a message ID");
                System.out.println("d. Search for all messages for a particular recipient");
                System.out.println("e. Delete a message using message hash");
                System.out.println("f. Display report of all stored messages");
                System.out.print("Choose option >> ");
                String subChoice = scan.nextLine();
                
                if (subChoice.equals("a")) {
                    // a. Display sender and recipient of all stored messages
                    System.out.println("\n=== Sender and Recipient of Stored Messages ===");
                    for (int i = 0; i < storedCount; i++) {
                        if (storedMessagesArray[i] != null) {
                            System.out.println("Sender: " + user.getFirstName() + " " + user.getLastName());
                            System.out.println("Recipient: " + getRecipientForMessage(storedMessagesArray[i], savedRecipients, savedMessages, msgCount));
                            System.out.println("Message: " + storedMessagesArray[i]);
                            System.out.println("------------------------");
                        }
                    }
                    
                } else if (subChoice.equals("b")) {
                    // b. Display the longest stored message
                    String longest = "";
                    for (int i = 0; i < storedCount; i++) {
                        if (storedMessagesArray[i] != null && storedMessagesArray[i].length() > longest.length()) {
                            longest = storedMessagesArray[i];
                        }
                    }
                    System.out.println("\nThe longest stored message is:");
                    System.out.println(longest);
                    
                } else if (subChoice.equals("c")) {
                    // c. Search for a message ID
                    System.out.print("Enter Message ID to search: ");
                    String searchID = scan.nextLine();
                    boolean found = false;
                    for (int i = 0; i < msgCount; i++) {
                        if (savedIDs[i] != null && savedIDs[i].equals(searchID)) {
                            System.out.println("Recipient: " + savedRecipients[i]);
                            System.out.println("Message: " + savedMessages[i]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Message ID not found.");
                    }
                    
                } else if (subChoice.equals("d")) {
                    // d. Search for all messages for a particular recipient
                    System.out.print("Enter recipient number to search: ");
                    String searchRecipient = scan.nextLine();
                    System.out.println("\nMessages for " + searchRecipient + ":");
                    boolean found = false;
                    for (int i = 0; i < msgCount; i++) {
                        if (savedRecipients[i] != null && savedRecipients[i].equals(searchRecipient)) {
                            System.out.println("- " + savedMessages[i]);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No messages found for this recipient.");
                    }
                    
                } else if (subChoice.equals("e")) {
                    // e. Delete a message using message hash
                    System.out.print("Enter Message Hash to delete: ");
                    String searchHash = scan.nextLine();
                    boolean deleted = false;
                    for (int i = 0; i < msgCount; i++) {
                        if (savedHashes[i] != null && savedHashes[i].equals(searchHash)) {
                            System.out.println("Message: \"" + savedMessages[i] + "\" successfully deleted.");
                            savedHashes[i] = null;
                            savedIDs[i] = null;
                            savedRecipients[i] = null;
                            savedMessages[i] = null;
                            savedStatus[i] = null;
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Message hash not found.");
                    }
                    
                } else if (subChoice.equals("f")) {
                    // f. Display report of all stored messages
                    System.out.println("\n=== FULL MESSAGE REPORT ===");
                    for (int i = 0; i < msgCount; i++) {
                        if (savedHashes[i] != null) {
                            System.out.println("Message Hash: " + savedHashes[i]);
                            System.out.println("Recipient: " + savedRecipients[i]);
                            System.out.println("Message: " + savedMessages[i]);
                            System.out.println("Status: " + savedStatus[i]);
                            System.out.println("------------------------");
                        }
                    }
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
                
            } else if (choice == 4) {
                System.out.println("Goodbye hope to see you soon!");
                // Saveing  messages to JSON file before exiting
                saveMessagesToJSON(savedIDs, savedHashes, savedRecipients, savedMessages, savedStatus, msgCount);
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        
        scan.close();
    }
    
    // Helper method IT IS to get recipient for a message
    public static String getRecipientForMessage(String message, String[] recipients, String[] messages, int total) {
        for (int i = 0; i < total; i++) {
            if (messages[i] != null && messages[i].equals(message)) {
                return recipients[i];
            }
        }
        return "Unknown";
    }
    
    // ====== JSON METHODS for storing messages ======
   
    public static void saveMessagesToJSON(String[] ids, String[] hashes, String[] recipients, String[] messages, String[] status, int count) {
        try {
            FileWriter writer = new FileWriter("messages.json");
            writer.write("{\n");
            writer.write("  \"messages\": [\n");
            
            for (int i = 0; i < count; i++) {
                if (messages[i] != null) {
                    writer.write("    {\n");
                    writer.write("      \"messageID\": \"" + ids[i] + "\",\n");
                    writer.write("      \"messageHash\": \"" + hashes[i] + "\",\n");
                    writer.write("      \"recipient\": \"" + recipients[i] + "\",\n");
                    writer.write("      \"message\": \"" + messages[i] + "\",\n");
                    writer.write("      \"status\": \"" + status[i] + "\"\n");
                    if (i < count - 1) {
                        writer.write("    },\n");
                    } else {
                        writer.write("    }\n");
                    }
                }
            }
            
            writer.write("  ]\n");
            writer.write("}\n");
            writer.close();
            System.out.println("Messages saved to messages.json");
        } catch (Exception e) {
            System.out.println("Error saving to JSON: " + e.getMessage());
        }
    }
}