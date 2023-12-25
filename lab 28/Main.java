/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Selection Sort 
*/

import java.util.List;
import java.util.Random;
import java.util.Collections;


public class Main {

    
   private static final Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));
    
   public static void main (final String [] args) throws Exception {

      final int n = Integer.parseInt(args [0]);
      final String listType = args[1];

      final Class<?> clazz = Class.forName(listType);
      @SuppressWarnings("unchecked")
      final java.util.List<Integer> list = (java.util.List<Integer>) 
            clazz.getDeclaredConstructor().newInstance();

        
      for (int i = 1; i <= n; i++) {
         list.add(i-1, i);
      }


      long startTime = 0;
      long endTime = 0;
      long total = 0;

      for (int i = 0; i < 10; i++) {
         Collections.shuffle(list, RNG);


         // Prepare the experiment
         startTime = System.nanoTime();
         // Run the experiment
         sort(list, n);
         endTime = System.nanoTime();
         total += endTime - startTime;


      }

      // calculate the average sort time 
      final long averageSortTime = total / 10;
      final double conversion = 1_000_000_000.0;
      System.out.printf("PT%.9fS\n", averageSortTime / conversion);

   }

   public static void sort (final List<Integer> data, final int num) {
      for (int i = 0; i < data.size() - 1; i++) {
         /* find the min element in the unsorted data[i, i+1, .., n-1] */
         /* assume initially that min is the first element in the range */
         int min = i;
         
         for (int j = i + 1; j < data.size(); j++) {
            /* if the 'j'th element is less, then it is the new minimum */
            if (data.get(j) < data.get(min)) {
               /* found new minimum; remember its index */
               min = j;
            }
         }
      
         /* swap data at 'min' with data at 'i' */
         final Integer smallerNum = data.get(min);
         
         data.set(min, data.get(i));
         data.set(i, smallerNum);
      }
   }

}
