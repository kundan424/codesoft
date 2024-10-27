package ATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("ENTER YOUR PIN");
        Scanner sc = new Scanner(System.in);
        int pin = sc.nextInt();
        AtmInterface obj = new AtmInterface(pin);

    }
}
