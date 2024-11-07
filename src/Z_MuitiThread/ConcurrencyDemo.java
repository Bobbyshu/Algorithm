package Z_MuitiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PMutex {
  private final Lock lock = new ReentrantLock();

  public void lock() {
//    System.out.println(Thread.currentThread().getName() + " locking...");
    lock.lock();
//    System.out.println(Thread.currentThread().getName() + " locked.");
  }

  public void unlock() {
//    System.out.println(Thread.currentThread().getName() + " unlocking...");
    lock.unlock();
//    System.out.println(Thread.currentThread().getName() + " unlocked.");
  }

  public Lock getLock() {
    return lock;
  }
}

class Rendezvous {
  private final PMutex pMutex = new PMutex();
  private final Condition condition = pMutex.getLock().newCondition();
  private int count = 0;

  public void meetup() {
    pMutex.lock();
    try {
      count++;
      System.out.println(Thread.currentThread().getName() + " entered meetup, count = " + count);

      // Wait if count < 2
      while (count < 2) {
        System.out.println(Thread.currentThread().getName() + " waiting...");
        condition.await(); // Releases the lock and waits
        System.out.println(Thread.currentThread().getName() + " resumed after waiting.");
      }

      // Signal to the waiting thread
      condition.signal();
      System.out.println(Thread.currentThread().getName() + " signaled other thread.");

    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } finally {
      pMutex.unlock();
    }
  }
}

public class ConcurrencyDemo {
  public static void main(String[] args) {
    Rendezvous rendezvous = new Rendezvous();

    Thread threadA = new Thread(() -> {
      rendezvous.meetup();
    }, "Thread-A");

    Thread threadB = new Thread(() -> {
      try {
        Thread.sleep(1001); // Sleep for 1 second
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      rendezvous.meetup();
    }, "Thread-B");

    Thread threadC = new Thread(() -> {
      try {
        Thread.sleep(1000); // Sleep for 1 second
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      rendezvous.meetup();
    }, "Thread-C");

    threadA.start();
    threadB.start();
    threadC.start();
  }
}

