/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Josephus Problem
*/


import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


public class Josephus {

   public static void main (final String [] args) throws Exception {

      final int step = Integer.parseInt(args[0]);
      final String listType = args[1];
      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 



      final Class<?> clazz = Class.forName(listType);
      @SuppressWarnings("unchecked")
      final java.util.List<String> soldierList = (java.util.List<String>) 
            clazz.getDeclaredConstructor().newInstance();      

      while (scanner.hasNext()) {
         soldierList.add(scanner.nextLine());
      }
      scanner.close();
      
      
      

      long startTime, endTime, total = 0;
      final int test = 10; // number of time to run the test
   
      for (int i = 0; i < 10; i++) {

         // Prepare the experiment
         startTime = System.nanoTime();
         // Run the experiment
         findLastSoldier(soldierList, step, listType);
         endTime = System.nanoTime();
         total += endTime - startTime;
      }

      final String soldierName = findLastSoldier(soldierList, step, listType);

      // calculate the average sort time 
      final long averageSortTime = total / 10;
      final double conversion = 1_000_000_000.0;
      System.out.print(" Last soldier: " + soldierName + " Time: ");
      System.out.printf("PT%.9fS\n", averageSortTime / conversion);


   }

   private static String findLastSoldier (final List<String> soldiersList, 
                                    final int step, final String listType) {
      ListIterator<String> iterator;
      iterator = soldiersList.listIterator();

      while (soldiersList.size() > 1) {
         for (int i = 0; i < step; i++) {
            if (!iterator.hasNext()) {
               iterator = soldiersList.listIterator();
            }
            iterator.next();
         }

         iterator.remove();
      }

      return soldiersList.get(0);
   }
    
}
