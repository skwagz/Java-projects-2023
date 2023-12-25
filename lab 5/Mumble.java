/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Mumble Rumble
*/

import java.util.Scanner;


public class Mumble { 
   public static void main (final String [] args) { 

 
      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 

      // declaring variables 
      int max = 0; 
      int x = 0;
      boolean z = false; 

      // loop runs everyline and puts it into the string line 
      while (scanner.hasNext()) {     
         final String line = scanner.nextLine();

         /* scans through every character in the string line
         to keep the all the digits in a row  */
         for (int i = 0; i < line.length(); i++) { 

            /* determines if it is a integer or character 
            then adds it to the max and stops if the next 
            digit is not an integer */
            if (Character.isDigit(line.charAt(i))) { 
               x = x * 10 + (line.charAt(i) - '0'); 
               z = true; 

            } else if (z) {
               max = Math.max(max, x);
               x = 0;
               z = false; 
            }

            if (z) { 
               max = Math.max(max, x);
            }

         } 
      } 

      System.out.println(max);
      max = 0;
   
   } 
} 
