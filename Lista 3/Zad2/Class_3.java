/**
 * Klasa Class_3 rozszerzajaca klasę Produkt i reprezentujaca konkretny produkt
 */
public class Class_3 extends Produkt {
    private boolean promotion;

    /**
     * Konstruktor klasy Class_3
     *
     * @param name      Nazwa produktu
     * @param price     Cena produktu
     * @param quantity  Ilosc produktu w magazynie
     * @param promotion Logiczna wartość reprezentująca promocje produktu (true - na promocji, false - nieprzeceniony)
     */
    public Class_3(String name, float price, int quantity, boolean promotion) {
        super(name, price, quantity);
        this.promotion = promotion;
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
     * Metoda do pobrania ilości produktu
     *
     * @return Ilosc produktu w magazynie
     */
    @Override
    public int pobierzIlosc() {
        return quantity;
    }

    /**
     * Metoda ustawiająca stan promocji produktu
     *
     * @param x true, jesli produkt jest na promocji, w innym przypadku false
     */
    public void setPromotion(boolean x) {
        this.promotion = x;
    }

    /**
     * Metoda sprawdzająca czy produkt jest na promocji
     *
     * @return Informacja o stanie promocji 
     */
    public String isOnPromotion() {
        if (this.promotion) {
            return "Produkt jest na promocji";
        } else {
            return "Produkt nieprzeceniony";
        }
    }
}
