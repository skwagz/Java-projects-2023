/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: Molecular Weight 
*/


import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class MolecularWeight {

   static record Molecule(String name, 
            int number, 
            String symbol, 
            double weight) {
   }

   public static void main (final String[] args) throws IOException {

      final Scanner scanner = new Scanner(System.in, "US-ASCII"); 
      final ArrayList<Molecule> molecules = new ArrayList<Molecule>();

      final String csv = args[0];
      final Path path = Paths.get(csv);
      final Scanner in = new Scanner(path, "US-ASCII");

      while (in.hasNextLine()) {
         final String header = in.nextLine(); // Skip header
         final String line = in.nextLine();
         final String[] lineArr = line.split(",");
         molecules.add(new Molecule(lineArr[0], Integer.parseInt(lineArr[1]),
                                    lineArr[2], Double.parseDouble(lineArr[3])));
      }

      while (scanner.hasNextLine()) {
         final String input = scanner.nextLine();
         final String[] inArr = input.split(" ");

         double totalWeight = 0.0;
         final boolean valid = true;

         for (int i = 0; i < inArr.length; i++) {
            final String symbol = inArr[i];
            int multiplier = 1;
            final MolecularWeight.Molecule molecule = findMoleculeBySymbol(molecules, symbol);

            if (i + 1 < inArr.length && inArr[i + 1].matches("\\d+")) {
               multiplier = Integer.parseInt(inArr[i + 1]);
               System.out.println(multiplier);
            } else {
               if (molecule != null) {
                  totalWeight += (molecule.weight * multiplier);
                  System.out.println(totalWeight);
               } else {
                  System.out.println("Moleular weight of  " + symbol + ": ??");
               }
            } 
         }

         System.out.printf("Molecular weight of %s = %.2f%n", input, totalWeight);
           
         if (valid) {
            System.out.printf("Molecular weight of %s = %.2f%n", input, totalWeight);
         }
           
           
      }
   }

   static Molecule findMoleculeBySymbol (final ArrayList<Molecule> molecules,
                                       final String symbol) {
      for (final Molecule molecule : molecules) {
         if (molecule.symbol().equals(symbol)) {
            return molecule;
         }
      }
      return null;
   }
}
