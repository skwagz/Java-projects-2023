/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Lost at Sea 
*/

public class Manatee {
   private int x;
   private int y;

   public Manatee() {
      this.x = 0;
      this.y = 0;
   }

   // monitor the movement of the manatee 
   public void move (final char direction) {
      switch (direction) {

         case 'N': 
         y++;
         break;
         case 'S': 
         y--;
         break;
         case 'E': 
         x++;
         break;
         case 'W': 
         x--; 
         break; 
         default:  
         break; 
      }
   }

   // getter method for x 
   public int getX () {
      return x;
   }

   // getter method for y 
   public int getY () {
      return y;
   }
}
