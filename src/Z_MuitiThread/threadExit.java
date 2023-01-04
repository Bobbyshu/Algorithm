package Z_MuitiThread;

public class threadExit {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();
        Thread.sleep(10000);
        t1.setLoop(false);
    }
}

class T extends Thread {
    //set a control variable
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("T is running !!!");
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
