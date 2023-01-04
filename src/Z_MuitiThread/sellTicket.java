package Z_MuitiThread;

public class sellTicket {
    public static void main(String[] args) {
//        sellTicket01 sellTicket01 = new sellTicket01();
//        sellTicket01 sellTicket02 = new sellTicket01();
//        sellTicket01 sellTicket03 = new sellTicket01();
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();
        sellTicket02 sellTicket02 = new sellTicket02();
        new Thread(sellTicket02).start();   //first window
        new Thread(sellTicket02).start();   //second window
        new Thread(sellTicket02).start();   //third window
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