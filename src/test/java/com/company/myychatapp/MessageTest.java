/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.company.myychatapp;


import com.mycompany.myychatapp.Message;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MessageTest {
    
    private Message message;
    
    @BeforeEach
    public void setUp() {
        
        message = new Message("+27783930646", "Let us go out for dinner.");
        
    }
    
    // MESSAGE ID TEST
    
    @Test
    public void testCheckMessageID_Success() {
        
        assertTrue(message.checkMessageID());
        
    }
    
     // RECIPIENT NUMBER TEST
    
    @Test
    public void testCheckRecipientCell_Success() {
        
        String expected =
                "Cell phone number captured successfully.";
        
        assertEquals(expected, message.checkRecipientCell());
        
    }
    
      // MESSAGE LENGTH TEST 
    
    @Test 
    public void testMessageLength_Success() {
        Message msg = 
                new Message("+27783930646", "Where are you?");
        
        String expected = "Ready to go!";
        
        assertEquals(expected, msg.checkMessageLength());
        
    }
    
    @Test 
    public void testMessageLength_Failure(){
        String longText = "Y".repeat(300);
        
        Message msg = new Message ("+27783930646", longText);
        
        String expected = "Message exceeds limit by 50.Please shorten the message.";
        
        assertEquals(expected, msg.checkMessageLength());
        
    }
    
      // MESSAGE HASH TEST 
    
    @Test
    public void testCreatMessageHash_Send() {
        
        String hash = message.createMessageHash();
        
        assertNotNull(hash) ;
        
    }
    
      // SENT MESSAGE TEST
    
    @Test
    public void testSentMessage_Send()  {
        String result = message.sentMessage(1);
        
        assertEquals("Message sent.",result);
     
    }
    @Test 
    public void testSentMessage_Discard() {
        String result = message.sentMessage(2);
        
        assertEquals("Select 0 to delete message", result);
        
    }
    @Test
    public void testSentMesssage_Store() {
        String result = message.sentMessage(3) ;
        
        assertEquals("Message stored successfully.", result);
        
    }
    
         
         //TOTAL MESSAGE TEST
    
    @Test
    public void testPrintMessage()  {
        
        String printed = message.printMessages();
        
        assertNotNull(printed);
        
    }
    @Test 
    public void testReturnTotalMessage() {
        
        assertTrue(Message.returnTotalMessages() >=2);
        
    }
    
    
}
