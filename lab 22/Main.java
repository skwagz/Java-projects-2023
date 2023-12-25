/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Lost at Sea 
*/

import java.util.Scanner;

public class Main {
   public record Danger(int x, int y) {
   }


   static final Manatee MANATEE = new Manatee();
   static Danger [] dangers;

   public static void main (final String[] args) {
      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 


      // initialize dangers to the length d (the amount of dangers)
      final int d = scanner.nextInt();
      dangers = new Danger[d]; 

      // records the coorginates of the dangers into the record using array danger 
      for (int i = 0; i < d; i++) {
         final int m = scanner.nextInt();
         final int n = scanner.nextInt();
         final Danger danger = new Danger (m, n);
         dangers[i] = danger;
      }

      scanner.nextLine();
      final String moves = scanner.nextLine();
   
      System.out.println(simulate(moves));
   }

   /* checks the manatee's position and returns where the manetee
   is based on the its path*/
   public static String simulate (final String moves) {
      final int maxY = 10000; // maximum y coordinate
      final int minY = -10000; // minimum y coordinate 
      final int maxX = 10000; // maximum x coordinate 
      // to be able to monitor the manatees move from the path input
      for (final char move : moves.toCharArray()) {
         MANATEE.move(move);
         if (MANATEE.getX() < 0) {
            return "Beached";
         }
         if (MANATEE.getX() > maxX || MANATEE.getY() < minY || MANATEE.getY() > maxY) {
            return "Terra incognita";
         }
         for (final Danger danger : dangers) {
            if (danger.x() == MANATEE.getX() && danger.y() == MANATEE.getY()) {
               return "The end";
            }
         }
      }
      if (MANATEE.getX() == 0 && MANATEE.getY() == 0) {
         return "Home at last";
      }

      return "Lost at sea";
   }
}
