/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: page rank
*/


import java.util.Scanner;
import java.util.Random;

public class RandomSurfer {

   private static final Random RNG = new Random (Long.getLong ("seed", System.nanoTime ())); 

   public static void main (final String[] args) {

      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 
      final int trials;   // number of moves
      final int defTrials = 1000;

      if (System.getProperty("trials") != null) {
         trials = Integer.parseInt(System.getProperty("trials"));
      } else {
         trials = defTrials;
      }

      final int m = scanner.nextInt();          // number of pages  - ignore since m = n
      final int n = scanner.nextInt();         // number of page
      if (m != n) {
         System.out.println("m does not equal n");
         return;
      }


      // Read transition matrix.
      final double[][] p = new double[n][n]; 
      // p[i][j] = prob. that surfer moves from page i to page j
      for (int i = 0; i < n; i++) { 
         for (int j = 0; j < n; j++) { 
            p[i][j] = scanner.nextDouble();
         }
      } 

      final int[] freq = new int[n];                  // freq[i] = # times surfer hits page i

      // Start at page 0.
      int page = 0;

      for (int t = 0; t < trials; t++) {

         // Make one random move.
         final double  r = RNG.nextDouble();
         double sum = 0.0;
         for (int j = 0; j < n; j++) {
            // Find interval containing r.
            sum += p[page][j];
            if (r < sum) {
               page = j;
               break;
            }
         }
         freq[page]++;
      }


      // Print page ranks.
      for (int i = 0; i < n; i++) {
         final int j = freq[i];
         final double k = j;
         final double answer = k/trials;
         System.out.printf("%2d: %6.3f%n", i, answer);

      }
      System.out.println();
      
   }
}
