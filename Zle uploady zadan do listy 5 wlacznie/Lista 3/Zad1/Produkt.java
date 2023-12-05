/**
 * Interfejs reprezentujacy produkt
 */
interface Produkt{
    /**
     * Metoda zwracajaca nazwe produktu
     * @return nazwa produktu
     */
    String pobierzNazwe();

    /**
     * Metoda zwracajaca cene produktu
     * @return cena produktu
     */
    float pobierzCene();

    /**
     * Metoda zwracajaca ilosc produktow
     * @return ilosc produktow
     */
    int pobierzIlosc();
}