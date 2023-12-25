/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Tictactoe
*/

import java.util.Scanner;

public class Tictactoe {

   public static void main (final String[] args) {
      final Scanner scanner = new Scanner (System.in, "US-ASCII"); 
      final char[][] board = new char[3][3];
        
      // Read input board
      for (int i = 0; i < 3; i++) {
         final String line = scanner.nextLine();
         for (int j = 0; j < 3; j++) {
            board[i][j] = line.charAt(j);
         }
      }
        
      int individualWins = 0;
      int teamWins = 0;
        
      // Check horizontal wins
      for (int i = 0; i < 3; i++) {
         if (checkWin(board[i][0], board[i][1], board[i][2])) {
            individualWins++;
         }
         if (checkWinTeam(board[i][0], board[i][1], board[i][2])) {
            teamWins++;
         }
      }
        
      // Check vertical wins
      for (int i = 0; i < 3; i++) {
         if (checkWin(board[0][i], board[1][i], board[2][i])) {
            individualWins++;
         }
         if (checkWinTeam(board[0][i], board[1][i], board[2][i])) {
            teamWins++;
         }
      }
        
      // Check diagonal wins
      if (checkWin(board[0][0], board[1][1], board[2][2])) {
         individualWins++;
      }
      if (checkWinTeam(board[0][0], board[1][1], board[2][2])) {
         teamWins++;
      }
        
      if (checkWin(board[0][2], board[1][1], board[2][0])) {
         individualWins++;
      }
      if (checkWinTeam(board[0][2], board[1][1], board[2][0])) {
         teamWins++;
      }
        
      System.out.println(individualWins);
      System.out.println(teamWins);
   }

   // Helper method to check if a line contains only two distinct characters
   public static boolean checkWin (final char c1, final char c2, final char c3) {
      if (c1 == c2 && c1 == c3 && c2 == c3) {
         return true;
      } 
      return false;
   }

   public static boolean checkWinTeam (final char c1, final char c2, final char c3) {
      if (c1 == c2 || c1 == c3 || c2 == c3) {
         if (c1 == c2 && c1 == c3 && c2 == c3) {
            return false;
         }
         return true;
      } 
      return false;
   }
}
