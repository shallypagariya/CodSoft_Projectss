import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playing = true;
        int totalRounds = 0;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playing) {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean correctGuess = false;
            int maxAttempts = 10; 

            System.out.println("I have generated a random number between 1 and 100. Try to guess it!");

            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    correctGuess = true;
                    totalScore += (maxAttempts - attempts + 1); 
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!correctGuess) {
                System.out.println("You've used all attempts. The correct number was " + randomNumber + ".");
            }

            totalRounds++;
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                playing = false;
            }
        }

        System.out.println("Game Over! You played " + totalRounds + " rounds with a total score of " + totalScore + ".");
        scanner.close();
    }
}
