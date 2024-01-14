/**
 * Klasa reprezentujaca asynchroniczne wyplacanie pieniedzy z banku
 */
public class SharedBankASync {
    /**
     * Metoda symuluijaca wyplacanie pieniedzy z banku
     * @param amount ilosc do wyplaty
     */
    public void withdraw(int amount) {
        int currentBalance = 1000;
        if (amount <= currentBalance) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentBalance -= amount;
            System.out.println("Withrdrawal succesful, current balance: " + currentBalance);
        } else {
            System.out.println("Withdrawal unsuccesful, insufficient funds");
        }
    }
}
