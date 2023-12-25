
import java.util.Scanner;


public class Pad1 {
    public static void main (final String [] args) {
      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 
      
      int k = scanner.nextInt();

      String num = Integer.toString(k);

      int prevDigit = 11;
      int newNum;

      
      for (int i = num.length() + 1; i > 0; i-- ) { 

         newNum = (k % 10^(i-1));
         prevDigit = (k - newNum)/10^(i-1);
         k = newNum;

         System.out.println(prevDigit);
      }

      
        
    }
    
}
