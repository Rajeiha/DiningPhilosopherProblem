public class Philosopher extends Thread {
    private ChopStick chop_left;
    private ChopStick chop_right;

    Philosopher(ChopStick chop_left,ChopStick chop_right)
    {
        this.chop_left = chop_left;
        this.chop_right = chop_right;
    }

    private void Action(String action) throws InterruptedException
    {
        System.out.println(Thread.currentThread().getName() + "  " + action);
        Thread.sleep(((int)(Math.random()*100)));
    }
    public void run() {
        try {
            while (true) {

                // thinking
                Action(System.nanoTime() + ": Thinking");
                synchronized (chop_left) {
                    Action(System.nanoTime() + ": Picked up left fork");
                    synchronized (chop_right) {
                        // eating
                        Action(System.nanoTime() + ": Picked up right fork - eating");

                        Action(System.nanoTime() + ": Put down right fork");
                    }

                    // Back to thinking
                    Action(
                            System.nanoTime()
                                    + ": Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
