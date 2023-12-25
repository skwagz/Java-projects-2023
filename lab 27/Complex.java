/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Newtons Chaos 
*/

public record Complex (double real, double imag) {

   public static double abs (final Complex z) {
      return Math.hypot(z.real(), z.imag());
   }

   public static Complex plus (final Complex a, final Complex b) {
      return new Complex(a.real() + b.real(), a.imag() + b.imag());
   }

   public static Complex times (final Complex a, final Complex b) {
      final double real = a.real() * b.real() - a.imag() * b.imag();
      final double imag = a.real() * b.imag() + a.imag() * b.real();
      return new Complex(real, imag);
   }

   public static Complex minus (final Complex a, final Complex b) {
      return new Complex(a.real() - b.real(), a.imag() - b.imag());
   }

   public static Complex divides (final Complex a, final Complex b) {
      final double denom = b.real() * b.real() + b.imag() * b.imag();
      final double real = (a.real() * b.real() + a.imag() * b.imag()) / denom;
      final double imag = (a.imag() * b.real() - a.real() * b.imag()) / denom;
      return new Complex(real, imag);
   }

   public static Complex power (final Complex z, final int exponent) {
      final Complex result = new Complex(1, 0);
      for (int i = 0; i < exponent; i++) {
         result = times(result, z);
      }
      return result;
   }

   public static void main (final String[] args) {
      final Complex testNumber = new Complex(3.0, 4.0);
      System.out.println("Absolute Value: " + abs(testNumber));
      System.out.println("Sum: " + plus(testNumber, new Complex(1.0, 2.0)));
      System.out.println("Product: " + times(testNumber, new Complex(1.0, 2.0)));
      System.out.println("Difference: " + minus(testNumber, new Complex(1.0, 2.0)));
      System.out.println("Quotient: " + divides(testNumber, new Complex(1.0, 2.0)));
      System.out.println("Power: " + power(testNumber, 2));
   }
}
