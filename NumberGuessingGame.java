import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        int numGuesses = 0;
        int guess = 0;
        
        System.out.println("Welcome to the number guessing game!");
        System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");
        
        while (guess != secretNumber) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            numGuesses++;
            
            if (guess < secretNumber) {
                System.out.println("Too low. Guess again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high. Guess again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + numGuesses + " guesses.");
            }
        }
        
        scanner.close();
    }
}
