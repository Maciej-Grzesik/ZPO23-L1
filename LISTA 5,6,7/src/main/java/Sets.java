import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sets {
    protected final HashSet<Integer> setA;
    protected final HashSet<Integer> setB;

    /**
     * Konstruktor klasy Sets
     */
    public Sets(){
        this.setA = new HashSet<>();
        this.setB = new HashSet<>();
    }
    /**
     * Metoda pozwalajaca na dodanie elementow do zbioru A
     * @param el elementy o typie Int
     */
    public void addA(Integer... el){
        this.setA.addAll(Arrays.asList(el));
    }
    /**
     * Metoda pozwalajaca na dodanie elementow do zbioru B
     * @param el elementy o typie Int
     */
    public void addB(Integer... el){
        this.setB.addAll(Arrays.asList(el));
    }

    /**
     * Metoda sumujaca dwa zbiory
     * @return suma zbiorow A i B
     */
    public Set<Integer> unionSets(){
        Set<Integer> sum = new HashSet<>(this.setA);
        sum.addAll(this.setB);
        return sum;
    }
    /**
     * Metoda roznicujaca dwa zbiory
     * @return roznica zbiorow A i B
     */
    public Set<Integer> differenceSets(){
        Set<Integer> difference = new HashSet<>(this.setA);
        difference.removeAll(this.setB);
        return difference;
    }
    /**
     * Metoda obliczajaca czesc wspolna dwoch zbiorow
     * @return czesc wspolna zbiorow A i B
     */
    public Set<Integer> intersectSets(){
        Set<Integer> intersect = new HashSet<>(this.setA);
        intersect.retainAll(this.setB);
        return intersect;
    }
    /**
     * Metoda obliczajaca roznice symatryczna dwoch zbiorow
     * @return roznica symetryczna zbiorow A i B
     */
    public Set<Integer> symetricDifference(){
        Set<Integer> first = new HashSet<>(this.setA);
        first.removeAll(this.setB);
        Set<Integer> second = new HashSet<>(this.setB);
        second.removeAll(this.setA);
        first.addAll(second);
        return first;
    }
    /**
     * Metoda prowonujaca dwa zbiory
     * @return true - jesli oba sa rowne, false - jesli nie sa
     */
    public boolean areEquals(){
        return this.setA.equals(this.setB);
    }
}