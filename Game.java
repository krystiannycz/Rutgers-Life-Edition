// Team 1 - Krystian Nycz, Joslyn Parchman, Yun Jin Park

/** This is a text-based adventure game based on the everyday life of a student at Rutgers.
 * Try to make it to your last class. Make the right decisions or put your grade at risk.
 */ 

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;


public class Game {

	public static void main(String[] args) throws FileNotFoundException {

		//Initializing variables and arrays
		int action = 10;
		boolean gameRunning = true;
		Random rand = new Random();
		String livi = "Livingston Student Center";
		String collegeAve = "College Ave Student Center";
		String busch = "Busch Student Center";
		String cook = "Cook/Douglass Student Center";
		String destination = " ";
		String building = " ";
		int buildingCode = 0;
		int minsLate = 0;
		String bus = " ";
		boolean correctBus = false;
		String subject = " ";
		int numDelays = 0;
		boolean backpackOpened = false;
		boolean checkedSchedule = false;


		//Creating string for subjects 
		String [] arr = {"Calculus I - SERC (Located on Busch)", "Theater Appreciation - Scott Hall (Located on College Ave)", 
				"Organic Chemistry - Hill Center (Located on Busch)", "General Biology - Bartlett Hall (Located on Cook/Douglass)",
				"Chemistry Lab - Tillet Hall (Located on Livingston)", "Data 101 - Lucy Stone Hall (Located on Livingston)",
				"Objected-Oriented Programming - School of Communications (Located on College Ave)", 
				"Game Design - Hickman Hall (Located on Cook/Douglass)", "Economics 101 - Beck Hall (Located on Livingston)", 
				"Physics - Allison Road Classroom Building (Located on Busch)", "Psychology - Lipman Hall (Located on Cook/Douglass)",
		"American History - Voorhees Hall (Located on College Ave)"};
		Random random = new Random();

		//Randomly selects class location 
		int selectClass = random.nextInt(arr.length); 

		//Keeps track of which bus should be ridden according to randomly selected class room building
		if (selectClass == 0) {
			building = "SERC";
			buildingCode = 1;
			bus = "B bus";
			subject = "Calculus I";
		}
		if (selectClass == 1) {
			building = "Scott Hall";
			buildingCode = 3;
			bus = "LX bus";
			subject = "Theater Appreciation";
		}
		if (selectClass == 2) {
			building = "Hill Center";
			buildingCode = 2;
			bus = "B bus"; 
			subject = "Organic Chemistry";
		}
		if (selectClass == 3) {
			building = "Bartlett Hall";
			buildingCode = 1;
			bus = "REXL bus"; 
			subject = "General Biology";
		}
		if (selectClass == 4) {
			building = "Tillet Hall";
			buildingCode = 2;
			bus = "a walk. Stayed on Livingston.";
			subject = "Chemistry Lab";
		}
		if (selectClass == 5) {
			building = "Lucy Stone Hall";
			buildingCode = 1;
			bus = "a walk. Stayed on Livingston.";
			subject = "Data 101";
		}
		if (selectClass == 6) {
			building = "School of Communications";
			buildingCode = 2;
			bus = "LX bus";
			subject = "Object-Oriented Programming";
		}

		if (selectClass == 7) {
			building = "Hickman Hall";
			buildingCode = 3;
			bus = "REXL bus";
			subject = "Game Design";
		}
		if (selectClass == 8) {
			building = "Beck Hall";
			buildingCode = 3;
			bus = "a walk. Stayed on Livingston.";
			subject = "Economics 101";
		}
		if (selectClass ==  9) {
			building = "Allison Road Classroom Building";
			buildingCode = 3;
			bus = "B bus";
			subject = "Physics";
		}
		if (selectClass == 10) {
			building = "Lipman Hall";
			buildingCode = 2;
			bus = "REXL bus";
			subject = "Psychology";
		}
		if (selectClass == 11) {
			building = "Voorhees Hall";
			buildingCode = 1;
			bus = "LX bus";
			subject = "American History";
		}

		System.out.println("Welcome to Rutgers! "
				+ "You've just made it to Livingston Student Center." 
				+ "\nYou're trying to get to your class. "
				+ "\nMaybe you should look in your backpack and check your schedule..."
				+ "\nTo open your backpack, type '0' and press 'ENTER'. Close your backpack with '9'."
				+ "\n**Don't forget to close your backpack after checking your schedule!**");

		while (gameRunning = true) {
			try {
				Scanner in = new Scanner(System.in);
				action = in.nextInt();
				
				while (action != 0 && backpackOpened == false) {
					System.out.println("Error. Press '0' to look in your backpack first." );
					action = in.nextInt();
				}
				
				backpackOpened = true;
				if (action == 0){
					System.out.println("Backpack: [1] Rutgers ID Card, [2] Laptop, [3] Notebook, [4] Wallet, [5] Phone   **[9] Close backpack**");
				}
					//Interact with items in backpack
					if (action == 1) {
						System.out.println("You looked at your Rutgers ID card. It shows your name...and your slightly awkward photo."); 
					}
	
					if (action == 2) {
						System.out.println("You looked at your laptop. It's almost out of charge.");
					}
	
					if (action == 3) {
						System.out.println("You opened your notebook. Your notes are written in here.");
					}
	
					if (action == 4) {
						System.out.println("You checked your wallet. You have: $15.00");
					}
	
					if (action == 5) {
						System.out.println("You looked at your phone." 
								+ "\nHere's your class schedule: " + arr[selectClass]); 
						checkedSchedule = true;
					}
					if (action == 9 && checkedSchedule == false) {
						System.out.println("You haven't checked your schedule yet.");
					}
					if (action == 9 && checkedSchedule == true) {
						System.out.println("You closed your backpack.");
						break;
					}
					
					
		
			} catch(InputMismatchException e) {
				System.out.println("Error. The input must be an integer");
			}

		}

		// User chooses which bus they want to get on to get to their class

		System.out.println("\nWhich way do you want to go?");
		System.out.println("1: Left, to the LX bus");
		System.out.println("2: Right, to the B bus");
		System.out.println("3: Forward, to the REXL bus");
		System.out.println("4: Stay on Livingston");
		try {
			Scanner in2 = new Scanner(System.in);
			int pickBus = in2.nextInt();

			//If student picks the correct bus
			if (selectClass == 0 && pickBus == 2) {
				System.out.println("2: You got on the B bus.");
				System.out.println("You got off at the " + busch + " stop.");
				destination = busch;
				correctBus = true;
			}

			else if (selectClass == 1 && pickBus == 1) {
				System.out.println("1: You got on the LX bus.");
				System.out.println("You got off at the " + collegeAve + " stop.");
				destination = collegeAve;
				correctBus = true;
			}

			else if (selectClass == 2 && pickBus == 2) {
				System.out.println("2: You got on the B bus.");
				System.out.println("You got off at the " + busch + " stop.");
				destination = busch;
				correctBus = true;
			}

			else if (selectClass == 3 && pickBus == 3) {
				System.out.println("3: You got on the REXL bus.");
				System.out.println("You got off at the " + cook + " stop.");
				destination = cook;
				correctBus = true;
			}

			else if (selectClass == 4 && pickBus == 4)  {
				System.out.println("4: You stayed at the " + livi + " stop.");
				destination = livi;
				correctBus = true;
			}

			else if (selectClass == 5 && pickBus == 4) {
				System.out.println("4: You stayed at the " + livi + " stop.");
				destination = livi;
				correctBus = true;
			}

			else if (selectClass == 6 && pickBus == 1) {
				System.out.println("1: You got on the LX bus.");
				System.out.println("You got off at the " + collegeAve + " stop.");
				destination = collegeAve;
				correctBus = true;
			}

			else if (selectClass == 7 && pickBus == 3) {
				System.out.println("3: You got on the REXL bus.");
				System.out.println("You got off at the " + cook + " stop.");
				destination = cook;
				correctBus = true;
			}

			else if (selectClass == 8 && pickBus == 4) {
				System.out.println("4: You stayed at the " + livi + " stop.");
				destination = livi;
				correctBus = true;
			}

			else if (selectClass == 9 && pickBus == 2) {
				System.out.println("2: You got on the B bus.");
				System.out.println("You got off at the " + busch + " stop.");
				destination = busch;
				correctBus = true;
			}

			else if (selectClass == 10 && pickBus == 3) {
				System.out.println("3: You got on the REXL bus.");
				System.out.println("You got off at the " + cook + " stop.");
				destination = cook;
				correctBus = true;
			}

			else if (selectClass == 11 && pickBus == 1) {
				System.out.println("1: You got on the LX bus.");
				System.out.println("You got off at the " + collegeAve + " stop.");
				destination = collegeAve;
				correctBus = true;

			} 

			else {
				correctBus = false;

			}
		} catch(InputMismatchException e) {
			System.out.println("Error. The input must be an integer");
		}


		while (correctBus == false) {
			try {
				System.out.println("You went the wrong way... You have to wait 5 minutes for the next bus.");
				minsLate  += 5; 
				numDelays ++;

				// User chooses which bus they want to get on to get to their class
				System.out.println("\nTry again to pick the correct bus. Which way do you want to go?");
				System.out.println("1: Left, to the LX bus");
				System.out.println("2: Right, to the B bus");
				System.out.println("3: Forward, to the REXL bus");
				System.out.println("4: Stay on Livingston");

				Scanner in3 = new Scanner(System.in);
				int pickBusRedo = in3.nextInt();

				//If student picks the correct bus

				if (selectClass == 0 && pickBusRedo == 2) {
					System.out.println("2: You got on the B bus.");
					System.out.println("You got off at the " + busch + " stop.");
					destination = busch;
					correctBus = true;
					break;
				}

				if (selectClass == 1 && pickBusRedo == 1) {
					System.out.println("1: You got on the LX bus.");
					System.out.println("You got off at the " + collegeAve + " stop.");
					destination = collegeAve;
					correctBus = true;
					break;
				}

				if (selectClass == 2 && pickBusRedo == 2) {
					System.out.println("2: You got on the B bus.");
					System.out.println("You got off at the " + busch + " stop.");
					destination = busch;
					correctBus = true;
					break;
				}

				if (selectClass == 3 && pickBusRedo == 3) {
					System.out.println("3: You got on the REXL bus.");
					System.out.println("You got off at the " + cook + " stop.");
					destination = cook;
					correctBus = true;
					break;
				}

				if (selectClass == 4 && pickBusRedo == 4)  {
					System.out.println("4: You stayed at the " + livi + " stop.");
					destination = livi;
					correctBus = true;
					break;
				}

				if (selectClass == 5 && pickBusRedo == 4) {
					System.out.println("4: You stayed at the" + livi + " stop.");
					destination = livi;
					correctBus = true;
					break;
				}

				if (selectClass == 6 && pickBusRedo == 1) {
					System.out.println("1: You got on the LX bus.");
					System.out.println("You got off at the " + collegeAve + " stop.");
					destination = collegeAve;
					correctBus = true;
					break;
				}

				if (selectClass == 7 && pickBusRedo == 3) {
					System.out.println("3: You got on the REXL bus.");
					System.out.println("You got off at the " + cook + " stop.");
					destination = cook;
					correctBus = true;
					break;
				}

				if (selectClass == 8 && pickBusRedo == 4) {
					System.out.println("4: You stayed at the " + livi + " stop.");
					destination = livi;
					correctBus = true;
					break;
				}

				if (selectClass == 9 && pickBusRedo == 2) {
					System.out.println("2: You got on the B bus.");
					System.out.println("You got off at the " + busch + " stop.");
					destination = busch;
					correctBus = true;
					break;
				}

				if (selectClass == 10 && pickBusRedo == 3) {
					System.out.println("3: You got on the REXL bus.");
					System.out.println("You got off at the " + cook + " stop.");
					destination = cook;
					correctBus = true;
					break;
				}

				if (selectClass == 11 && pickBusRedo == 1) {
					System.out.println("1: You got on the LX bus.");
					System.out.println("You got off at the " + collegeAve + " stop.");
					destination = collegeAve;
					correctBus = true;
					break;

				} 
				else {
					correctBus = false;

				}
			} catch(InputMismatchException e) {
				System.out.println("Error. The input must be an integer");
			}

		} 



		// User chooses the class they want to go to based on which campus they took a bus to
		System.out.println("\nIt's time to go to class. Which building do you want to go to?");

		while ((destination == livi) || (destination == collegeAve) || (destination == busch) || (destination == cook)){
			try {
				if (destination == livi){
					System.out.println("1: Lucy Stone Hall");
					System.out.println("2: Tillet Hall");
					System.out.println("3: Beck Hall");
				}
				if (destination == collegeAve){
					System.out.println("1: Voorhees Hall");
					System.out.println("2: School of Communications");
					System.out.println("3: Scott Hall");
				}
				if (destination == busch){
					System.out.println("1: SERC");
					System.out.println("2: Hill Center");
					System.out.println("3: Allison Road Classroom Building");
				}

				if (destination == cook){
					System.out.println("1: Bartlett Hall");
					System.out.println("2: Lipman Hall");
					System.out.println("3: Hickman Hall");
				} 

				// Determines whether or not user went to the correct class
				Scanner in3 = new Scanner(System.in);
				int walkToClass = in3.nextInt(); 
				if (walkToClass == buildingCode) {
					System.out.println("You made it to class.");
					break;

					//If student picks the wrong classroom building	
				} else {
					while (walkToClass != buildingCode) {
						System.out.println("You walked to the wrong building. Remember, your schedule said your class was in " + building + ".");
						minsLate  += 2; 
						numDelays++;
						break;
					}
				}
			}catch(InputMismatchException e) {
				System.out.println("Error. The input must be an integer.");
			}
		}

		System.out.println("Congratulations! You just finished your first day of college here at Rutgers!");
		System.out.println("Check the performance.txt file to see how your day was.");

		//PrintWriter to show number of delays, number of minutes late, and locations traveled to in another file.
		PrintWriter out = new PrintWriter(new File ("performance.txt"));

		out.println("Started at Livingston Student Center.");
		out.println("Took " + bus + ".");
		out.println("Went to " + building + ".");
		out.println("Went to " + subject + " class.");
		out.println("Number of delays: " + numDelays);
		out.println("Minutes late: " + minsLate);
		out.close();
	}
}