package Z_MuitiThread.ThreadMethod;

public class threadJoin {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();
        for (int i = 1; i <= 20; ++i) {
            Thread.sleep(1000);
            System.out.println("MainThread is eating " + i + " baozi");
            if (i == 5) {
                System.out.println("<<<<<<<MainThread let SubThread eat first>>>>>>>");
                t2.join();
                System.out.println("<<<<<<<SubThread has eaten, let Main continue eating>>>>>>>");
            }
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; ++i) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("SubThread is eating " + i + " baozi");
        }
    }
}
