/**
 * Przykladowa 3 klasa do zad1
 */
class Class_3 implements Produkt {
    private final String name;
    private final float price;
    private final int quantity;
    private boolean promotion;

    /**
     * Konstruktor klasy Class_3
     * @param name nazwa produktu
     * @param price cena produktu
     * @param quantity ilosc
     * @param promotion informacja o przecenie produktu
     */
    public Class_3(String name, float price, int quantity, boolean promotion){
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Nazwa nie moze byc pusta!");
        }
        if (price <= 0){
            throw new IllegalArgumentException("Cena nie moze byc mniejsza/rowna zero!");
        }
        if (quantity < 0){
            throw new IllegalArgumentException("Ilość produktow nie moze byc ujemna!");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotion = promotion;
    }
    @Override
    public String pobierzNazwe(){
        return name;
    }
    @Override
    public float pobierzCene(){
        return price;
    }
    @Override
    public int pobierzIlosc(){
        return quantity;
    }

    /**
     * Metoda ustawiajaca informacje o przecenie
     *
     * @param x Logiczna wartosc mowiaca o przecenie
     */
    public void setPromotion(boolean x){
        this.promotion = x;
    }

    /**
     * Metoda zwracajaca informacje o przecenie produktu
     * @return "Produkt jest na promocji" dla true w przeciwnym wypadku "Produkt nieprzeceniony"
     */
    public String isOnPromotion(){
        if (this.promotion){
            return "Produkt jest na promocji";
        } else {
            return "Produkt nieprzeceniony";
        }
    }
}
