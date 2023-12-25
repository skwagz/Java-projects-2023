/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Movie 
*/

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Movie {

   static record Record (int index, int firstRoundVotes, int secondRoundVotes) {
   }

   public static void main (final String[] args) {
      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 

      final int N = scanner.nextInt();
      final int K = scanner.nextInt();
      scanner.nextLine(); // Consume the newline character

      // make a record array to store the first and second round votes
      final  Record [] movies = new Record[N];
      for (int i = 0; i < N; i++) {
         final int firstRoundVotes = scanner.nextInt();
         final int secondRoundVotes = scanner.nextInt();
         movies[i] = new Record(i + 1, firstRoundVotes, secondRoundVotes);
         scanner.nextLine(); 
      }


      Arrays.sort(movies, Comparator.comparingInt(Record::firstRoundVotes)
            .reversed().thenComparingInt(Record::index));

      // Sort only the advancing movies based on first round votes
      final Record[] advancingMovies = Arrays.stream(movies)
            .sorted(Comparator.comparingInt(Record::firstRoundVotes)
            .reversed().thenComparingInt(Record::index)).limit(K)
            .toArray(Record[]::new);

      // Sort only the advancing movies based on second round votes
      Arrays.sort(advancingMovies, Comparator.comparingInt(Record::secondRoundVotes)
            .reversed().thenComparingInt(Record::index));

      final int firstPlace = advancingMovies[0].index();
      final int lastPlace = advancingMovies[K - 1].index();

      System.out.println();
      System.out.println(firstPlace + " " + lastPlace);
   }
}
