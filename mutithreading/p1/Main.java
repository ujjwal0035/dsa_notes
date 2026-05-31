package mutithreading.p1;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        Thread t1 = new Thread(new WithdrawTask(account, 300), "Thread-1");
        Thread t2 = new Thread(new WithdrawTask(account, 700), "Thread-2");
        Thread t3 = new Thread(new WithdrawTask(account, 1), "Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
}
