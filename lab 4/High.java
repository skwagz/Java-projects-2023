/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Hello World!
*/
import java.util.Scanner;

public class High { 
   public static void main (final String[] args) { 




      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 

      int high = 0; 
      String highName = ""; 
      String highLastName = ""; 


      while (scanner.hasNext()) { 
         final  String  firstName = scanner.next(); 
         final String lastName = scanner.next();  
         final int score = scanner.nextInt();          
        
         if (score > high) { 
            high = score; 
            highName = firstName;
            highLastName = lastName;   
         }


      }

      System.out.println();
      System.out.println(highName + " " + highLastName + " " + high);

   }
    
}
