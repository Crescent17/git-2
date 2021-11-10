import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerOne {
    private static int numberOfWins = 0;
    private static int numberOfLoses = 0;
    private static double balance = 1000;
    private static String selectedCar = null;
    private static int bet;

    public static double getBalance() {
        return balance;
    }

    public static void refreshBalance(double multiplier) {
        balance = balance + bet * multiplier;
    }


    public static String firstPlayerGetSelectedCar() {
        return selectedCar;
    }

    public static void makeBet() {
        double startingBalance = balance;
        boolean confirmation = false;
        while (confirmation == false) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("First player, choose the car: Volkswagen, Honda, Dodge, Toyota, Ford");
            selectedCar = scanner.next().toLowerCase();
            if (selectedCar.equals("volkswagen") || selectedCar.equals("honda") || selectedCar.equals("dodge") ||
                    selectedCar.equals("toyota") || selectedCar.equals("ford")) {
                switch (selectedCar) {
                    case ("volkswagen"):
                        Race.setMultiplier(3.11);
                    case ("honda"):
                        Race.setMultiplier(1.86);
                    case ("dodge"):
                        Race.setMultiplier(1.79);
                    case ("toyota"):
                        Race.setMultiplier(2.57);
                    case ("ford"):
                        Race.setMultiplier(3.08);
                }
            } else {
                System.out.println("Unknown car, please try again.");
                continue;
            }
            System.out.print("First player, make your bet (available balance - " + balance + "): ");
            bet = 0;
            while (bet == 0) {
                try {
                    bet = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("It's not a number. Try again.");
                    scanner.nextLine();
                }
            }
            if (bet <= balance) {
                balance = balance - bet;
                System.out.println("Potential reward is " + bet * Race.getMultiplier());
                System.out.println("Are you sure you want to place a bet? Y/N");
            } else {
                System.out.println("Not enough money");
                continue;
            }
            String agreement;
            while (true) {
                agreement = scanner.next().toLowerCase();
                if (agreement.equals("y")) {
                    confirmation = true;
                    break;
                }
                if (agreement.equals("n")) {
                    balance = startingBalance;
                    break;
                } else {
                    System.out.println("Sorry, unknown command. Try again.");
                }
            }
        }
    }

    public static void increaseNumberOfWins() {
        numberOfWins++;
    }

    public static void increaseNumberOfLoses() {
        numberOfLoses++;
    }

    public static void getStats() {
        System.out.println("Player one number of wins: " + numberOfWins + "\n" +
                "Number of loses: " + numberOfLoses + "\nBalance: " + getBalance());
    }
}