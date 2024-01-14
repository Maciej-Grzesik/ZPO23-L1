/**
 * Kalasa reprezentująca użycie multithreadingu z wspolnym licznikiem
 */

public class CounterExample implements Runnable {
    private static int counter = 0;
    private int threadNumber;

    public CounterExample(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    /**
     * Implementowana metoda odpowiedzialna za egzekucje kodu w wątku
     */
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            incrementCounter();
            printOutput();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Metoda zwracająca konsolowo stan licznika, obecny watek i wartość ktora watek oblicza
     */
    private synchronized void printOutput() {
        System.out.println("Thread: " + threadNumber + " Count: " + ((counter + threadNumber) * (threadNumber + 1)) + " Counter: " + counter);
    }

    /**
     * Metoda odpowiedzialna za zwiększanie wartosci wspolnego licznika w sposob synchroniczny
     */
    private static synchronized void incrementCounter() {
        counter = counter + 1;
    }

    /**
     * Metoda prezentujaca dzialanie programu
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            CounterExample counterExample = new CounterExample(i);
            Thread thread = new Thread(counterExample);
            thread.start();
        }
    }
}
