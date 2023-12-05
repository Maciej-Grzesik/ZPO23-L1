/**
 * Klasa testujaca do zad1
 */
public class Test {
    public static void  main(String[] args){
        Class_1 prod1 = new Class_1("Chleb", 5.1F,10,1.29F);
        Class_2 prod2 = new Class_2("Białko",59.99F,30,3);
        Class_2 prod3 = new Class_2("Białko",59.99F,10,2);
        Class_2 prod4 = new Class_2("Białko",59.99F,10,1);
        Class_3 prod5 = new Class_3("Jajka",8.99F,100,false);

        Magazyn magazyn = new Magazyn();
        magazyn.addProduct(prod1);
        magazyn.addProduct(prod2);
        magazyn.addProduct(prod3);
        magazyn.addProduct(prod4);
        magazyn.addProduct(prod5);
        //System.out.println(magazyn.getProducts());
        for (Produkt produkt : magazyn.getProducts()){
            if (produkt instanceof Class_1 Obj){
                System.out.println("Nazwa: " + produkt.pobierzNazwe());
                System.out.println("Cena: " + produkt.pobierzCene());
                System.out.println("Ilość: " + produkt.pobierzIlosc());
                System.out.println("Lączna waga: " + Obj.totalWeight());
            } else if (produkt instanceof Class_2 Obj){
                System.out.println("Nazwa: " + produkt.pobierzNazwe() + " - " + Obj.flavourType());
                System.out.println("Cena: " + produkt.pobierzCene());
                System.out.println("Ilość: " + produkt.pobierzIlosc());
            } else if (produkt instanceof Class_3 Obj){
                System.out.println("Nazwa: " + produkt.pobierzNazwe());
                System.out.println("Cena: " + produkt.pobierzCene());
                System.out.println("Ilość: " + produkt.pobierzIlosc());
                System.out.println(Obj.isOnPromotion());
                Obj.setPromotion(true);
                System.out.println(Obj.isOnPromotion());
            }

        }

    }
}
