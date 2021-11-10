public class Toyota implements Runnable {
    private int speed;

    public Toyota() {
        this.speed = 90 + (int) (Math.random() * 60);
    }

    @Override
    public synchronized void run() {
        Thread.currentThread().setName("Toyota");
        System.out.println("Toyota is ready to start a race...\n");
        Race.getCountDownLatch().countDown();
        try {
            Race.getCountDownLatch().await();
            Thread.sleep(Race.getTrackLength() / this.speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Toyota has finished the race!\n");
        Race.setWinner(Thread.currentThread().getName());
    }
}
