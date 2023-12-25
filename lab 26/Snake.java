/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Snake
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Snake {

   private static final int PIXEL = 20;
   private static final int BOARD_WIDTH = 35; 
   private static final int BOARD_LENGTH = 30;
   private static final ArrayList<Point> SNAKE = new ArrayList<Point>();
   private static final int BEGIN = 3;
   private static final int CURRENT_LENGTH = BEGIN;
   private static final Point CENTER = new Point (BOARD_LENGTH/2, BOARD_WIDTH/2);
   private static boolean gameOver = false;
   private static char direction = 'x';
   private static int points = 0;
   
   

   private record SnakeGame (int x, int y) {
      private boolean game (final Point check) {
         return (x == check.x) && (y == check.y);
      }
   }

   // initialize snake game play area 
   public static void playArea (final Point p, final int w, final int h) {
      final double x = p.x + w/2.0;
      final double y = p.y + h/2.0;
      StdDraw.filledRectangle(x, y, w/2.0, h/2.0);
   }
   public static void point (final Point p, final int h) {
      final double x = p.x + h/2.0;
      final double y = p.y + h/2.0;
      StdDraw.filledCircle(x, y, h/2.0);
   }

   // spawn food randomly 
   public static void food () {
      final Random random = new Random();

      final int randX  = random.nextInt(BOARD_LENGTH);
      final int randY = random.nextInt(BOARD_WIDTH);
      
      Point food = new Point(randX, randY); 

      while (SNAKE.contains(food)) {
         if (food.x == BOARD_WIDTH) {
            if (food.y == BOARD_LENGTH) {
               food = new Point (0, 0);
            } else {
               food = new Point(0, food.y +1);
            }
         } else {
            food  = new Point(food.x +1, 0);
         }
      }
      
      StdDraw.setPenColor(StdDraw.RED);
      point(food, 1);
      StdDraw.show();



      // when the snake head passes through the food 
      final Point snakeSize = SNAKE.get(SNAKE.size() -1);
      if (snakeSize.x == food.x && snakeSize.y == food.y) {
         points++;
         StdDraw.setPenColor(Color.BLUE);
         final Point p = SNAKE.get(0);
         playArea(p, 1, 1);
         food();

      }
   }

   // initialize the keypress movements 
   public static void snakeGame () {

      Point snakeMove = SNAKE.get(SNAKE.size() -1);

      if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
         direction = 'u';
         snakeMove = new Point (snakeMove.x, snakeMove.y + 1);
      } else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
         direction = 'd';
         snakeMove = new Point (snakeMove.x, snakeMove.y + 1);
      } else if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
         direction = 'h';
         snakeMove = new Point (snakeMove.x -1, snakeMove.y);
      } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
         direction = 'r';
         snakeMove = new Point (snakeMove.x + 1, snakeMove.y);
      }

      /// when the snake bites itself 
      if (SNAKE.contains(snakeMove)) {
         if (direction != 'x') {
            gameOver = true;
         } 
      } else {
         SNAKE.add(snakeMove);
      }

      // when the snake hits the wall 
      if (snakeMove.x < 0 || snakeMove.x == BOARD_WIDTH 
            || snakeMove.y < 0 || snakeMove.y == BOARD_LENGTH) {
         gameOver = true; 
      }

      StdDraw.setPenColor(Color.BLUE);
      if (SNAKE.size() > CURRENT_LENGTH) {
         final Point f = SNAKE.remove(0);
         StdDraw.setPenColor(StdDraw.BLACK);
         playArea(f, 1, 1);
      }

      StdDraw.show();
      final int pause = 150;
      StdDraw.pause(pause);

      
   }

   // output os stdDraw and game over instance 
   public static void main (final String [] args) {
      
      StdDraw.enableDoubleBuffering();

      StdDraw.setCanvasSize(BOARD_LENGTH * PIXEL, BOARD_WIDTH * PIXEL);
      StdDraw.setXscale(0, BOARD_WIDTH);
      StdDraw.setYscale(0, BOARD_LENGTH);



      StdDraw.setPenColor(Color.BLACK);
      playArea(new Point(0, 0), BOARD_WIDTH, BOARD_LENGTH);

      StdDraw.setPenColor(Color.BLUE);
      for (int i = 0; i < BEGIN; i++) {
         final Point t = new Point(CENTER.x-i, CENTER.y);
         SNAKE.add(0, t);
         playArea(t, 1, 1);
      }
      

      while (!gameOver) {
         snakeGame();
         food();
         
      }
      // Score output
      StdDraw.setPenColor(StdDraw.WHITE);
      final Font font = new Font ("Arial", Font.BOLD, 60);
      StdDraw.setFont(font);
      final String text = "Score: " + points;
      StdDraw.text(BOARD_WIDTH/2, BOARD_LENGTH/2, text);

   }


}



