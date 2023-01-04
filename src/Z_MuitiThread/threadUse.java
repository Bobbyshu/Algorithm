package Z_MuitiThread;

public class threadUse {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();
    }
}

class Cat extends Thread {
    int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("喵喵喵, 我是小猫咪" + (++times));
            //ctrl+alt+t
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (times == 10) {
                break;
            }
        }
    }
}
