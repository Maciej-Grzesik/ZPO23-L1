import java.util.Scanner;
/**
* Klasa wyswietlajaca tabliczke mnozenia liczb z zakresu [1;9] w zaleznosci od zadanej wartosci
*/
public class Ex4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę całkowitą z przedziału [1,9]: ");
        int n = scanner.nextInt();

        scanner.close();

        if (n <= 9 && n >= 1) {
            System.out.print("Podano liczbę spoza dopuszczalnego przedziału.");
        } else {
            int[][] tabA = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n; j++) {
                    tabA[i][j] = (i + 1) * (j + 1);
                    System.out.print(tabA[i][j] + "\t");
                }
                System.out.println();
            }

        }
    }
}



