package com.mycompany.poepart1 ;

import org.junit.jupiter.api.Test ;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest{
    
    Message msg = new Message ();
    
    // test 1: Message length is OK (250 chars or less)
    @Test
    public void testMessageLengthSuccess() {
        String shortMessage = "Hi Mike, can you join us for dinner tonight?";
        String result = msg.checkMessageLength(shortMessage);
        assertEquals("Message ready to send.", result);
    }
    
    // TEST 2: CAN SEND THE MESSAGE UP TO 250 LETTERS 
    @Test
    public void testMessageLengthFailure() {
        String longMessage = "This is a very long message that is going to be more than two hundred and fifty characters long. I am typing a lot of words to make sure that the message exceeds the limit. This is for testing purposes only. I need to keep typing until I reach over 250 characters. This should be enough now I think.";
        String result = msg.checkMessageLength(longMessage);
        assertTrue(result.contains("exceeds 250 characters"));
    }
    
    // TEST 3: Valid recipient number (starts with +27 and 12 digits)
    @Test
    public void testValidRecipient() {
        String result = msg.checkRecipientCell("+27718693002");
        assertEquals("Cell phone number successfully captured.", result);
    }
    
    // TEST 4: Invalid recipient number (no +27 code)
    @Test
    public void testInvalidRecipient() {
        String result = msg.checkRecipientCell("08575975889");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", result);
    }
    
    // TEST 5: Invalid recipient number (wrong length)
    @Test
    public void testInvalidRecipientWrongLength() {
        String result = msg.checkRecipientCell("+277994956260");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", result);
    }
    
    // TEST 6: Message ID is 10 digits or less
    @Test
    public void testMessageIDLength() {
        String messageID = msg.createMessageID();
        assertTrue(messageID.length() <= 10);
    }
    
    // TEST 7: Message hash format correct
    @Test
    public void testMessageHashFormat() {
        String messageID = "1234567890";
        String messageText = "Hi Mike can you join us for dinner tonight";
        String hash = msg.createMsgHash(messageID, messageText, 1);
        
        // Hash should contain colons
        assertTrue(hash.contains(":"));
        // Hash should not be empty
        assertTrue(hash.length() > 5);
    }
    
    // TEST 8: MESSAGE HAS HAS UPPERCASE LETTERS 
    @Test
    public void testMessageHashUppercase() {
        String messageID = "1234567890";
        String messageText = "hello world";
        String hash = msg.createMsgHash(messageID, messageText, 1);
        
        // Check if hash contains uppercase letters
        boolean hasUppercase = false;
        for (int i = 0; i < hash.length(); i++) {
            char c = hash.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                hasUppercase = true;
                break;
            }
        }
        assertTrue(hasUppercase);
    }
}
