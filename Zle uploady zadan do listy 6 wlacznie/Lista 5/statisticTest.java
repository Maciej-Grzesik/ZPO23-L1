public class statisticTest {
    public static void main(String[] args){
        String sentence = "Mąkę wsypać do miski, dodać jajka, mleko, wodę i sól. Zmiksować na gładkie ciasto.";
        Statistic stat = new Statistic(sentence);
        System.out.println(stat.countTotalWords());
        System.out.println(stat.countUniqueWords());
        System.out.println(stat.countTotalCharacters());
        System.out.println(stat.countUniqueCharacters());
    }
}
