package guessGame;//import java.util.random.RandomGenerator;
import java.util.Random;
public class NumberGuess {
        Random randomInteger = new Random();

        /*// generating the random number between 0 and 100*/

        int random = randomInteger.nextInt(100);
//        System.out.println("random number: " + random);

        // guess the generated number
//        System.out.println("Enter the number:");
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();

    public int guess(int num){
            if( random > num){
                return 1;
            } else if (random < num){
                return -1;
            }else
            return 0;
        }

    }