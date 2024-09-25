import java.util.ArrayList;
import java.util.List;

public class FindSearchSuggestions {
    public static List<List<String>> threeKeywordSuggestions(int numReviews,
            List<String> repository, String customerQuery) {
        // only return valid if customer has at least two chars
        // return empty array if no output
        // case-insensitive
        // break customer query into substrings
        // loop over each word in the repo and see if it starts with any substring
        List<List<String>> output = new ArrayList<>();
        List<String> lowerCaseRepo = new ArrayList<>();
        for (String word : repository) {
            lowerCaseRepo.add(word.toLowerCase());
        }

        for (int i = 1; i < customerQuery.length(); i++) {
            String subQuery = customerQuery.substring(0, i + 1).toLowerCase();
            List<String> wordsForSubQuery = new ArrayList<>();
            System.out.println("DEBUG: " + subQuery);
            for (String word : lowerCaseRepo) {
                if (word.startsWith(subQuery)) {
                    wordsForSubQuery.add(word);
                    if (wordsForSubQuery.size() == 3) {
                        break;
                    }
                }
            }
            output.add(wordsForSubQuery);
        }

        return output;
    }
}
