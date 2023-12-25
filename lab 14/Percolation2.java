/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Percolation
*/

import java.util.Scanner;
import java.util.Random;

public class Percolation2 {

   private static final Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));
   // given an n-by-n matrix of open sites, return an n-by-n matrix
   // of sites reachable from the top
   public static boolean[][] flow (final boolean[][] isOpen) {
      final int n = isOpen.length;
      final boolean[][] isFull = new boolean[n][n];
      for (int j = 0; j < n; j++) {
         flow(isOpen, isFull, 0, j);
      }
      return isFull;
   }

   // determine set of full sites using depth first search
   public static void flow (final boolean[][] isOpen, final boolean[][] isFull,
                           final int i, final int j) {
      final int n = isOpen.length;

      // base cases
      if (i < 0 || i >= n) return;    // invalid row
      if (j < 0 || j >= n) return;    // invalid column
      if (!isOpen[i][j]) return;      // not an open site
      if (isFull[i][j]) return;       // already marked as full

      // mark i-j as full
      isFull[i][j] = true;

      flow(isOpen, isFull, i+1, j);   // down
      flow(isOpen, isFull, i, j+1);   // right
      flow(isOpen, isFull, i, j-1);   // left
   }


   // does the system percolate?
   public static boolean percolates (final boolean[][] isOpen) {
      final int n = isOpen.length;
      final boolean[][] isFull = flow(isOpen);
      for (int j = 0; j < n; j++) {
         if (isFull[n-1][j]) return true;
      }
      return false;
   }

   
   // return a random n-by-n boolean matrix, where each entry is
   // true with probability p
   public static boolean[][] random (final int n, final double p) {
      final boolean[][] a = new boolean[n][n];
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            a[i][j] = RNG.nextBoolean();
               
         }
      }
      return a;
   }

   // test client
   public static void main (final String[] args) {

      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 

      final int N = scanner.nextInt();
      final boolean[][] isOpen = new boolean[N][N];

      
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
            isOpen[i][j] = RNG.nextBoolean();
         }
      }

      final boolean [][] array = flow(isOpen);
      





      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array[i].length; j++) {
            final int [][] intarray =  new int[N][N];
            if (array[i][j]) { 
               intarray[i][j] = 1;
            } else {
               intarray[i][j] = 0;
            }
            System.out.print(intarray[i][j] + " ");
         }
         System.out.println();
      }
      
        
      System.out.println(percolates(isOpen));
   }
}
