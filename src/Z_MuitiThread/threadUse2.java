package Z_MuitiThread;

public class threadUse2 {
    public static void main(String[] args) {
//        Dog dog = new Dog();
//        Thread thread = new Thread(dog);
//        thread.start();
    }
}

//代理模式，模拟了极简的thread类
class threadProxy implements Runnable {
    private Runnable target = null;

    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }

    public threadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();//this way is the way that realize multi-thread(in source code)
    }

    public void start0() {
        run();
    }
}

class Dog implements Runnable {
    int cnt = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("dog wang wang bark..." + (++cnt) + Thread.currentThread().getName());
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
