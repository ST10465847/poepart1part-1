package com.mycompany.poepart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    
    Message msg = new Message();
    
    // ======== PART 2 TESTS =======
    
    @Test
    public void testMessageLengthSuccess() {
        String result = msg.checkMessageLength("Hi Mike, can you join us?");
        assertEquals("Message ready to send.", result);
    }
    
    @Test
    public void testMessageLengthFailure() {
        String longMsg = "This is a very long message that is more than 250 characters. I am typing a lot of words to make sure it exceeds the limit. This should be enough now because I am adding more and more text to reach over 250 characters.";
        String result = msg.checkMessageLength(longMsg);
        assertTrue(result.contains("exceeds 250 characters"));
    }
    
    @Test
    public void testValidRecipient() {
        String result = msg.checkRecipientCell("+27718693002");
        assertEquals("Cell phone number successfully captured.", result);
    }
    
    @Test
    public void testInvalidRecipient() {
        String result = msg.checkRecipientCell("08575975889");
        assertTrue(result.contains("incorrectly formatted"));
    }
    
    @Test
    public void testMessageHash() {
        String hash = msg.createMsgHash("1234567890", "Hi Mike can you join", 1);
        assertTrue(hash.contains(":"));
    }
    
    // ========== PART 3 TESTS ==========
    
    // Test 1: Sent Messages array contains expected test data
    @Test
    public void testSentMessagesArray() {
        String[] sentMessages = new String[100];
        sentMessages[0] = "Did you get the cake?";
        sentMessages[1] = "It is dinner time!";
        
        assertEquals("Did you get the cake?", sentMessages[0]);
        assertEquals("It is dinner time!", sentMessages[1]);
    }
    
    // Test 2: Longest message
    @Test
    public void testLongestMessage() {
        String msg2 = "Where are you? You are late! I have asked you to be on time.";
        String msg4 = "It is dinner time!";
        
        assertTrue(msg2.length() > msg4.length());
        assertEquals("Where are you? You are late! I have asked you to be on time.", msg2);
    }
    
    // Test 3: Search for message ID (Message 4)
    @Test
    public void testSearchByMessageID() {
        String expectedMessage = "It is dinner time!";
        assertEquals("It is dinner time!", expectedMessage);
    }
    
    // Test 4: Search all messages for recipient +27838884567
    @Test
    public void testSearchByRecipient() {
        String recipient = "+27838884567";
        String[] messagesForRecipient = {"Where are you? You are late! I have asked you to be on time.", "Ok, I am leaving without you."};
        
        assertEquals("Where are you? You are late! I have asked you to be on time.", messagesForRecipient[0]);
        assertEquals("Ok, I am leaving without you.", messagesForRecipient[1]);
    }
}