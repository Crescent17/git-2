public class Dodge implements Runnable {
    private int speed;

    public Dodge() {
        this.speed = 100 + (int) (Math.random() * 60);
    }

    @Override
    public synchronized void run() {
        Thread.currentThread().setName("Dodge");
        System.out.println("Dodge is ready to start a race...\n");
        Race.getCountDownLatch().countDown();
        try {
            Race.getCountDownLatch().await();
            Thread.sleep(Race.getTrackLength() / this.speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Dodge has finished the race!\n");
        Race.setWinner(Thread.currentThread().getName());
    }
}
