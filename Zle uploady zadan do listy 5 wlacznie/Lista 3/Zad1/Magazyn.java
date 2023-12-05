import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Klasa przechowujaca obiekty produkt
 */
public class Magazyn {
    private final Map<String, Produkt> products;
    public Magazyn(){
        this.products = new HashMap<>();
    }

    /**
     * Metoda dodajaca produkt do listy
     * @param product produkt do dodania
     * @throws IllegalArgumentException kiedy produkt jest pusty
     */
    public void addProduct(Produkt product){
        if (product == null || product.pobierzNazwe().isEmpty){
            throw new IllegalArgumentException("Produkt nie moze byc pusty!");
        }
        products.put(product.pobierzNazwe(),product);
    }
    /**
    * Metoda zwracajaca liste produktow w postaci mapy
    */
    public Map<String, Produkt> getProducts(){
        return products;
    }
}
