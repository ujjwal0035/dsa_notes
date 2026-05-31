package mutithreading.p1;

public class WithdrawTask implements Runnable {
    Account account;
    int amountRequested;

    public WithdrawTask(Account account, int amountRequested) {
        this.account = account;
        this.amountRequested = amountRequested;
    }

    @Override
    public void run() {
        account.withdraw(amountRequested);
    }
}
