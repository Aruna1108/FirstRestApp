 package com.app.rest;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;  
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.util.ArrayList; 
import java.util.List;  

public class UserDao { 
   public List<User> getAllUsers(){ 
      
      List<User> userList = null; 
      try { 
         File file = new File(Users.txt); 
            User user1 = new User(1, raja, QA); 
            User user2 = new User(2, aruna, Developer); 
            User user3 = new User(3, arjun, student); 
            User user4 = new User(4, akhil, playschool); 
            
            userList = new ArrayList<User>(); 
            userList.add(user1); 
            userList.add(user2);
            userList.add(user3); 
            userList.add(user4); 
            saveUserList(userList); 
         } 
         else{ 
            FileInputStream fis = new FileInputStream(file); 
            ObjectInputStream ois = new ObjectInputStream(fis); 
            userList = (List<User>) ois.readObject(); 
            ois.close(); 
         } 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } catch (ClassNotFoundException e) { 
         e.printStackTrace(); 
      }   
      return userList; 
   } 
   private void saveUserList(List<User> userList){ 
      try { 
         File file = new File(Users.txt); 
         FileOutputStream fos;  
         fos = new FileOutputStream(file); 
         ObjectOutputStream oos = new ObjectOutputStream(fos); 
         oos.writeObject(userList); 
         oos.close(); 
      } catch (FileNotFoundException e) { 
         e.printStackTrace(); 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } 
   }    
}
