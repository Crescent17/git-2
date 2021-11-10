public class Results {
    public static void getRaceResults() {
        if (PlayerOne.firstPlayerGetSelectedCar().equals(Race.getWinner().toLowerCase())) {
            System.out.println("Player one, congratulations! You've won!");
            PlayerOne.increaseNumberOfWins();
            PlayerOne.refreshBalance(Race.getMultiplier());
        } else {
            System.out.println("Player one, you've lost :(");
            PlayerOne.increaseNumberOfLoses();
        }
        if (PlayerTwo.secondPlayerGetSelectedCar().equals(Race.getWinner().toLowerCase())) {
            System.out.println("Player two, congratulations! You've won!");
            PlayerTwo.increaseNumberOfWins();
            PlayerTwo.refreshBalance(Race.getMultiplier());
        } else {
            System.out.println("Player two, you've lost :(");
            PlayerTwo.increaseNumberOfLoses();
        }
        PlayerOne.getStats();
        PlayerTwo.getStats();
    }
}
