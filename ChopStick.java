import java.util.concurrent.Semaphore;

public class ChopStick {
    public Semaphore chop = new Semaphore(1);
    public int no;

    ChopStick(int no)
    {
        this.no=no;
    }
    public ChopStick()
    {

    }
    public int getNo()
    {
        return no;
    }
    public boolean take()
    {
        return chop.tryAcquire();
    }
    public void down()
    {
        chop.release();
    }
}
