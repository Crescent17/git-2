public class Honda implements Runnable {
    private int speed;

    public Honda() {
        this.speed = 100 + (int) (Math.random() * 60);
    }

    @Override
    public synchronized void run() {
        Thread.currentThread().setName("Honda");
        System.out.println("Honda is ready to start a race...\n");
        Race.getCountDownLatch().countDown();
        try {
            Race.getCountDownLatch().await();
            Thread.sleep(Race.getTrackLength() / this.speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Honda has finished the race!\n");
        Race.setWinner(Thread.currentThread().getName());
    }
}
