/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Storm tracking
*/

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class Storm { 

   public static void main (final String []args)throws  IOException, URISyntaxException {


      final String path = "https://raw.githubusercontent.com/jbrei2018/labdata/main/atlantic.csv";
      
      final int x = 880;
      final int y = 524;
      final String map = "Map.jpg";
      StdDraw.setCanvasSize(x, y);
      final int m = -105; // scale of x
      StdDraw.setXscale(m, -10);
      final int n = 50; // scale of y
      StdDraw.setYscale(n, 0);
      final int u = -57; // starting point x
      final int t = 25; // starting point y 
      StdDraw.picture(u, t, map);
      final double penRad = 0.04; // pen radius 
      StdDraw.setPenRadius(penRad);

      final String id = args[0];

      
      final URI uri = new URI (path);
      final URL url = uri.toURL();

      try (InputStream is = url.openStream()) {
         final Scanner inp = new Scanner(is);

         // skip header in the csv file 
         inp.nextLine();

         boolean stormFound = false;
         while (inp.hasNext()) {
                  
            // read in input from csv file and split it 
            final String line = inp.nextLine();
            final String [] stormIn = line.split(",");
            final String stormId = (stormIn[0]);
                  
            // check if id matches and use stormType method to draw point
            if (id.equals(stormId)) {

               stormFound = true;

               final double latitude = Double.parseDouble(stormIn[6]
                                                   .substring(0, stormIn[6].length() - 1));
               final double longitude = Double.parseDouble(stormIn[7]
                                                   .substring(0, stormIn[7].length() - 1));
               final int maxSpeed = Integer.parseInt(stormIn[8]);
               stormType(maxSpeed);
               StdDraw.point(-longitude, latitude);
            }
         } 
      }
   }

   
      
   

   

   // check category of the storm based on windspeed 
   public static void stormType (final int maxSpeed) {
      final int tropStorm = 74; // limit to be tropical storm
      final int catOne = 96; // limit to be considered cat 1
      final int catThree = 130; // limit to be considered cat 3
      final int catFour = 157; // limit to be considered cat 4


      if (maxSpeed >= tropStorm) {
         StdDraw.setPenColor(StdDraw.YELLOW);
      } else if (maxSpeed >= catOne) {
         StdDraw.setPenColor(StdDraw.ORANGE);
      } else if (maxSpeed >= catThree) {
         StdDraw.setPenColor(StdDraw.RED);
      } else if (maxSpeed >= catThree) {
         StdDraw.setPenColor(StdDraw.PINK);
      } else if (maxSpeed >= catFour) {
         StdDraw.setPenColor(StdDraw.WHITE);
      } else {
         StdDraw.setPenColor(StdDraw.GREEN);
      }
   }
}


