import java.util.Scanner;

public class Grades { 
   public static void main (final String [] args) { 
      
      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 
      

      final int amount = scanner.nextInt();
      final int [] grades = new int [amount];

   

      int count = 0;
      int sum = 0;
      while (scanner.hasNext()) { 
         final String  firstName = scanner.next(); 
         final String lastName = scanner.next();  
         grades[count]  = scanner.nextInt();        
         sum += grades[count];
         count++; 
      }
      final double mean = sum / amount; 

      double std = 0; 
      
      for (int i = 0; i < amount; i++) { 
         std = std + Math.pow((grades[i] - mean), 2);
      }
      
      
      std = std / (amount);
      std = Math.sqrt(std);
      final double [] zscore = new double [amount];
      final char [] letter = new char [amount];
      
      for (int i = 0; i < amount; i++) { 
      
         zscore[i] = (grades[i]-mean)/std;

      }

      for (int i = 0; i < amount; i++) {
         
         if (zscore[i] >= 1) {
            letter[i] = 'A';
         } else if (zscore[i] >= 0) {
            letter[i] = 'B';
         } else if (zscore[i] >= -1) {
            letter[i] = 'C';
         } else if (zscore[i] >= -2) {
            letter[i] = 'D';
         } else {
            letter[i] = 'F';
         }
      
      }

      System.out.println("Score     Z     Grade");
      for (int i = 0; i < amount; i++) { 
         System.out.printf("%5d %5.2f %5s\n", grades[i], zscore[i], letter[i]);
      }

      System.out.printf("Average %6.2f%n", mean);

 



   }
    
}
