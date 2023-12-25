/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Newtons Chaos
*/

import edu.princeton.cs.introcs.StdDraw;

public class Chaos {

   public static int findRoot (final Complex z, final int maxIterations) {
      final Complex[] roots = {
            new Complex(1, 0),
            new Complex(-1, 0),
            new Complex(0, 1),
            new Complex(0, -1)
      };

      for (int i = 0; i < maxIterations; i++) {
         final Complex f = polynomial(z);
         final double VALUE = 0.001;
         if (Complex.abs(f) < VALUE) {
            for (int j = 0; j < roots.length; j++) {
               if (Complex.abs(Complex.minus(z, roots[j])) < VALUE) {
                  return j;
               }
            }
         }
         final Complex fPrime = polynomialDerivative(z);
         final Complex p = Complex.minus(z, Complex.divides(f, fPrime));
      }

      return -1;
   }

   public static Complex polynomial (final Complex z) {
      // Define your complex polynomial function here
      // For example: z^4 - 1
      return Complex.minus(Complex.power(z, 4), new Complex(1, 0));
   }

   public static Complex polynomialDerivative (final Complex z) {
      // Define the derivative of your complex polynomial function here
      // For example: 4 * z^3
      return Complex.times(new Complex(4, 0), Complex.power(z, 3));
   }

   public static void main (final String[] args) {
      final int size = Integer.parseInt(args[0]);
      StdDraw.setCanvasSize(size, size);
      StdDraw.setXscale(-1.0, 1.0);
      StdDraw.setYscale(-1.0, 1.0);
      StdDraw.enableDoubleBuffering();

      for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
            final double x = 2.0 * i / size - 1.0;
            final double y = 2.0 * j / size - 1.0;
            final Complex z = new Complex(x, y);

            final int rootIndex = findRoot(z, 100);
            drawPixel(x, y, rootIndex);
         }
      }

      StdDraw.show();
   }

   public static void drawPixel (final double x, final double y, final int rootIndex) {
      if (rootIndex == 0) {
         StdDraw.setPenColor(StdDraw.YELLOW);
      } else if (rootIndex == 1) {
         StdDraw.setPenColor(StdDraw.BLUE);
      } else if (rootIndex == 2) {
         StdDraw.setPenColor(StdDraw.RED);
      } else if (rootIndex == 3) {
         StdDraw.setPenColor(StdDraw.GREEN);
      } else {
         StdDraw.setPenColor(StdDraw.BLACK);
      }

      StdDraw.point(x, y);
   }
}


