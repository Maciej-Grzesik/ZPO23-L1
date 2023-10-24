/**
 * Klasa testujaca
 */
class ComplexNumberTest {
    public static void main(String[] args) {
        ComplexNumber z = new ComplexNumber(1, 2);
        ComplexNumber z1 = new ComplexNumber(3, 4);
        Vector2D v = new Vector2D(1, 1);
        System.out.println("Wektor: " + v);
        System.out.format("Modul: %.5f", v.getModule());
        System.out.println();
        System.out.format("Kat: %.5f%n", v.getArgument());
        System.out.println("Liczba zespolona z = " + z);
        System.out.format("Modul liczby zesplonej |z| = %.5f%n", z.getModule());
        System.out.format("Kat liczby zespolonej z: %.5f[rad] %n", z.getArgument());
        System.out.println("Re(z) + Im(z)i: " + z.exp());
        System.out.println("Liczba z w postaci biegunowej: " + z.polar());
        System.out.println("z + z1 = " + ComplexNumber.add(z, z1));
        System.out.println("z - z1 = " + ComplexNumber.subtract(z, z1));
        System.out.println("z * z1 = " + ComplexNumber.multiply(z, z1));
        try {
            System.out.println("z : z1 = " + ComplexNumber.divide(z, z1));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        ComplexNumber z2 = new ComplexNumber(0, 0);
        try {
            System.out.println("z : z1 = " + ComplexNumber.divide(z, z2));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("z^4 = " + z.power(4));
        System.out.println(z.equals(z1));
    }
}
