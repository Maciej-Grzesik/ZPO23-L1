/**
 * Klasa nadrzedna Vector2D reprezentujaca wektor w dwuwymierowej przestrzeni zespolonej
 */
public class Vector2D {
    private final double x;
    private final double y;

    /**
     * Konstruktor klasy Vector2D
     * @param x wsp wektora
     * @param y wsp wektora
     */
    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * getter zwraca skladowa rzeczywista wektora
     * @return skladowa rzeczywista
     */
    public double getX() {
        return x;
    }
    /**
     * getter zwraca skladowa urojona wektora
     * @return skladowa urojona
     */
    public double getY() {
        return y;
    }

    /**
     * metoda obliczajaca modul wektora
     * @return modul wektora
     */
    public double getModule() {
        return Math.sqrt(x * x + y * y);
    }
    /**
     * metoda obliczajaca argument wektora w radianach
     * @return argument wektora
     */
    public double getArgument() {
        if (x == 0.0 && y == 0.0) {
            throw new ArithmeticException("Kat nie istnieje dla wektora (0,0)");
        }
        return Math.atan2(y, x);
    }

    /**
     * metoda zwracajaca reprezentacje tekstowa wektora
     * @return reprezentacja tekstowa wektora
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}