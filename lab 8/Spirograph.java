/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Fun with Hyperscyloids
*/

public class Spirograph {
   public static void main (final String  [] args) { 

      final int SIZE = 800;
      final double penRadius = 0.02; 
      final double increment = 0.01;
      double x; 
      double y; 

      /* to set canvas size, the scale on the 
      canvas, background, pencolor and pen radius */
      StdDraw.setCanvasSize(SIZE, SIZE);
      StdDraw.setScale(-SIZE/2, SIZE/2);
      StdDraw.clear(StdDraw.BLACK);
      StdDraw.setPenColor(StdDraw.WHITE);
      StdDraw.setPenRadius (penRadius); 



      /* Take R (Radius of larger circle) , r(radius of smaller circle), 
      and a(Offset of the pen in the moving circle) */
      final double R = Double.parseDouble(args[0]);
      final double r = Double.parseDouble(args[1]);
      final double a = Double.parseDouble(args[2]);

      /* loop to draw the Spirograph using the given formula */
      for (double t = 0.0; t < 100; t += increment) {
         x = (R+r) * Math.cos(t) - (r+a) * Math.cos(((R+r)/r)*t);
         y = (R+r) * Math.sin(t) - (r+a) * Math.sin(((R+r)/r)*t);
         StdDraw.point(x, y);

      }
   }
}

