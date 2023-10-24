/**
 * Klasa reprezentujaca liczbe zespolona dziedziczaca po klasie Vector2D
 */
class ComplexNumber extends Vector2D {
    /**
     * Konstruktor klasy ComplexNumber
     * @param x skladowa rzeczywista liczby zespolone
     * @param y skladowa urojona liczby zespolonej
     */
    public ComplexNumber(double x, double y){
        super(x, y);
    }

    /**
     * metoda zwracajaca skladowa rzeczywista liczby zespolonej
     * @return skladowa rzeczywista liczby zespolonej
     */
    public double Re() {
        return getX();
    }

    /**
     * metoda zwracajaca skladowa urojona liczby zespolonej
     * @return skladowa urojona liczby zespolonej
     */
    public double Im() {
        return getY();
    }

    /**
     * metoda zwracajaca tekstowa reprezentacje wykladnicza liczby zespolonej
     * @return tekstowa reprezentacja wykladnicza liczby zespolonej
     */
    public String exp() {
        return getModule() + "e(" + getArgument() + "i)";
    }

    /**
     * metoda zwracajaca tekstowa reprezentacje biegunowa liczby zespolonej
     * @return tekstowa reprezentacja biegunowa liczby zespolonej
     */
    public String polar() {
        return "z = (" + getModule() + "," + getArgument() + ")";
    }

    /**
     * metoda statyczna sluzaca do dodawania dwoch liczb zespolonych
     * @param cn1 pierwsza liczba zespolona
     * @param cn2 druga liczba zespolona
     * @return wynik dodawania dwoch liczb zespolonych
     */
    public static ComplexNumber add(ComplexNumber cn1, ComplexNumber cn2) {
        double Im = cn1.Im() + cn2.Im();
        double Re = cn1.Re() + cn2.Re();
        return new ComplexNumber(Re, Im);
    }
    /**
     * metoda statyczna sluzaca do odejmowania dwoch liczb zespolonych
     * @param cn1 pierwsza liczba zespolona
     * @param cn2 druga liczba zespolona
     * @return wynik odejmowania dwoch liczb zespolonych
     */
    public static ComplexNumber subtract(ComplexNumber cn1, ComplexNumber cn2) {
        double Im = cn1.Im() - cn2.Im();
        double Re = cn1.Re() - cn2.Re();
        return new ComplexNumber(Re, Im);
    }
    /**
     * metoda statyczna sluzaca do mozenia dwoch liczb zespolonych
     * @param cn1 pierwsza liczba zespolona
     * @param cn2 druga liczba zespolona
     * @return wynik mnozenia dwoch liczb zespolonych
     */
    public static ComplexNumber multiply(ComplexNumber cn1, ComplexNumber cn2) {
        double Im = cn1.Re() * cn2.Im() + cn1.Im() * cn2.Re();
        double Re = cn1.Re() * cn2.Re() - Im * cn2.Im();
        return new ComplexNumber(Re, Im);
    }
    /**
     * metoda statyczna sluzaca do dzielenia dwoch liczb zespolonych
     * @param cn1 pierwsza liczba zespolona
     * @param cn2 druga liczba zespolona
     * @return wynik dzielenia dwoch liczb zespolonych
     */
    public static ComplexNumber divide(ComplexNumber cn1, ComplexNumber cn2) {
        double div = cn2.Re() * cn2.Re() + cn2.Im() * cn2.Im();
        if (div == 0) {
            throw new ArithmeticException("Blad dzielenia przez zero");
        }
        double Re = (cn1.Re() * cn2.Re() + cn1.Im() * cn2.Im()) / div;
        double Im = (cn2.Re() * cn1.Im() - cn1.Re() * cn2.Im()) / div;
        return new ComplexNumber(Re, Im);
    }

    /**
     * metoda obliczajaca potege n liczby zespolonej
     * @param n potega
     * @return wynik potegowania liczby zespolonej
     */
    public ComplexNumber power(int n){
        double module = Math.pow(this.getModule(), n);
        double argument = this.getArgument() * n;
        double Re = module * Math.cos(argument);
        double Im = module * Math.sin(argument);
        return new ComplexNumber(Re, Im);
    }

    /**
     * metoda porownujaca dwie liczby zespolone
     * @param obj liczba zespolona do porownania
     * @return true, kiedy liczby zespolone sa rowne, false jesli nie sa
     */
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        ComplexNumber compare = (ComplexNumber) obj;
        return Re() == compare.Re() && Im() == compare.Im();
    }

    /**
     * metoda zwracajaca tekstowa reprezentacje liczby zespolonej
     * @return reprezentacja tekstowa liczby zespolonej
     */
    @Override
    public String toString() {
        return getX() + " + " + "i" + getY();
    }
}