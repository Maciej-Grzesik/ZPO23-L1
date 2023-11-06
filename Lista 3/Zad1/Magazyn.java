import java.util.ArrayList;
import java.util.List;
/**
 * Klasa przechowujaca obiekty produkt
 */
public class Magazyn {
    private final List<Produkt> products;
    public Magazyn(){
        products = new ArrayList<>();
    }

    /**
     * Metoda dodajaca produkt do listy
     * @param product produkt do dodania
     * @throws IllegalArgumentException kiedy produkt jest pusty
     */
    public void addProduct(Produkt product){
        if (product == null){
            throw new IllegalArgumentException("Produkt nie moze byc pusty!");
        }
        products.add(product);
    }
    public List<Produkt> getProducts(){
        return products;
    }
}
