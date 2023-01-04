package Z_MuitiThread;

public class thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread.start();
        thread2.start();
    }
}

class T1 implements Runnable {
    int cnt = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello world "+ (++cnt));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (cnt == 10)
                break;
        }
    }
}

class T2 implements Runnable {
    int cnt = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hi hi hi " + (++cnt));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (cnt == 5)
                break;
        }
    }
}
