/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Tetris Sequence 
*/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Tetris {

   public static void main (final String[] args) {

      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 

      while (scanner.hasNextLine()) {
         final String sequence = scanner.nextLine();
         final Set<Character> uniqueShapes = new HashSet<>();
         final char lastShape = 0;

         // boolean for validating the sequence
         boolean isValid = true;
         boolean sequenceReset = false;
         for (final char shape : sequence.toCharArray()) {
                
            // Go through sequence validating based on repeats
            if (!uniqueShapes.add(shape)) {
               // clear sequence if there is a duplicate in input
               if (!sequenceReset) {
                  sequenceReset = true;
                  uniqueShapes.clear();
                        
               } else {
                  isValid = false;
                  break;
               }
            }

            // clear sequence if there is already 7 shapes in sequence
            final int sequenceMax = 7;
            if (uniqueShapes.size() == sequenceMax) {
               uniqueShapes.clear();
               sequenceReset = true;
            }       
         }
            
         if (isValid) {
            System.out.println("1");

         } else {
            System.out.println("0");
         }
            
      }
   }

}

