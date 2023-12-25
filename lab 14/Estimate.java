/* 
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Percolation
*/


public class Estimate {
   // do specified number of trials and return fraction that percolate
   public static double evaluate (final int n, final double p, final int trials) {
      final int count = 0;
      for (int t = 0; t < trials; t++) {
         final boolean[][] isOpen = Percolation2.random(n, p);
         if (Percolation2.percolates(isOpen)) {
            count++;
         }
      }
      final double a = count;
      return a / trials;
   }

   
   public static void main (final String[] args) {
      final int n = Integer.parseInt(args[0]);
      final double p = Double.parseDouble(args[1]);
      final int trials = Integer.parseInt(args[2]);
      final double q = evaluate(n, p, trials);
      System.out.println(q);
   }
}