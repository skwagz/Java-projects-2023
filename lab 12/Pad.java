/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Pad the seconds 
*/

import java.util.Scanner;

public class Pad {

   public static void main (final String[] args) {

      // Create a scanner to read input from standard input
      final Scanner scanner = new Scanner(System.in, "US-ASCII");

      while (scanner.hasNext()) {
         // Read an integer from the scanner
         final int k = scanner.nextInt();
         int count = 1;
         final int result = k; // 'result' variable is marked final

         if (isValidMicrowaveNumber(k)) {
            // If 'k' is valid, print 'result'
            System.out.println(result);
         } else {
            while (!isValidMicrowaveNumber(k)) {
               // If 'k' is not valid, search for valid numbers in both directions
               if (isValidMicrowaveNumber(k + count)) {
                  System.out.println (k + count);
                  break;
               } else if (isValidMicrowaveNumber(k - count)) {
                  System.out.println(k - count);
                  break;
               }
               count++;
            }
         }
      }
   }

   public static boolean isValidMicrowaveNumber (final int num) {
      int finalCol = 3; 
      int finalRow = 4; 

      int sol = num;
      

      // Loop through each digit of 'num'
      while (sol != 0) {
         final int rem = sol % 10; 
         sol /= 10;

         final int row, col;

         if (rem == 0) {
            row = 4;
            col = 2;
         } else {
            row = ((rem - 1) / 3) + 1;
            col = ((rem - 1) % 3) + 1;
         }

         if (row > finalRow || col > finalCol) {
            return false; // Return false if row or col exceeds limits
         }

         finalRow = row;
         finalCol = col;
      }
      return true; // All digits are valid, return true
   }
}
