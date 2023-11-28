import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Statistic {
    private final Map<String, Long> charactersUnique;
    private final Map<String, Long> wordsUnique;
    private final List<String> charactersCount;
    private final List<String> wordsCount;

    public Statistic(String sentence) {
        this.charactersUnique = new HashMap<>();
        this.wordsUnique = new HashMap<>();
        this.charactersCount = Arrays.asList(Optional.ofNullable(sentence).orElse("").split("(?!^)"));
        this.wordsCount = Arrays.asList(Optional.ofNullable(sentence).orElse("").split("\\s+"));
    }

    public long countTotalWords() {
        return wordsCount.size();
    }

    public long countUniqueWords() {
        wordsUnique.clear();
        wordsCount.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((word, count) -> wordsUnique.put(word, count));
        return wordsUnique.size();
    }

    public long countTotalCharacters() {
        return charactersCount.size();
    }

    public long countUniqueCharacters() {
        charactersUnique.clear();
        charactersCount.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((character, count) -> charactersUnique.put(character, count));
        return charactersUnique.size();
    }
}
