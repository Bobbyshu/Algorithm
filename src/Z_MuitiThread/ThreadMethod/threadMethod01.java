package Z_MuitiThread.ThreadMethod;

public class threadMethod01 {
}
class ThreadDemo01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
