package mutithreading.p1;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    int balance = 1000;
    ReentrantLock lock = new ReentrantLock();

    public void withdraw(int amount) { // synchronized method to ensure thread safety
        lock.lock();
        try{
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName()
                        + " is withdrawing " + amount);
    
                balance = balance - amount;
    
                System.out.println("Remaining balance: " + balance);
            } else {
                System.out.println("Insufficient balance for "
                        + Thread.currentThread().getName());
            }
        } finally {
            lock.unlock();
        }
    }
}
