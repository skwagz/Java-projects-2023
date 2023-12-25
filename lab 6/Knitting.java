/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Knitting a la Mode
*/

import java.util.Scanner;

public class Knitting {
   public static void main (final String [] args) { 

      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 

      // takes in n,m,k from line
      final int n = scanner.nextInt(); 
      final int m = scanner.nextInt(); 
      final int k = scanner.nextInt();

      final int [] pattern = new int [k];

      /* takes in the next int that gets added 
      to the next row of stitches and stores it in an array */
      for (int i = 0; i < k; i++) { 
         pattern[i] = scanner.nextInt();
      } 
      
      /* adds the increment of stiches per 
      row to n then totals them together in total */
      int total = 0; 
      int row = n;
      for (int i = 0; i < m; i++) { 
         total += row;
         row += pattern[i % k];
      }

      System.out.println(total); 


   }
}
