package Z_MuitiThread.Syn;

public class deadLock {
    public static void main(String[] args) {
        DeadLockDemo A = new DeadLockDemo(true);
        DeadLockDemo B = new DeadLockDemo(false);
        A.start();
        B.start();
    }
}

class DeadLockDemo extends Thread {
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + " enter 1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " enter 2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " enter 3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " enter 4");
                }
            }
        }
    }
}
