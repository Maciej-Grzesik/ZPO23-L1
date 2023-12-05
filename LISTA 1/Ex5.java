import java.util.Scanner;
/**
* Klasa przyjmujaca wsp. dwoch punktow a nastepnie wyswietlajaca rownanie prostej przechodzacej przez te punkty
*/
public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj współrzędne pierwszego punktu: ");
        double pierwszyPunktX = scanner.nextDouble();
        double pierwszyPunktY = scanner.nextDouble();
        System.out.println("Podaj współrzędne drugiego punktu: ");
        double drugiPunktX = scanner.nextDouble();
        double drugiPunktY = scanner.nextDouble();

        scanner.close();

        try {
            double[] rowananie = wspolczynniki(pierwszyPunktX, drugiPunktX, pierwszyPunktY, drugiPunktY);
            System.out.println("y = " + rowananie[0] + "x + " + rowananie[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
    * Metoda obliczajaca wsp. dopasowania liniowego dla dwoch puntkow
    */
    public static double[] wspolczynniki(double pierwszyPunktX, double drugiPunktX, double pierwszyPunktY, double drugiPunktY) {
        if ((drugiPunktX == pierwszyPunktX) && (drugiPunktY == pierwszyPunktY)){
            throw new IllegalArgumentException("Współrzędne punktów nie mogą być takie same.");
        }
        double a = (drugiPunktY - pierwszyPunktY) / (drugiPunktX - pierwszyPunktX);
        double b = pierwszyPunktY - (a * pierwszyPunktX);
        return new double[]{a, b};
    }
}
