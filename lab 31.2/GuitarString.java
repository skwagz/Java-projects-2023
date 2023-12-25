import java.util.ArrayDeque;
import java.util.Random;
public class GuitarString  {
   static final int SAMPLE = 44100;
   static long n;
   final ArrayDeque<Double> string;
   static final double DECAY = 0.994;
  
   GuitarString (final double frequency) {
      string = new ArrayDeque<Double>();
      n = Math.round(Math.ceil(SAMPLE/frequency));

   }
   // Populates ArrayDeque elements with random double value
   // between -0.5 and 0.5
   void pluck () {
      for (int i = 0; i < n; i++) {
         final Random RNG = new Random();
         string.add(RNG.nextDouble()-0.5);
      }
   }

   // Implements Karplus -Strong string synthesis algorithm
   void tic () {
      final double d = string.removeFirst();
      double x = d + string.peekFirst();
      x = x/2.0;
      x = x * DECAY;
      string.add(x);
   }
   // gets top ArrayDeque element
   double sample () {
      return string.peekFirst();
   }
}
