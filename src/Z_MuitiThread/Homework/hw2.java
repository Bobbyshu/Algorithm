package Z_MuitiThread.Homework;

public class hw2 {
    public static void main(String[] args) {
        T t1 = new T();

        Thread thread1 = new Thread(t1);
        thread1.setName("t1");
        Thread thread2 = new Thread(t1);
        thread2.setName("t2");
        thread1.start();
        thread2.start();
    }
}

class T implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("balance isn't enough");
                    break;
                }

                money -= 1000;
                System.out.println(Thread.currentThread().getName() + " withdrew 1000 and cur balance is " + money);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
