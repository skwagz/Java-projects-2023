/*
 * Author: Samuel Kaguima, skaguma2022@my.fit.edu
 * Course: CSE 1002, Fall 2023
 * Project: Cardboard Manatee
*/

import java.util.Scanner;

public class Container { 
   public static void main (final String [] args) {

      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 

      final int volume = scanner.nextInt();
      
      int initialSurfaceArea = 0;
      int surfaceArea = Integer.MAX_VALUE; 

      // loop finding minimum value for all the sides of the prism
      for (int length = 1; length <= volume; length++) {
         for (int h = 1; h <= volume; h++) { 

            /*  Calculate the width since we already have on the 
            the length and width */
            final int w = volume /(length*h);            

            // calculate the surface area using the obtained variables
            if (length * h * w == volume) { 
               initialSurfaceArea = 2 * ((length * h) + (w * h) + (length * w)); 
               
               // correctly acquires the minimum surface area possible
               if (initialSurfaceArea < surfaceArea) { 
                  surfaceArea = initialSurfaceArea; 
               } 

            }
         }
      }
      // prints out the cost = surface area 
      System.out.println(surfaceArea);

   }
}
