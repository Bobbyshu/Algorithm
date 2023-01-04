package Z_MuitiThread.Syn;

public class sellTicket {
    public static void main(String[] args) {
//        sellTicket01 sellTicket01 = new sellTicket01();
//        sellTicket01 sellTicket02 = new sellTicket01();
//        sellTicket01 sellTicket03 = new sellTicket01();
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();
//        sellTicket02 sellTicket02 = new sellTicket02();
//        new Thread(sellTicket02).start();   //first window
//        new Thread(sellTicket02).start();   //second window
//        new Thread(sellTicket02).start();   //third window
        sellTicket03 sellTicket03 = new sellTicket03();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
    }
}

class sellTicket01 extends Thread{
    private static int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("sell out !!!");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("window " + Thread.currentThread().getName() + " sell a ticket "
            + (--ticketNum) + " remain");
        }
    }
}

class sellTicket02 implements Runnable {
    private int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("sell out !!!");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("window " + Thread.currentThread().getName() + " sell a ticket "
                    + (--ticketNum) + " remain");
        }
    }
}

class sellTicket03 implements Runnable {
    private int ticketNum = 100;
    private boolean loop = true;
    public synchronized void m() {
        if (ticketNum <= 0) {
            System.out.println("sell out !!!");
            loop = false;
            return;
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("window " + Thread.currentThread().getName() + " sell a ticket "
                + (--ticketNum) + " remain");
    }
    @Override
    public void run() {
        while (loop) {
            m();
        }
    }
}