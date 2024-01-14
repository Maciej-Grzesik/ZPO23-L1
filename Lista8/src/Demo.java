public class Demo {
    public static void main(String[] args) {
        SharedBankASync sharedBankASync = new SharedBankASync();
        SharedBankSync sharedBankSync = new SharedBankSync();

        Thread thread1 = new Thread(new WithdrawThread(sharedBankASync, sharedBankSync, 500));
        Thread thread2 = new Thread(new WithdrawThread(sharedBankASync, sharedBankSync, 800));

        thread1.start();
        thread2.start();
    }
}