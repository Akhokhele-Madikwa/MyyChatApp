/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myychatapp;


import java.util.Scanner;

/**
 *
 * @author madik
 */
public class MainApp {
     public static void main (String[] args){
        
        // Scanner allows the user to enter information
        Scanner input = new Scanner(System.in);
        
        // Create an object of the Login class so we can call its methods
        Login login = new Login();
        
        // ---REGISTRATION SECTION ---
        System.out.println("---USER REGISTRATION");
        while(true){
        System.out.print("Enter a username:");
        String username = input.nextLine();
        
        System.out.print("Enter a password:");
        String password = input.nextLine();
        
        System.out.print("Enter your South African phone number (+27...):");
        String phone = input.nextLine();
        
        // Call the registerUser method and store the messageit returns 
        String response = login.registerUser(username,password,phone);
        
        // Show the registration message
        System.out.println(response);
        if(response.equals("User registered successfully.")){
            break;
        }
            System.out.println("Please try again");
        }
        //---LOGIN SECTION---
        System.out.println("\n=== USER LOGIN ===");
        
        System.out.print("Enter your username:");
        String loginUsername = input.nextLine();
        
        System.out.print("Enter your password:");
        String loginPassword = input.nextLine();
        
        // Call loginUser to check if the details match the stored ones
        boolean loggedIn = login.loginUser(loginUsername, loginPassword);
        
        // Print out the correct login message
        String loginMessage =login.returnLoginStatus(loggedIn);
        System.out.println(loginMessage);
        
        //PART 2
        
    System.out.println("/nWELCOME TO QUICKCHAT");
        boolean successPart2 = true ;

                     
                     while (successPart2){
                         System.out.println("\n =====MENU=====");
                         System.out.println("1 Send Message");
                         System.out.println("2 Show recently sent messages");
                         System.out.println("3 Quit");
                         
                         System.out.print("Choose option:");
                         int choice = input.nextInt();
                         input.nextLine();
                         
                         
                         switch (choice) {
                             
                             case 1 :
                                 System.out.print("How many messages do you want to send?");
                                 int totalMessages= input.nextInt();
                                 input.nextLine();
                                 
                                 for (int i =0; i < totalMessages; i++) {
                                     System.out.println("\n==== NEW MESSAGE ====");
                                     
                                     System.out.print("Enter recipient number");
                                     String recipient = input.nextLine();
                                     
                                     System.out.print("Enter message");
                                     String text = input.nextLine();
                                     
                                     Message msg = new Message(recipient, text);
                                     
                                     // RECIPIENT VALIDATION
                                     System.out.println(msg.checkRecipientCell());
                                     
                                     System.out.println(msg.checkMessageLength());
                                     
                                     System.out.println("Message Hash: "+ msg.createMessageHash());
                                    
                                        
                                        System.out.println("\nChoose option");
                                        System.out.println("1 Send Message");
                                        System.out.println("2 Disregard Message");
                                        System.out.println("3 Store Message");
                                        
                                        int option = input.nextInt();
                                        input.nextLine();
                                        
                                        System.out.println(msg.sentMessage(option));
                                           
                                        System.out.println("\n"+msg.printMessages());
                                                 
                                            
                                    }  
                                    
                                        System.out.println("\nTotal Message sent: "+ Message.returnTotalMessages());
                                        break;
                                        case 2:
                                            System.out.println("Comming Soon.");
                                        break;
                                                
                                        case 3 : 
                                            System.out.println("Goodbye!.");
                                        successPart2 = false;
                                        break;
                                        
                                        default : 
                                            System.out.println("Invalid option. Please try again.");
                                        }
                     
                                        
                                    } 
                     input.close();
                     }
     }
