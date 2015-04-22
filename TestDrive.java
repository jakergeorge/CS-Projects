package jacob_george;
import java.util.*;

/**
 * This class creates a new moped object and allows the user to enter commands to manipulate that moped
 * @author Jacob George
 * @version 1.0
 */
public class TestDrive {

	/**
	 * Main method which creates a new moped and accepts user commands that act on that moped
	 * @param args A string array of arguments passed to the method
	 */
	public static void main(String[] args){
		//Create a new moped
		Moped vespa = new Moped();
		//create a new scanner
		Scanner input = new Scanner(System.in);
		//string variable to store command
		String command;

		System.out.println("Please enter a command:");
		
		//While there is still gas in the moped and it is not parked, get next command
		while(vespa.getGas() > 0 && !(vespa.isParked()))
		{
			command = input.nextLine();
			switch (command){
			case "back up": vespa.backUp();
							break;
			case "go left": vespa.goLeft();
							break;
			case "go right": vespa.goRight();
							break;
			case "straight on": vespa.goForward();
							break;
			case "fill 'er up": vespa.fillTank();
							break;
			case "how we doin'?": ;
			case "how we doin": vespa.checkGas(); 
							break;
			case "park": vespa.park();
							break;
			case "go to Petite Abeille": vespa.goToPetiteAbeille();
							break;
			case "help": vespa.help();
							break;
			default: System.out.println("Command not recognized. If you need help please enter 'help'.");
			}
		}
		//If the moped is parked display message
		if(vespa.isParked()){
			System.out.println("You parked the moped!");
		}
		
		//If the moped ran out of gas display message
		if(vespa.getGas() == 0){
			System.out.println("You ran out of gas!");
		}
		System.out.println("Program ended.");
		input.close();
	}

}
