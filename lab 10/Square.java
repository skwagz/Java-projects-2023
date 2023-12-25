/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Fun with squares 
*/


public class Square {
   
   /* Draw the respective squares using the order 
   it is called in the pattern methods */
   public static void square (final double x, final double y, final double size) {
      
      StdDraw.setPenColor (StdDraw.LIGHT_GRAY);
      StdDraw.filledSquare (x, y, size/2);
      StdDraw.setPenColor (StdDraw.BLACK);
      StdDraw.square (x, y, size/2);

   }  
   
   public static void pattern1 (final double R, final int level, final double n, 
                               final double x, final double y) {
      
      // stop recursion when all squares have been drawn 
      if (level == 0) {
         return;
      }

      /* to draw the squares with all the smaller 
      squares under the larger ones  */
      pattern1 (R, (level - 1), (n/R), (x + (n/2)), (y + (n/2)));
      pattern1 (R, (level - 1), (n/R), (x - (n/2)), (y + (n/2)));
      pattern1 (R, (level - 1), (n/R), (x - (n/2)), (y - (n/2)));
      pattern1 (R, (level - 1), (n/R), (x + (n/2)), (y - (n/2)));
      square (x, y, n);
   }

   public static void pattern2 (final double R, final int level, final double n, 
                              final double x,  final double y) {

      if (level == 0) {
         return;
      }

      /* to draw the squares where the smaller bottom left square 
      in every larger squares is in the level above  */
      pattern2 (R, (level - 1), (n/R), (x + (n/2)), (y + (n/2)));
      pattern2 (R, (level - 1), (n/R), (x - (n/2)), (y + (n/2)));
      pattern2 (R, (level - 1), (n/R), (x - (n/2)), (y - (n/2)));
      square (x, y, n);
      pattern2 (R, (level - 1), (n/R), (x + (n/2)), (y - (n/2)));

   }

   public static void pattern3 (final double R, final int level, final double n, 
                              final double x,  final double y) {
      
      if (level == 0) { 
         return; 
      } 
 
      /* to draw the squares where every larger square is the 
      level under their respective smaller squares */
      square(x, y, n);
      pattern3(R, (level - 1), (n/R), (x + (n/2)), (y + (n/2))); 
      pattern3(R, (level - 1), (n/R), (x - (n/2)), (y + (n/2))); 
      pattern3(R, (level - 1), (n/R), (x - (n/2)), (y - (n/2))); 
      pattern3(R, (level - 1), (n/R), (x + (n/2)), (y - (n/2))); 


   }

   public static void pattern4 (final double R, final int level, final double n, 
                              final double x,  final double y) { 
      if (level == 0) { 
         return; 
      } 

      /* to draw out the squares where the bottom right and left smaller 
      squares are on the level above their respective larger squares */
      pattern4 (R, (level - 1), (n/R), (x + (n/2)), (y + (n/2))); 
      pattern4 (R, (level - 1), (n/R), (x - (n/2)), (y + (n/2))); 
      square (x, y, n); 
      pattern4 (R, (level - 1), (n/R), (x - (n/2)), (y - (n/2))); 
      pattern4 (R, (level - 1), (n/R), (x + (n/2)), (y - (n/2))); 
   }

   public static void main (final String [] args) { 

      final int SIZE = 800; 
      final double R = Double.parseDouble(args[0]); 
      final int level = Integer.parseInt(args[1]); 
      final int pattern = Integer.parseInt(args[2]); 

      // to set canvas size, the scale on the canvas 
      
      StdDraw.setCanvasSize (SIZE, SIZE); 
      StdDraw.setScale (-SIZE/2, SIZE/2); 


      // to call the different methods based on the different patterns
      if (pattern == 1) { 
         pattern1 (R, level, (SIZE/2), 0, 0); 
      } else if (pattern == 2) { 
         pattern2 (R, level, (SIZE/2), 0, 0); 
      } else if (pattern == 3) { 
         pattern3 (R, level, (SIZE/2), 0, 0); 
      } else if (pattern == 4) { 
         pattern4 (R, level, (SIZE/2), 0, 0); 
      } 
      
      
   }

}  

