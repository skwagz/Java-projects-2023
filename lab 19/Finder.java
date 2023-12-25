/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Fast Food Finders 
*/

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Finder {

   // Define record classes
   static record Wendy (String longitude, String latitude, String address) {
   }
   static record City (String city, String state, String population, 
                        String latitude, String longitude) {
   }

   public static void main(final String[] args) throws IOException, URISyntaxException {

      final List<Wendy> wendys = loadWendysData();
      final List<City> cities = loadCitiesData();

      final Scanner scanner = new Scanner(System.in);

      while (scanner.hasNextLine()) {
         final String[] input = scanner.nextLine().split(",");
         final String city = input[0].trim();
         final String state = input[1].trim();

         // Find matching city
         final Optional<City> matchingCity = cities.stream()
               .filter(c -> c.city().equalsIgnoreCase(city) && 
               c.state().equalsIgnoreCase(state))
               .findFirst();

         if (matchingCity.isPresent()) {
            final City matchedCity = matchingCity.get();
            final Wendy closestWendy = findClosestWendy(wendys, matchedCity);
            if (closestWendy != null) {
               System.out.println("Closest Wendy's is at address: " + closestWendy.address() 
                     + ", " + matchedCity.city() + "," + matchedCity.state());
            } else {
               System.out.println("???");
            }
         } else {
            System.out.println("???");
         }
      }
   }

   static List<Wendy> loadWendysData () throws IOException, URISyntaxException {
      final URI uri = new URI("https://introcs.cs.princeton.edu/java/data/wendys.csv");
      try (final Scanner scanner = new Scanner (uri.toURL().openStream())) {
         final List<Wendy> wendys = new ArrayList<>();
         while (scanner.hasNextLine()) {
            final String[] tokens = scanner.nextLine().split(",
                        (?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            wendys.add (new Wendy(tokens[0], tokens[1], tokens[2]));
         }
         return wendys;
      }
   }

   static List<City> loadCitiesData() throws IOException, URISyntaxException {
      final URI uri = new URI("https://raw.githubusercontent.com/plotly/datasets/master/us-cities-top-1k.csv");
      try (final Scanner scanner = new Scanner(uri.toURL().openStream())) {
         final List<City> cities = new ArrayList<>();
         while (scanner.hasNextLine()) {
            final String[] tokens = scanner.nextLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            cities.add(new City(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]));
         }
         return cities;
      }
   }

   static Wendy findClosestWendy(final List<Wendy> wendys, final City city) {
      final double cityLat = Double.parseDouble(city.latitude());
      final double cityLon = Double.parseDouble(city.longitude());

      double minDistance = Double.MAX_VALUE;
      Wendy closestWendy = null;

      for (final Wendy wendy : wendys) {
         final double wendyLat = Double.parseDouble(wendy.latitude());
         final double wendyLon = Double.parseDouble(wendy.longitude());

         final double distance = calculateGreatCircleDistance(cityLat, cityLon, wendyLat, wendyLon);
         if (distance < minDistance) {
            minDistance = distance;
            closestWendy = wendy;
         }
      }

      return closestWendy;
   }

   static double calculateGreatCircleDistance(final double lat1, final double lon1,
         final double lat2, final double lon2) {
      final double dLat = Math.toRadians(lat2 - lat1);
      final double dLon = Math.toRadians(lon2 - lon1);
      final double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
            Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
            Math.sin(dLon / 2) * Math.sin(dLon / 2);
      final double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
      return 6371 * c; // Radius of the Earth in km
   }
}
