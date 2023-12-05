/**
 * Klasa Class_2 rozszerzajaca klasę Produkt i reprezentujaca konkretny produkt
 */
public class Class_2 extends Produkt {
    private final int flavour_code;

    /**
     * Konstruktor klasy "Class_2".
     *
     * @param name         Nazwa produktu
     * @param price        Cena produktu
     * @param quantity     Ilosc produktu w magazynie
     * @param flavour_code Kod smaku (1 - Czekoladowy, 2 - Truskawkowy, 3 - Waniliowy)
     */
    public Class_2(String name, float price, int quantity, int flavour_code) {
        super(name, price, quantity);
        if (flavour_code == 1 || flavour_code == 2 || flavour_code == 3) {
            this.flavour_code = flavour_code;
        } else {
            throw new IllegalArgumentException("Wybrano zły kod smaku");
        }
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
     * Metoda do pobrania typu smaku na podstawie kodu smaku
     *
     * @return Typ smaku produktu
     */
    public String flavourType() {
        return switch (flavour_code) {
            case 1 -> "Czekoladowy";
            case 2 -> "Truskawkowy";
            case 3 -> "Waniliowy";
            default -> "";
        };
    }
}
