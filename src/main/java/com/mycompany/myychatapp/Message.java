/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myychatapp;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author madik
 */
public class Message {
    
    private static int messageCount =0;
    
    
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;
    
    private static List<String> sentMessages = new ArrayList<>();
    private static List<String> disregardedMessages = new ArrayList<>(); 
    private static List<String> storedMessages = new ArrayList<>();
    private static List<String> messageHashes = new ArrayList<>();
    private static List<String>  messageIDs  = new ArrayList<>();  
    private static List<String> recipients = new ArrayList<>();
    //CONSTRUCTOR
    public Message (String recipient, String message) {
        
        this.messageID = generateMessageID();
        messageCount++;
        this.messageNumber = messageCount -1;
        this.recipient = recipient;
        this.message = message;
        this.messageHash = createMessageHash();
    public static String displayLongestMessages () {
        String Longest = "";
        for (String message : storedMessages) {
            if (message != null && message.length() > Longest.length()) {
             Longest = message;
        }
        }
        
        if (Longest.isEmpty()){
            System.out.println("No stored messages found");
            
        }else {
                System.out.println("Longest Message:" +Longest);
        }
     return Longest;   
    }
    public static void searchByMessageID(String id) {
        
        for (int i = 0; i < messageIDs.size(); i++ )  {
            if (messageIDs.get(i).equals(id));     {
            System.out.println("Message Found: ");
            System.out.println( storedMessages.get(i)) ;
            return ;
        }
    }
         System.out.println("Message not found");
         
    }
        //CREATE 10 DIGIT MESSAGE ID
        private String generateMessageID(){
        
        Random random = new Random (); 
        
        long number = 1000000000L +
                (long) (random.nextDouble() * 9000000000L);
        
        return String.valueOf(number);
        }
        
        // MESSAGE ID
        public boolean checkMessageID() {
            return messageID.length() <=10;
            
        }
        
        //RECIPIENT NUMBER 
        public String checkRecipientCell() {
            if (recipient.startsWith("+") && recipient.length() <=13){
                return "Cell phone number captured successfully.";
                
            } else {
                return "Cell phone number is incorrect or does not contain a internatinal code.Please try again.";
            }
        }
        
         // MESSAGE LENGTH 
        public String checkMessageLength() {
            if (message.length() <=250) {
                return ("Ready to go!");
            }else {
                int exceedsLimit = message.length() - 250 ;
                return "Messege exceeds limit of 250 characters by" + exceedsLimit +"Please shorten the message.";
            }
        }
        
          //MESSAGE HASH
        public String createMessageHash() {
            String[] words = message.split(" ");
            
            String firstWord = words[0];
            String lastWord = words[words.length -1 ];
            
            return messageID.substring(0 , 2) + ":" + messageNumber + ":" + firstWord.toUpperCase()+lastWord.toUpperCase();
        }
        
        
          // SEND MESSGAE , DISCARD MESSAGE OR STORE MESSAGE 
        public String sentMessage(int choice) {
            
            switch (choice)  {
                
                case 1:
                    return "Message sent." ;
                case 2 :
                 
                    return " Select 0 to delete message." ;
                case 3:
                       storeMessage();
                    return"Message stored successfully." ;
                default :
                    return "Invalid option." ;
            }       
                    }  
        public void storeMessage(){
            JSONObject messageObject = new JSONObject ();
            
            messageObject.put("MessageID", messageID);
            messageObject.put("MessageHash",messageHash );
            messageObject.put("Recipient", recipient);
            messageObject.put("Message", message);
            
            try (FileWriter file = new FileWriter("message.json", true)){
                
                file.write(messageObject.toString(4));
                file.write(System.lineSeparator());
            }catch (IOException e){
                System.out.println("Error writting to JSON file.");
            }
        }
        
            // PRINT MESSAGES 
        public String printMessages() {
             
            return "Message ID:" + messageID + "\nMessage Hash:" + messageHash + "\nRecipient:"+ recipient + "\nMessage:"+ message;
        }
        
             //TOTAL MESSAGES 
        public static int returnTotalMessages() {
             return messageCount;
             
        }
        
             
}
        
