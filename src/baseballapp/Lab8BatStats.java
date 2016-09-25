package baseballapp;

import java.util.Scanner;

public class Lab8BatStats {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Batting Average Calculator!");
		System.out.println();
		String cont = "y";

		while (cont.equalsIgnoreCase("y")) {

			int atBatTotal = 0;
			int hits;
			int sum = 0;
			double battingAverage = 0.000;// traditional 3 decimal places
			double sluggingPercentage = 0.000;// traditional 3 decimal places
			
			while (cont.equalsIgnoreCase("y")) {
				
				sum = 0;
				hits = 0;

				// Ask the user for the total number of at-bats for the player
				System.out.println("Play ball! Enter your player's TOTAL times at-bat for one game: ");
				atBatTotal = sc.nextInt();
				
				while (atBatTotal < 1 || atBatTotal > 5) {
					System.out.println("No. Way. THAT is not a valid option. Enter an at-Bat between 1 and 5");
					atBatTotal = sc.nextInt();
				}
				
				// This creates an array object to store the results of each at-bat, in a rolling accumulation
				int[] atBatsResults = new int[atBatTotal];
				
				// Prints the choices for at-bat results
				System.out.println("\n 0 = out,\n 1 = single,\n 2 = double,\n 3 = triple,\n 4 = home run");	
				
				// this for loop stores the user inputs for each at-bat result in an array called atBatResults
				
				for (int i = 0; i < atBatTotal; i++) {
					System.out.println("  Result for at-bat " + (i+1) + ": ");
					atBatsResults[i] = sc.nextInt();

					// if the user enters a number less than 0 or greater than  5, this while loop asks them for valid input

					while (atBatsResults[i] < 0 || atBatsResults[i] > 4) {
						System.out.println("No. Way. THAT is not a valid option. Enter an at-Bat between 0 and 4");
						atBatsResults[i] = sc.nextInt();

					}// end while
					// calculation for the sum of the # of bases earned
					sum = sum + atBatsResults[i];
					
					// counts the number of hits
					if (atBatsResults[i] > 0)
						hits++; 
									
				}//end for
				
				// Batting Average calculation and display
				battingAverage =  (double) hits / (double) atBatTotal; 
				System.out.println("Batting Average: ");
				System.out.printf("%.3f%n", battingAverage); // f for format of only 3 decimal places "%.3f%n"
															
				System.out.println();

				// Slugging Percentage calculation and display
				sluggingPercentage = (double) sum / (double) atBatTotal; 															
				System.out.println("Slugging Percentage: ");
				System.out.printf("%.3f", sluggingPercentage); // f for format of only 3 decimal places
																
				System.out.println();// Skip

				System.out.println("Would you like to enter stats for another batter? (y/n) :"); // Another Player?
																									
				cont = sc.next();

			}// end while
			// continue if
			if (cont.equalsIgnoreCase("n")) {

				System.out.println("Game over!");

			}//end if

		}// end while 1
		sc.close();
	}//main

}//class
