package jacob_george;

/**
 * This class models a real Moped in code. It contains all of the attributes and actions necessary to operate a moped in a "grid" city.
 * @author Jacob George
 * @version 1.0
 */
public class Moped {
	/**
	 * Integer between 1 and 200 that indicates the street the moped is located
	 */
	private int street;
	
	/**
	 * Integer between 1 and 10 that represents the avenue the moped is located,
	 */
	private int avenue;
	
	/**
	 * String to store the moped's orientation
	 */
	private String direction;
	
	/**
	 * Boolean to determine whether the moped is parked or not, true for parked and false otherwise
	 */
	private boolean isParked;
	
	/**
	 * Integer representing the amount of gas in the moped as a percentage
	 */
	private int gas;
	
	/**
	 * Constructor for moped that sets it's default street, avenue, isParked, gas, and direction values
	 */
	public Moped(){
		//Start at 10th St and 5th Ave
		this.street = 10;
		this.avenue = 5;
		//Moped is not parked
		this.isParked = false;
		//Gas tank is full
		this.gas = 100;
		//Moped is facing south
		this.direction = "South";
	}
		
	/**
	 * Getter method for the isParked property
	 * @return true if parked, false otherwise
	 */
	public boolean isParked(){
		return this.isParked;
	}
	
	/**
	 * Getter method for the gas property
	 * @return an integer representing the amount of gas left in the moped as a percentage of full capacity
	 */
	public int getGas(){
		return this.gas;
	}
	
	/**
	 * Automatically drives moped from current location to Petite Abeille
	 */
	public void goToPetiteAbeille(){
		//If the current street location is greater than 17, move one block south until you reach 17th street
		if(this.street > 17){
			while(this.street > 17 && this.gas > 0){
				this.street --;
				this.useGas();
				System.out.println("Heading South...");	
				this.printLocation();
			}
		}
		//If the current street location is less than 17, move one block north until you reach 17th street
		else if(this.street < 17){
			while(this.street < 17 && this.gas > 0){
				this.street++;
				this.useGas();
				System.out.println("Heading North...");
				this.printLocation();
				
			}
		}
		//If the current avenue location is greater than 6, move one block east until you reach 6th avenue
		if(this.avenue > 6){
			while(this.avenue > 6 && this.gas > 0){
				this.avenue--;
				this.useGas();
				System.out.println("Heading East...");
				this.printLocation();
				
			}
			this.direction = "East";
		}
		//If the current avenue location is less than 6, move one block west until you reach 6th avenue
		else if(this.avenue < 6){
			while(this.avenue < 6 && this.gas > 0){
				this.avenue++;
				this.useGas();
				System.out.println("Heading West...");
				this.printLocation();
				
			}
			this.direction = "West";
		}
		//If you reached the restaurant, print out that you arrived at the restaurant
		if(this.avenue == 6 && this.street == 17){
			System.out.println("You arrived at Petite Abeille! Eat some mussels from Brussels!");
		}
	}
	
	/**
	 * Setter method for the isParked property. Sets it to true.
	 */
	public void park(){
		this.isParked = true;
	}

	/**
	 * Setter method for the gas property. Sets gas to 100.
	 */
	public void fillTank(){
		this.gas = 100;
		System.out.println("The tank is now full!");
	}

	/**
	 * Decrements gas by 5 percent
	 */
	private void useGas(){
		this.gas -= 5;
	}
	
	/**
	 * Displays the amount of gas in the tank as a percentage
	 */
	public void checkGas(){
		System.out.println("The gas tank is " + this.gas + "% full");
	}
	
	/**
	 * Checks to see if the street and avenue the user is attempting to travel to is in the bounds of the city
	 * @param checkStreet An integer representing the street number the user is trying to travel to
	 * @param checkAve An integer representing the avenue number the user is trying to travel to
	 * @return true if the steet and avenue are in the bounds of the city, false otherwise
	 */
	private boolean isInCity(int checkStreet, int checkAve){
		//If the upcoming street is greater than 0 and less than or equal to 200 and the upcoming avenue is less than or equal to 10 and greater than 0 return true so the moped will move
		if(checkStreet > 0 && checkStreet <= 200 && checkAve > 0 && checkAve <= 10){
			return true;
		}
		//Otherwise return false, so the moped does not move to that location
		else{
			return false;
		}
	}
	
	/**
	 * If the user is trying to go to a location that is out of the bounds of the city this method outputs a message that they need to pick another direction 
	 */
	private void outOfBounds(){
		//Tell the user that they are trying to go out of bounds and must choose a different direction
		System.out.println("Going that direction will take you out of the city, please choose a different direction!");
	}

	/**
	 * Checks to see if the user is at a location where and ad should be displayed and if they are it displays an ad
	 */
	private void checkForAd(){
		//At 79th St and 8th Ave, show an ad for the Natural History Museum
		if(this.street == 79 && this.avenue == 8){
			System.out.println("Come visit the Museum of Natural History, we have a great gift shop!");
		}
		//At 74th and 1st Ave, show an ad for Memorial Sloan Kettering
		if(this.street == 74 && this.avenue == 1){
			System.out.println("Did you know Memorial Sloan Kettering Cancer Center has been curing cancer for over 130 years? Now you do!");
		}
		//At 12th st and 4th ave show an ad for The Strand
		if(this.street == 12 && this.avenue == 4){
			System.out.println("BUY LOCAL, GET ALL YOUR BOOKS AT THE STRAND!");
		}
		//At 3rd st and 6th ave show an ad for coffee
		if(this.street == 3 && this.avenue == 6){
			System.out.println("Fay Da Cafe has the finest Apricot Cookies in all the land! BUY THEM!");
		}
	}
	
	/**
	 * Moves the moped forward one block in the direction the moped is currently facing
	 */
	public void goForward(){
		//If you are traveling south and the next street is in bounds, decrease the street number by 1
		if(this.direction.equals("South")){
			int checkStreet = street - 1;
			int checkAve = avenue;
			if(isInCity(checkStreet,checkAve)){
				this.street--;
				this.useGas();
				printLocation();
				
			}
			else{
				this.outOfBounds();
			}
		}
		//If you are traveling north and the next street is in bounds, increase the street number by 1
		else if(this.direction.equals("North")){
			int checkStreet = this.street + 1;
			int checkAve = this.avenue;
			if(isInCity(checkStreet,checkAve)){
				this.street++;
				useGas();
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
		//If you are traveling west and the next avenue is in bounds, increase the avenue number by 1
		else if(this.direction.equals("West")){
			int checkStreet = this.street;
			int checkAve = this.avenue + 1;
			if(isInCity(checkStreet,checkAve)){
				this.avenue++;
				useGas();
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
		//If you are traveling east and the next avenue is in bounds, decrease the avenue number by 1
		else if(this.direction.equals("East")){
			int checkStreet = this.street;
			int checkAve = this.avenue - 1;
			if(isInCity(checkStreet,checkAve)){
				this.avenue--;
				useGas();
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
		
	}
	
	/**
	 * Moves the user one block in the opposite direction the Moped is facing
	 */
	public void backUp(){
		//If you are traveling south and the next street is in bounds, increase the street number by 1
		if(this.direction.equals("South")){
			int checkStreet = this.street + 1;
			int checkAve = this.avenue;
			if(isInCity(checkStreet,checkAve)){
				this.street++;
				useGas();
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
		//If you are traveling north and the next street is in bounds, decrease the street number by 1
		else if(this.direction.equals("North")){
			int checkStreet = this.street - 1;
			int checkAve = this.avenue;
			if(isInCity(checkStreet,checkAve)){
				this.street--;
				useGas();
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
		//If you are traveling West and the next avenue is in bounds, decrease the avenue number by 1
		else if(this.direction.equals("West")){
			int checkStreet = this.street;
			int checkAve = this.avenue - 1;
			if(isInCity(checkStreet,checkAve)){
				this.avenue--;
				useGas();
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
		//If you are traveling East and the next avenue is in bounds, increase the avenue number by 1
		else if(this.direction.equals("East")){
			int checkStreet = this.street;
			int checkAve = this.avenue + 1;
			if(isInCity(checkStreet,checkAve)){
				this.avenue++;
				useGas();
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
		
	}
	
	/**
	 *Moves the moped one block to the left
	 */
	public void goLeft(){
		//If you are traveling South and the next avenue is in bounds, decrease the avenue number by 1 and change direction to East
		if(this.direction.equals("South")){
			int checkStreet = this.street;
			int checkAve = this.avenue - 1;
			if(isInCity(checkStreet,checkAve)){
				this.avenue--;
				useGas();
				this.direction = "East";
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
		//If you are traveling north and the next avenue is in bounds, increase the avenue number by 1 and change direction to West
		else if(this.direction.equals("North")){
			int checkStreet = this.street;
			int checkAve = this.avenue + 1;
			if(isInCity(checkStreet,checkAve)){
				this.avenue++;
				useGas();
				this.direction = "West";
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
		//If you are traveling east and the next street is in bounds, increase the street number by 1 and change direction to North
		else if(this.direction.equals("East")){
			int checkStreet = this.street + 1;
			int checkAve = this.avenue;
			if(isInCity(checkStreet,checkAve)){
				this.street++;
				useGas();
				this.direction = "North";
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
		//If you are traveling West and the next street is in bounds, decrease the street number by 1 and change direction to South
		else if(this.direction.equals("West")){
			int checkStreet = this.street - 1;
			int checkAve = this.avenue;
			if(isInCity(checkStreet,checkAve)){
				this.street--;
				useGas();
				this.direction = "South";
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
	}
	
	/**
	 * Moves the moped one block to the right
	 */
	public void goRight(){
		//If you are traveling South and the next avenue is in bounds, decrease the street number by 1 and change direction to West
		if(this.direction.equals("South")){
			int checkStreet = this.street;
			int checkAve = this.avenue + 1;
			if(isInCity(checkStreet,checkAve)){
				this.avenue++;
				useGas();
				this.direction = "West";
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
		//If you are traveling north and the next avenue is in bounds, decrease the street number by 1 and change direction to East
		else if(this.direction.equals("North")){
			int checkStreet = this.street;
			int checkAve = this.avenue - 1;
			if(isInCity(checkStreet,checkAve)){
				this.avenue--;
				useGas();
				this.direction = "East";
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
		//If you are traveling West and the next street is in bounds, increase the street number by 1 and change direction to north
		else if(this.direction.equals("West")){
			int checkStreet = this.street + 1;
			int checkAve = this.avenue;
			if(isInCity(checkStreet,checkAve)){
				this.street++;
				useGas();
				this.direction = "North";
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
		//If you are traveling East and the next street is in bounds, decrease the street number by 1 and change direction to south
		else if(this.direction.equals("East")){
			int checkStreet = this.street - 1;
			int checkAve = this.avenue;
			if(isInCity(checkStreet,checkAve)){
				this.street--;
				useGas();
				this.direction = "South";
				printLocation();
				
			}
			else{
				outOfBounds();
			}
		}
	}
	
	/**
	 * Prints the current location of the moped and calls the checkAd method to determine if an ad should be displayed
	 */
	private void printLocation(){
		String streetName;
		String avenueName;
		
		//Convert street to ordinal
		if((this.street % 10) == 1 && (this.street % 100) != 11) {
			streetName = street + "st";
		} 
		else if((this.street % 10) == 2 && (this.street % 100) != 12) {
		    streetName = street + "nd";
		} 
		else if((this.street % 10) == 3 && (this.street % 100) != 13) {
		    streetName = street + "rd";
		} 
		else {
			streetName = street + "th";
		}
		
		
		//Convert avenue to ordinal
		if((this.avenue % 10) == 1 && (this.avenue % 100) != 11) {
			avenueName = avenue + "st";
		} 
		else if((this.avenue % 10) == 2 && (this.avenue % 100) != 12) {
		    avenueName = avenue + "nd";
		} 
		else if((this.avenue % 10) == 3 && (this.avenue % 100) != 13) {
		    avenueName = avenue + "rd";
		} 
		else {
			avenueName = avenue + "th";
		}
		
	    
		System.out.print("Now at " + streetName + " St. and " + avenueName + " Ave. ");
		checkForAd();
		System.out.println();
	}
	
	/**
	 * Displays all of the commands this program accepts
	 */
	public void help(){
		System.out.println("This program accepts the following commands:");
		System.out.println("go left: drive one block to the left of current location");
		System.out.println("go right: drive one block right of current location");
		System.out.println("straight on: drive one block forward");
		System.out.println("back up: drive one block backward");
		System.out.println("how we doin'?: displays amount of gas left in tank");
		System.out.println("fill 'er up: refill gas tank to 100%");
		System.out.println("park: park the moped and exit the program");
		System.out.println("go to Petite Abeille: drive on autopilot to Petite Abeille");
		System.out.println("help: displays this help menu");
	}
}

