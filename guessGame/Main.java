package guessGame;

import java.util.Scanner;

public class Main extends NumberGuess {
    public static void main(String[] args) {
        NumberGuess n = new NumberGuess();
        System.out.println(" Guess the number between 0 and 100 ");
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (count < 10) {
            int number = scanner.nextInt();
            int result = n.guess(number);
            if (result == 0) {
                System.out.println("Yay! you guessed the correct number");
                break;
            }
            if (result == 1) {
                System.out.println(" your guess is too low , try again!");
            } else
                System.out.println("your guess is too High ,try again!");
            count++;
            System.out.println("This is your "+ count + " attempt");
            System.out.println("you have only " + (10-count) +" attempt remaining" );
        }
        scanner.close();
    }
}
