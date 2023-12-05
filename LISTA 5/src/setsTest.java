public class setsTest {
    public static void main(String[] args){
        Sets sets = new Sets();
        sets.addA(1,2,3,4,5);
        sets.addB(4,5,6,7,8);
        System.out.println(sets.unionSets());
        System.out.println(sets.differenceSets());
        System.out.println(sets.intersectSets());
        System.out.println(sets.symetricDifference());
        System.out.println(sets.areEquals());
        sets.addA(6,7,8);
        sets.addB(1,2,3);
        System.out.println(sets.areEquals());
    }
}
