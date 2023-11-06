/**
 * Klasa Class_1 rozszerzajaca klasę Produkt i reprezentujaca konkretny produkt.
 */
public class Class_1 extends Produkt {
    private final float weight;

    /**
     * Konstruktor klasy Class_1
     *
     * @param name     Nazwa produktu
     * @param price    Cena produktu
     * @param quantity Ilość produktu w magazynie
     * @param weight   Waga produktu
     */
    public Class_1(String name, float price, int quantity, float weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    /**
     * Metoda do pobrania nazwy produktu
     *
     * @return Nazwa produktu
     */
    @Override
    public String pobierzNazwe() {
        return name;
    }

    /**
     * Metoda do pobrania ceny produktu
     *
     * @return Cena produktu
     */
    @Override
    public float pobierzCene() {
        return price;
    }

    /**
     * Metoda do pobrania ilosci produktu
     *
     * @return Ilosc produktu w magazynie
     */
    @Override
    public int pobierzIlosc() {
        return quantity;
    }

    /**
     * Metoda do obliczenia łacznej wagi produktu
     *
     * @return Laczna waga produktu
     */
    public float totalWeight() {
        return quantity * weight;
    }
}
