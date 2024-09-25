import java.net.ConnectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentWords {
    public static List<String> retrieveMostFreqWords(String literatureText, List<String> wordsToExclude) {
        // dont include wordsToExclude
        // return all words that are most frequent if tie
        // split words
        // loop over each word and add to a hashmap for frequency
        // find which appear the most
        // one way to improve performance is to change words to exclude to a set

        List<String> output = new ArrayList<>();
        Map<String, Integer> frequencies = new HashMap<>();
        String[] splitWords = literatureText.split(" ");
        for (String word : splitWords) {
            if (wordsToExclude.contains(word))
                continue;

            if (frequencies.containsKey(word)) {
                frequencies.put(word, frequencies.get(word) + 1);
            } else {
                frequencies.put(word, 1);
            }
        }

        int maxCount = -1;
        for (int count : frequencies.values()) {
            if (count > maxCount)
                maxCount = count;
        }

        for (String word : frequencies.keySet()) {
            if (frequencies.get(word) == maxCount)
                output.add(word);
        }

        return output;
    }
}