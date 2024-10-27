package guessGame;//import java.util.random.RandomGenerator;
import java.util.Random;
public class NumberGuess {
        Random randomInteger = new Random();

        /*// generating the random number between 0 and 100*/

        int random = randomInteger.nextInt(100);

    public int guess(int num){
            if( random > num){
                return 1;
            } else if (random < num){
                return -1;
            }else
            return 0;
        }

    }