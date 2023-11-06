/**
 * Klasa abstrakcyjna reprezentujaca produkt.
 */
public abstract class Produkt {
    protected String name;
    protected float price;
    protected int quantity;

    /**
     * Konstruktor klasy Produkt
     *
     * @param name     Nazwa produktu
     * @param price    Cena produktu
     * @param quantity Ilosc produktu w magazynie
     */
    public Produkt(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Abstrakcyjna metoda do pobrania nazwy produktu
     *
     * @return Nazwa produkty
     */
    public abstract String pobierzNazwe();

    /**
     * Abstrakcyjna metoda do pobrania ceny produktu.
     *
     * @return Cena produktu
     */
    public abstract float pobierzCene();

    /**
     * Abstrakcyjna metoda do pobrania ilości produktu
     *
     * @return Ilosc produktu w magazynie
     */
    public abstract int pobierzIlosc();
}
