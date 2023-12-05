import java.util.*;

public class Statistic {
    private final Map<String, Integer> characters_unique;
    private final Map<String, Integer> words_unique;
    private final List<String> characters_count;
    private final List<String> words_count;

    public Statistic(String sentence){
        this.characters_unique = new HashMap<>();
        this.words_unique = new HashMap<>();
        this.characters_count = new ArrayList<>(Arrays.asList(sentence.trim().split("(?!^)")));
        this.words_count = new ArrayList<>(Arrays.asList(sentence.trim().split("\\s+")));
    }
    public Integer countTotalWords(){
        return words_count.size();
    }
    public Integer countUniqueWords(){
        for (String word : words_count){
            words_unique.put(word.toLowerCase(), words_unique.getOrDefault(word, 0 ) + 1);
        } return words_unique.size();
    }
    public Integer countTotalCharacters(){
        return characters_count.size();
    }
    public Integer countUniqueCharacters(){
        for (String word : characters_count){
            characters_unique.put(word, characters_unique.getOrDefault(word, 0 ) + 1);
        } return characters_unique.size();
    }

}
