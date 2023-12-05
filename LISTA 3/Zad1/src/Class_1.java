class Class_1 implements Produkt {
    private final String name;
    private final float price;
    private final int quantity;
    private final float weight;

    /**
     * Konstruktor klasy Class_1
     * @param name nazwa produktu
     * @param price cena
     * @param quantity ilosc
     * @param weight waga pojedynczego produktu
     */
    public Class_1(String name, float price, int quantity, float weight){
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Nazwa nie moze byc pusta!");
        }
        if (price <= 0){
            throw new IllegalArgumentException("Cena nie moze byc mniejsza/rowna zero!");
        }
        if (quantity < 0){
            throw new IllegalArgumentException("Ilość produktow nie moze byc ujemna!");
        }
        if (weight <= 0){
            throw new IllegalArgumentException("Waga produktu nie moze byc ujemna!");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
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
     * Metoda obliczajaca laczna wage produktow
     * @return laczna waga produktow
     */
    public float totalWeight(){
        return quantity * weight;
    }
}
