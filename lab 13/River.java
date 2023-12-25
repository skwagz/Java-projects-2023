/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Path down the river 
*/

import java.util.Scanner;

public class River {

   public static void main (final String[] args) {
      // Initialize a scanner to read from standard input
      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 

      // Read the number of rows and columns from the user
      final int rows = scanner.nextInt();
      final int cols = scanner.nextInt();

      // Consume the newline character left after reading cols
      scanner.nextLine(); 

      // Initialize a 2D array 'map' to represent the river
      final char[][] map = new char[rows][cols];

      // Populate the map by reading each row
      for (int i = 0; i < rows; i++) {
         final String line = scanner.nextLine();
         map[i] = line.toCharArray(); // Convert the string to a character array
      }

      // Call the findPaths method to find all possible paths
      findPaths(map, 0, 0, "");
   }

   // Recursive function to find paths
   public static void findPaths (final char[][] map, final int row, 
                     final int col, final String path) {
      // Get the number of rows and columns in the map
      final int rows = map.length;
      final int cols = map[0].length;

      // Base case: If we reached the bottom-right cell, print the path
      if (row == rows - 1 && col == cols - 1) {
         System.out.println(path);
         return;
      }

      // Try moving right if possible
      if (col < cols - 1 && map[row][col + 1] == '.') {
         findPaths(map, row, col + 1, path + "R"); // Recursive call with updated path
      }

      // Try moving down if possible
      if (row < rows - 1 && map[row + 1][col] == '.') {
         findPaths(map, row + 1, col, path + "D"); // Recursive call with updated path
      }
   }
}
