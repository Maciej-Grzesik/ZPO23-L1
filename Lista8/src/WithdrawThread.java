/**
 * Klasa prezentujaca dzialanie metod z zadania 3
 */
public class WithdrawThread implements Runnable {
    private SharedBankASync sharedBankASync;
    private SharedBankSync sharedBankSync;
    private int amount;

    public WithdrawThread(SharedBankASync sharedBankASync, SharedBankSync sharedBankSync, int amount) {
        this.sharedBankASync = sharedBankASync;
        this.sharedBankSync = sharedBankSync;
        this.amount = amount;
    }

    public void run() {
        sharedBankASync.withdraw(amount);
        sharedBankSync.withdraw(amount);
    }
}