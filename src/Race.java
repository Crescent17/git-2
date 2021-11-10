import java.util.concurrent.CountDownLatch;

public class Race {
    private static CountDownLatch countDownLatch = new CountDownLatch(5);
    private static final int trackLength = 500000;
    private static String winner = null;
    private static double multiplier = 0.0;

    public static void startRace() throws InterruptedException {
        winner = null;
        countDownLatch = new CountDownLatch(5);
        new Thread(new Volkswagen()).start();
        Thread.sleep(2000);
        new Thread(new Honda()).start();
        Thread.sleep(2000);
        new Thread(new Dodge()).start();
        Thread.sleep(2000);
        new Thread(new Toyota()).start();
        Thread.sleep(2000);
        new Thread(new Ford()).start();
    }

    public static CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public static int getTrackLength() {
        return trackLength;
    }

    public static void setWinner(String car) {
        if (winner == null) {
            winner = car;
        }
    }

    public static String getWinner() {
        return winner;
    }

    public static void setMultiplier(double carMultiplier) {
        multiplier = carMultiplier;
    }

    public static double getMultiplier() {
        return multiplier;
    }
}
