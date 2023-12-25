/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Empirical Shuffle Check
*/

import java.util.Random;

public class Shuffle {

   // seed the random numbers 
   private static final Random RNG = new Random (Long.getLong ("seed", System.nanoTime())); 

   public static void main (final String [] args) {
      final int n = Integer.parseInt(args[0]);
      final int m = Integer.parseInt(args[1]);
      final int[] a = new int[m];
      final int[][] b = new int[m][m];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            a[j] = j;
         }

         /* give every integer in the row to have the 
         same probability on each permutation*/
         for (int j = 0; j < m; j++) {
            final int r = j + RNG.nextInt(a.length-j);
            // Exchange a[i] and a[r]
            final int temp = a[j];
            a[j] = a[r];
            a[r] = temp;
         }

         /* increment correspinding element of array b */
         for (int j = 0; j < m; j++) { 
            b[a[j]][j]++;
         }
      }

      for (int i = 0; i < m; i++) {
         for (int j = 0; j < m; j++) {
            System.out.print(b[i][j] + " ");
         }
         System.out.println();
      }
   }
}
