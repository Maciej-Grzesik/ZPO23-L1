/**
 * Przykladowa klasa do zad1
 */
class Class_2 implements Produkt {
    private final String name;
    private final float price;
    private final int quantity;
    private final int flavour_code;

    /**
     * Konstruktor klasy Class_2
     * @param name nazwa produktu
     * @param price cena
     * @param quantity ilosc
     * @param flavour_code kod smaku
     * @throws IllegalArgumentException dla zlego kodu smaku
     */
    public Class_2(String name, float price, int quantity, int flavour_code){
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Nazwa nie moze byc pusta!");
        }
        if (price <= 0){
            throw new IllegalArgumentException("Cena nie moze byc mniejsza/rowna zero!");
        }
        if (quantity < 0){
            throw new IllegalArgumentException("Ilość produktow nie moze byc ujemna!");
        }
        if (flavour_code == 1 || flavour_code == 2 || flavour_code == 3){
            this.flavour_code = flavour_code;
        } else {
            throw new IllegalArgumentException("Wybrano zły kod smaku");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
     * Metoda zwracajaca nazwe smaku na podstawie kodu smaku
     * @return Czekoladowy - 1, Truskawkowy - 2, Waniliowy - 3
     */
    public String flavourType(){
        return switch (flavour_code) {
            case 1 -> "Czekoladowy";
            case 2 -> "Truskawkowy";
            case 3 -> "Waniliowy";
            default -> "";
        };
    }
}
