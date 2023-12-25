import java.util.Scanner;
public class GuitarHero  {
   public static void main (final String[] args) throws Exception {

      final Scanner scanner = new Scanner(System.in, "US-ASCII");
      final double wholeNote = 33000;
     
      while (scanner.hasNext()) {
         // Grabs note index from user inputs and calculates frequency
         final double note = scanner.nextInt();
         final double frequency = 440 * Math.pow(2.0, note/12.0);
         
         final GuitarString temp = new GuitarString(frequency);
         temp.pluck();
         // Calculates duration using factor from input
         final double factor = scanner.nextDouble();
         final double duration = wholeNote * factor; 
         
         // Plays note for duration of tics
         for (int i = 0; i < duration; i++) {
            temp.tic();
            StdAudio.play(temp.sample());
         }
      }
   }
}
