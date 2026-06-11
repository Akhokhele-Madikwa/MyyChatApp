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

    // Test valid message length
    @Test
    public void testMessageLengthSuccess() {

        Message message = new Message(
                1,
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?"
        );

        String expected = "Message ready to send.";

        assertEquals(expected, message.checkMessageLength());
    }

    // Test invalid message length
    @Test
    public void testMessageLengthFailure() {

        String longMessage = "A".repeat(260);

        Message message = new Message(
                1,
                "+27718693002",
                longMessage
        );

        String expected =
                "Message exceeds 250 characters by 10; please reduce the size.";

        assertEquals(expected, message.checkMessageLength());
    }

    // Test valid recipient number
    @Test
    public void testRecipientNumberSuccess() {

        Message message = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        String expected =
                "Cell phone number successfully captured.";

        assertEquals(expected, message.checkRecipientCell());
    }

    // Test invalid recipient number
    @Test
    public void testRecipientNumberFailure() {

        Message message = new Message(
                1,
                "0812345678",
                "Hello"
        );

        String expected =
                "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";

        assertEquals(expected, message.checkRecipientCell());
    }

    // Test message hash creation
    @Test
    public void testCreateMessageHash() {

        Message message = new Message(
                0,
                "+27718693002",
                "Hi Mike can you join us tonight"
        );

        String hash = message.createMessageHash();

        assertTrue(hash.contains(":0:HITONIGHT"));
    }

    // Test message ID generation
    @Test
    public void testMessageIDCreated() {

        Message message = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        assertNotNull(message.getMessagesIDs());

        assertEquals(10, message.getMessagesIDs().length());
    }

    // Test send message option
    @Test
    public void testSendMessageOption() {

        Message message = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        String expected = "Message successfully sent.";

        assertEquals(expected, message.sentMessage(1));
    }

    // Test disregard message option
    @Test
    public void testDisregardMessageOption() {

        Message message = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        String expected = "Press 0 to delete the message.";

        assertEquals(expected, message.sentMessage(2));
    }

    // Test store message option
    @Test
    public void testStoreMessageOption() {

        Message message = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        String expected = "Message successfully stored.";

        assertEquals(expected, message.sentMessage(3));
    }
    
    //MY PART 3 TEST
    
@Test
public void testSentMessagesArrayPopulated() {

    Message.getSentMessages().clear();

    Message message1 =
            new Message(1,
                    "+27834557896",
                    "Did you get the cake?");

    Message message4 =
            new Message(4,
                    "0838884567",
                    "It is dinner time!");

    message1.createMessageHash();
    message4.createMessageHash();

    message1.sentMessage(1);
    message4.sentMessage(1);

    assertEquals(
            "Did you get the cake?",
            Message.getSentMessages().get(0));

    assertEquals(
            "It is dinner time!",
            Message.getSentMessages().get(1));
}

@Test
public void testDisplayLongestMessage() {

    Message.getStoredMessages().clear();

    Message.getStoredMessages().add(
            "Did you get the cake?");

    Message.getStoredMessages().add(
            "Where are you? You are late! I have asked you to be on time.");

    Message.getStoredMessages().add(
            "Yohoooo, I am at your gate.");

    assertEquals(
            "Where are you? You are late! I have asked you to be on time.",
            Message.displayLongestMessages());
}

@Test
public void testSearchByRecipient() {

    Message.getSentMessages().clear();

    Message message2 =
            new Message(2,
                    "+27838884567",
                    "Where are you? You are late! I have asked you to be on time.");

    Message message5 =
            new Message(5,
                    "+27838884567",
                    "Ok, I am leaving without you.");

    message2.createMessageHash();
    message5.createMessageHash();

    message2.sentMessage(1);
    message5.sentMessage(1);

    String result =
            Message.searchByRecipient("+27838884567");

    assertTrue(result.contains(
            "Where are you? You are late! I have asked you to be on time."));

    assertTrue(result.contains(
            "Ok, I am leaving without you."));
}

@Test
public void testDeleteMessageByHash() {

    Message.getSentMessages().clear();
    Message.getMessageHashes().clear();

    Message message2 =
            new Message(2,
                    "+27838884567",
                    "Where are you? You are late! I have asked you to be on time.");

    String hash = message2.createMessageHash();

    message2.sentMessage(1);
    System.out.println("Hash created: " + hash);
    System.out.println("Hashes array: " + Message.getMessageHashes());
    String result =
            Message.deleteByHash(hash);
    
    assertEquals(
            "Message: Where are you? You are late! I have asked you to be on time. successfully deleted.",
            result);
}

@Test
public void testDisplayReport() {

    Message.getSentMessages().clear();

    Message message1 =
            new Message(1,
                    "+27834557896",
                    "Did you get the cake?");

    message1.createMessageHash();
    message1.sentMessage(1);

    String report =
            Message.displayFullReport();
    System.out.println(report);
    assertTrue(report.contains("Did you get the cake?"));
    assertTrue(report.contains("+27834557896"));
}

}