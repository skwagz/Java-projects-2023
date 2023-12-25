/*
*Author: Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: OUtput Formatting
*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Locale.Builder;


public final class Table { 
   public static void main (final String[] args) { 

      // converting the args from string to int 
      final int n;
      if (args.length < 0) { 
         n = Integer.parseInt (args[0]);
      } else { 
         n = 10;
      }
      
      System.out.printf("%9s %9s %9s %9s %9s %9s  %9s %n", "i", 
            "hex", "bits",  "log2(i*i)", "i*i", "i*i*i", "pcnt"); 
      
      final int dash = 69;  
      for (int i = 0; i <= dash; i++) { 
         System.out.print("-"); 
      }
      System.out.println(); 


      for (int i = 1; i <= n; i++) { 
      
         final int bits;
         final int x = (int) Math.ceil(Math.log(i)/ Math.log(2)); 
         bits = x;  
         final double logi2 = Math.log(Math.pow(i, 2))/Math.log(2); 
         final int i2 = i*i; 
         final int i3 = i*i*i;      
         final int pcnt = (int) Math.round(i * 100.0/n); 

         System.out.printf ("%9d  ", i); 
         System.out.printf ("0X%06X ", i); 
         System.out.printf ("%9d ", bits); 
         System.out.printf ("%9.3f ", logi2); 
         System.out.printf ("%9d ", i2); 
         System.out.printf ("%9d  ", i3); 
         System.out.printf ("%8d%%  %n", pcnt);       
      }

      for (int i = 0; i <= dash; i++) {
         System.out.print("-"); 
      }
      System.out.println(); 

      final LocalDate today = LocalDate.now(); 
      final Locale spanish = new Builder().setLanguage("es").setRegion("ES").
            build(); 
      final String DATE_SPANISH = today.format(DateTimeFormatter.ofPattern
            ("EEEE, d MMMM yyyy", spanish)); 
      System.out.printf("%46s %n", DATE_SPANISH); 
      
    
   }
}


