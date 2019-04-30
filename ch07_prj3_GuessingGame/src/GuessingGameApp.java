import java.util.Scanner;

public class GuessingGameApp {
    
    public static void main(String[] args) {
        Game.displayWelcomeMessage();

        // create the Scanner object
        Scanner sc = new Scanner(System.in);

        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // generate the random number and invite user to guess it
            int number = Game.getRandomNumber();  
            Game.displayPleaseGuessMessage();

            // continue until the user guesses the number
            int guessNumber = 0;
            int counter = 1;
            Game game = new Game();
            while (guessNumber != number) {
                // get a valid int from user
                guessNumber = Console.getIntWithinRange(sc, "Enter number: ", 0, 101);
                game.incrementNumberOfGuesses();

                // display result of guess to user
                if (guessNumber == game.getTheNumber()) {
                    game.displayCorrectGuessMessage();
                } else {
                    game.displayGuessAgainMessage(guessNumber);
                }
            }

            // see if the user wants to continue
            choice = getChoiceString(sc, "Try again? (y/n): ", "y", "n");
            System.out.println();
        }
        System.out.println("Bye - Come back soon!");
        System.out.println();
    }
}