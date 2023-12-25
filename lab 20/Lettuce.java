
/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Lettuce
*/


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List; 
import java.util.Comparator;


public class Lettuce { 

   static record Vendor (String name, int price){
      
   }
   public static void main (final String [] args) {

      final Scanner scanner = new Scanner (System.in, "US-ASCII");
    
      String line = scanner.nextLine();
      final String[] numbers = line.split(" ");
      final int N = Integer.parseInt(numbers[0]);
      final int M = Integer.parseInt(numbers[1]);
      final List<Vendor> vendors = new ArrayList<>();
      
      int count = 0;
      while (scanner.hasNext()) {
         line = scanner.nextLine(); // Read the entire line
         line.strip();
         final String[] parts = line.split(", "); // Split by comma 
         final String name = parts[0];

         final int cost = Integer.parseInt(parts[1].replace(" ", ""));
     
         // add created vendor object to the list
         vendors.add(new Vendor(name, cost));
         count++;

         // if all vendors are read 
         if (count >= N) {
            break;
         }
      }
     
      // sort the vendor by price 
      Collections.sort(vendors, Comparator.comparingInt(Vendor::price));

      
      int casesBought = 0;
      int moneyLeft = M;
      final List<String> stores = new ArrayList<>();

      // iterate through vendors and buy cases if available 
      for (final Vendor vendor : vendors) {
         if (vendor.price() <= moneyLeft) {
            casesBought++;
            moneyLeft -= vendor.price();
            stores.add(vendor.name() + " @ $" + vendor.price());
         }
      }

      // sort the stores 
      Collections.sort(stores);

      System.out.println(String.join("\n", stores));
      System.out.println(casesBought + " with $" + moneyLeft + " left over");


   }
    
}
