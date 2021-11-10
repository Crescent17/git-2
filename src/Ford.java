public class Ford implements Runnable {
    private int speed;

    public Ford() {
        this.speed = 80 + (int) (Math.random() * 60);
    }

    @Override
    public synchronized void run() {
        Thread.currentThread().setName("Ford");
        System.out.println("Ford is ready to start a race...\n");
        Race.getCountDownLatch().countDown();
        try {
            Race.getCountDownLatch().await();
            Thread.sleep(Race.getTrackLength() / this.speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ford has finished the race!\n");
        Race.setWinner(Thread.currentThread().getName());
    }
}
