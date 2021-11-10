import java.util.Scanner;

public class Game {
    public static void startGame() {
        boolean game = false;
        String option;
        System.out.println("To start the game, type \"START\", to read information, type \"HELP\"" +
                " to exit, type \"EXIT\" ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            option = scanner.next().toLowerCase();
            if (option.equals("start")) {
                game = true;
                break;
            }
            if (option.equals("exit")) {
                break;
            }
            if (option.equals("help")) {
                System.out.println("The main task of the game is to compete with each other,\nto make bets on different" +
                        " cars which have different possibilities of winning.\nThe first player who reaches the goal of" +
                        " 10000 wins the game.\nWish you the best of luck!");
            } else System.out.println("Sorry, unknown command. Try again.");
        }
        while (game) {
            PlayerOne.makeBet();
            PlayerTwo.makeBet();
            try {
                Race.startRace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            while (Race.getWinner() == null) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println(Race.getWinner());
            Results.getRaceResults();
            if (PlayerOne.getBalance() >= 10000 || PlayerTwo.getBalance() >= 10000) {
                if (PlayerOne.getBalance() > PlayerTwo.getBalance()) {
                    System.out.println("Game over! The winner is player number one");
                } else if (PlayerOne.getBalance() < PlayerTwo.getBalance()) {
                    System.out.println("Game over! The winner is player number two");
                } else {
                    System.out.println("Game over! It's draw");
                }
                break;
            }
            if (PlayerOne.getBalance() == 0 || PlayerTwo.getBalance() == 0) {
                if (PlayerOne.getBalance() > PlayerTwo.getBalance()) {
                    System.out.println("Game over! The winner is player number one");
                    break;
                } else if (PlayerOne.getBalance() < PlayerTwo.getBalance()) {
                    System.out.println("Game over! The winner is player number two");
                    break;
                } else {
                    System.out.println("Game over! It's draw");
                    break;
                }
            }
            System.out.println("To continue - \"CONTINUE\", to exit \"EXIT\"");
            while (true) {
                option = scanner.next().toLowerCase();
                if (option.equals("continue")) {
                    break;
                }
                if (option.equals("exit")) {
                    game = false;
                    break;
                } else {
                    System.out.println("Unknown command. Please try again");
                    break;
                }
            }
        }
        System.out.println("See you later!");
    }
}
