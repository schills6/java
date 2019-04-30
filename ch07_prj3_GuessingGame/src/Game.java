
public class Game {
	private int theNumber;
	private int numberGuesses;
	
	public Game() {
		theNumber = getRandomNumber();
		numberGuesses=0;
	}
	
	public Game(int theNumber, int numberGuesses) {
		super();
		this.theNumber = theNumber;
		this.numberGuesses = numberGuesses;
	}
	
	public int getTheNumber() {
		return theNumber;
	}

	public void setTheNumber(int theNumber) {
		this.theNumber = theNumber;
	}

	public int getNumberGuesses() {
		return numberGuesses;
	}

	public void setNumberGuesses(int numberGuesses) {
		this.numberGuesses = numberGuesses;
	}

    public static void displayWelcomeMessage() {
        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println();
    }
    
    public static int getRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }
    
    public static void displayPleaseGuessMessage() {
        System.out.println("I'm thinking of a number from 1 to 100.");
        System.out.println("Try to guess it.");
        System.out.println();
    }
    
    public static void displayCorrectGuessMessage(int numberGuesses) {
        System.out.println("You got it in " + numberGuesses + " tries.");
        if (numberGuesses <= 3) {
            System.out.println("Great work! You are a mathematical wizard.\n");
        } else if (numberGuesses > 3 && numberGuesses <= 7) {
            System.out.println("Not too bad! You've got some potential.\n");
        } else {
            System.out.println("What took you so long? Maybe you should take some lessons.\n");
        }
    }
    
    public static void displayGuessAgainMessage(int number, int guessNumber) {
        int difference = guessNumber - number;
        if (guessNumber > number) {
            if (difference > 10) {
                System.out.println("Way too high! Guess again.\n");            
            } else {
                System.out.println("Too high! Guess again.\n");
            }
        } else {
            if (difference < -10) {
                System.out.println("Way too low! Guess again.\n");
            } else {
                System.out.println("Too low! Guess again.\n");
            }
        }
    
     public void incrementNumberOfGuesses() {
    	 numberGuesses ++;
     }
   
    }

}
