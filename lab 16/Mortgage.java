/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Mortgage
*/

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Mortgage { 
   public static void main (final String [] args) {

      // Initialize a scanner to read input from the console
      final Scanner scanner = new Scanner(System.in, "US-ASCII"); 

      // Read the initial loan amount and interest rate
      final BigDecimal loan = scanner.nextBigDecimal();
      final BigDecimal rate = scanner.nextBigDecimal();

      // Initialize the balance with the loan amount
      BigDecimal balance = loan; 

      // Loop to process input
      while (scanner.hasNext()) {

         // Read the next input and convert it to lowercase
         final String input = scanner.next().toLowerCase();

         // Consume the rest of the line (newline character)
         scanner.nextLine();

         if (input.equals("balance")) {
            // Calculate the absolute value of the balance
            final BigDecimal absoluteBalance = balance.abs().setScale(2, 
                                             RoundingMode.HALF_UP);

            // Check if the balance is exactly zero
            if (balance.compareTo(BigDecimal.ZERO) == 0) {
               // If balance is zero, print  print that the balance is 0.00
               System.out.println("(balance: 0.00)");
            } else {
               // Print balance with appropriate message (left or over)
               System.out.println("balance: " + absoluteBalance 
                                    + (balance.compareTo(BigDecimal.ZERO) 
                                    > 0 ? " left" : " over"));
            }
         } else {
            // Process a payment
            final BigDecimal payment = new BigDecimal(input);
            final BigDecimal interest = balance.multiply(rate).setScale
                                       (2, RoundingMode.HALF_UP);
            balance = balance.add(interest).subtract(payment);
         }
      }

      // Close the scanner
      scanner.close();
   }
}
