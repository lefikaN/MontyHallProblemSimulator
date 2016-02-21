import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallProblem {

	public static void main(String[] args) {
		
		boolean alwaysChange = true;//Set this to either true or false
		simulateMontyHall(10000, alwaysChange);
		
	}

	private static void simulateMontyHall(final int numberOfTries, boolean changeChoice) {
		int changedChoice = 0;
		int unchangedChoice = 0;
		for (int i = 1; i < numberOfTries; i++) {
			Map<Integer, String> doors = new HashMap<>();
			doors.put(1, "door1");
			doors.put(2, "door2");
			doors.put(3, "door3");
			
			//Place car behind door - set the seen
			int carPosition = generateRandomNumberInRange(1, 3);
			
			//Contestant first choice
			int initialChoice = generateRandomNumberInRange(1, 3);
			
			/*
			 * Reveal one of the doors that do not have the car,
			 * this is based on the fact that we ALWAYS reveal a goat, whether or not you chose to switch.
			 */			
			doors.remove(revealGoat(1, 3, carPosition));
			
			
			for (Map.Entry<Integer, String> entry: doors.entrySet()){
				if (changeChoice){
					int newChoice = generateRandomNumberInRange(1, 3);
					if (newChoice == carPosition){
						changedChoice++;
					}
				}else{
					if (initialChoice == carPosition){
						unchangedChoice++;
					}
				}
			}
			
		}
		
		if (changeChoice){
			System.out.println("This similation depicts the results of a contestant that changed his choice");
			System.out.println("Wins probability ratio:  " + new BigDecimal(changedChoice).divide(new BigDecimal(numberOfTries)));
		}else{
			System.out.println("This similation depicts the results of a contestant that DID NOT changed his choice");
			System.out.println("Wins probability ratio:  " + new BigDecimal(unchangedChoice).divide(new BigDecimal(numberOfTries)));
		}
		
	}

	private static int generateRandomNumberInRange(int min, int max) {
		Random carPositionRandomSeed = new Random();
		return carPositionRandomSeed.nextInt((max - min) + 1) + min;
	}
	
	private static int revealGoat(int min, int max, int carPosition){
		int goatPosition = generateRandomNumberInRange(min, max);
		return goatPosition == carPosition ? revealGoat(min, max, carPosition) : goatPosition;
	}

}
