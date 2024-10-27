package ATM;

import java.util.Scanner;
public class AtmInterface {
    int pin;
    float Balance;

    public AtmInterface(int enteredPin) {
        this.pin = enteredPin;
        if (pin == 8976) {
            menu();
        } else
            System.out.println("please! enter the correct pin ");
    }

    public void menu() {
        System.out.println("Enter your choice");
        System.out.println(" 1. Check Balance");
        System.out.println("2. deposit amount");
        System.out.println("3. withdraw amount");
        System.out.println("4. EXIT ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                checkbalance();
                break;
            case 2:
                depositeAmount();
                break;
            case 3:
                wihtdrawAmount();
                break;
            case 4:
                break;

        }
    }

    public void checkbalance() {
        System.out.println("Your current balance is:" + Balance);
        System.out.println();
        menu();
    }

    public void depositeAmount() {
        System.out.println("Enter the amount you want to deposit");
        Scanner scanner = new Scanner(System.in);
        float deposited = scanner.nextFloat();
        Balance += deposited;
        System.out.println("Amount deposited successfully ");
        System.out.println();
        menu();
    }

    public void wihtdrawAmount() {
        System.out.println(" Enter the amount you want to withdraw ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (Balance < amount) {
            System.out.println("Insufficient Balance");
        } else {
            Balance = Balance - amount;
            System.out.println("Amount withdrawal successfully ");
        }
        System.out.println();
        menu();
    }
}

