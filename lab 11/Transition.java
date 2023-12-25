/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Page rank
*/

import java.util.Scanner;

public class Transition {


   public static void main (final String[] args) {

      
      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 


      final int n = scanner.nextInt();         // number of pages
      final int[][] counts = new int[n][n];   // counts[i][j] = # links from page i to page j
      final int[] outDegree = new int[n];    // outDegree[i] = # links from page i to anywhere\
      final double leap = Double.parseDouble(System.getProperty("leap", "0.1"));
      


      // Accumulate link counts.
      while (scanner.hasNext())  {
         final int i = scanner.nextInt();
         final int j = scanner.nextInt();
         outDegree[i]++;
         counts[i][j]++;
      }
      System.out.println(n + " " + n);



      final String formatter = System.getProperty("format", " %.2f");


      // Print probability distribution for row i.
      for (int i = 0; i < n; i++)  {

         // Print probability for column j.
         for (int j = 0; j < n; j++) {

            if (outDegree[i] == 0) {
               System.out.printf(formatter, 1.0/n);
            } else {
               final double p = (1.0 - leap)*counts[i][j]/outDegree[i] + leap/n;
               System.out.printf(formatter, p);
            }
         }
         System.out.println();
      }
   }
}

