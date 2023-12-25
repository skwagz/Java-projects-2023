/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Saxophone
*/


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Saxophone {
   public static void main (final String[] args) {
      final HashMap<Character, HashSet<Integer>> completeSet = new HashMap<>();
      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 

      // sets of keys pressed based on note played 
      completeSet.put('c', new HashSet<>(Set.of(2, 3,  4,  7,  8,  9,  10)));
      completeSet.put('d', new HashSet<>(Set.of(2,  3, 4, 7, 8, 9)));
      completeSet.put('e', new HashSet<>(Set.of(2, 3, 4, 7, 8)));
      completeSet.put('f', new HashSet<>(Set.of(2, 3, 4, 7)));
      completeSet.put('g', new HashSet<>(Set.of(2, 3, 4)));
      completeSet.put('a', new HashSet<>(Set.of(2, 3)));
      completeSet.put('b', new HashSet<>(Set.of(2)));
      completeSet.put('C', new HashSet<>(Set.of(3)));
      completeSet.put('D', new HashSet<>(Set.of(1, 2, 3, 4, 7, 8, 9)));
      completeSet.put('E', new HashSet<>(Set.of(1, 2, 3, 4, 7, 8)));
      completeSet.put('F', new HashSet<>(Set.of(1,  2, 3, 4, 7)));
      completeSet.put('G', new HashSet<>(Set.of(1, 2, 3, 4)));
      completeSet.put('A', new HashSet<>(Set.of(1,  2, 3)));
      completeSet.put('B', new HashSet<>(Set.of(1, 2)));

      while (scanner.hasNextLine()) {
         final String song = scanner.nextLine();
         final int[] fingerCount = new int[10];
         countFingerPresses(fingerCount, song, completeSet);

         // output stream 
         for (int i = 0; i < fingerCount.length; i++) {
            System.out.print(fingerCount[i] + " ");
         }

         System.out.println();
      }

      scanner.close();
   }

   private static void countFingerPresses (final int [] fingerCount, final String song, 
                                    final HashMap<Character, HashSet<Integer>> completeSet) {
      final char [] x = song.toCharArray();
      final boolean [] marked = new boolean[10];
      
      // iterate through the keys  from char array x
      for (int i = 0; i < x.length; i++) {
         final char key = x[i];

         // get key strokes from sets 
         final Set<Integer> a = completeSet.get(key);

         // add key stroke counter based on whether pressed
         for (int n = 0; n < marked.length; n++) {
            if (!marked[n] && a.contains(n+1)) {
               fingerCount[n] += 1;
            }
            marked[n] = a.contains(n+1);
         }
      }
   }
}
