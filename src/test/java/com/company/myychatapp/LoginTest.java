/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.company.myychatapp;

import com.mycompany.myychatapp.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;





/**
 *
 * @author madik
 */
public class LoginTest {
    
    Login login = new Login ();
    
    // USERNAME TEST 
     
    @Test
    public void testValidUsername (){
        
       // Check if the username validation is TRUE/FALSE 
       // TRUE because username (kyl_1)contains underscore and is not longer than 5 characters
      
       assertTrue(login.checkUsername("kyl_1"));
       
    }
    
    @Test 
    public void testInvalidUsername (){
        // Check that the code rejects the invalid username
        assertFalse(login.checkUsername("kyle!!!!!!!"));
        
    }
    
    // PASSWORD TEST 
    
    @Test 
    public void testValidPasswordComlexity (){
        /* Check if password meets the password complexity rule
           *Eight characters , capital letter ,a number and a special 
         character 
           *TRUE password meets complexity requirements 
        */
        
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
    
    @Test 
    public void testInvalidPasswordComplexity (){
        //Password does not meet complexity requirements 
        
        assertFalse(login.checkPasswordComplexity("password"));
    }
     
    
    // CELLPHONE NUMBER TEST 
    
    @Test
    public void testValidCellPhoneNumber (){
        // Check CellphoneNumber contains international code and is the correct length
        // TRUE 
        
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
        
    }
    
    @Test 
    public void testInvalidCellPhoneNumber (){
        // Cellphone number incorrectly formatted 
        
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
    
    
    
    
    
    //LOGIN SUCCESSFUL TEST 
    
    @Test
    public void testLoginSuccessful (){
        
      login.registerUser("kyl_1", "Ch&&sec@ke99", "+27838968976");
      
      boolean result = login.loginUser("kyl_1","Ch&&sec@ke99");
       assertTrue(result);
    }
      @Test
      public void testLoginFailed (){
          
          login.registerUser("kyl_1","Ch&&sec@ke99","+27838968976");
          boolean result = login.loginUser("kyl_1","08966553");
          assertFalse(result);
    }
      
      // USERNAME 
      
      @Test
      public void testUsernameFormatted (){
      
      
      
      boolean result= login.checkUsername("kyl_1");
      assertTrue(result) ;
      
      }
      
      @Test
      public void testUsernameIncorrectlyFormatted (){
          
        
          
          boolean result = login.checkUsername("kyle!!!!!!!");
          assertFalse(result);
          
      } 
          
          
          //PASSWORD 
          
          @Test
          public void testPasswordComplexity (){
              
             
              
              boolean result = login.checkPasswordComplexity("Ch&&sec@ke99");
              assertTrue(result);
              
          }
          
          @Test
          public void testPasswordComplexityFailed (){

              boolean result = login.checkPasswordComplexity("password");
              assertFalse(result);
              
          }
          
          // CELLPHONE NUMBER
          
          @Test
          public void testCellPhoneNumberFormatted (){
              
             
              boolean result = login.checkCellPhoneNumber("+27838968976");
              assertTrue (result);
              
          }
          
          @Test
          public void testCellPhoneNumberIncorrectFormat (){
              
              
              
              boolean result = login.checkCellPhoneNumber("08966553");
              assertFalse(result);
          }
              
                  
          
             
              
              
          
      }
          
      

      
             
      
                  
                  
      
        
       
       
       
    
    

       
             
      
                  
                  
      
        
       
       
       
    
    

       