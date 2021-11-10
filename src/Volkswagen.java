public class Volkswagen implements Runnable {
    private int speed;

    public Volkswagen() {
        this.speed = 80 + (int) (Math.random() * 60);
    }

    @Override
    public synchronized void run() {
        Thread.currentThread().setName("Volkswagen");
        System.out.println("Volkswagen is ready to start a race...\n");
        Race.getCountDownLatch().countDown();
        try {
            Race.getCountDownLatch().await();
            Thread.sleep(Race.getTrackLength() / this.speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Volkswagen has finished the race!\n");
        Race.setWinner(Thread.currentThread().getName());
    }
}
