/**
  * An example of using StringBuilder and how the string grows dynamically 
  */

public class StringbuilderExample {
    
    /**
     * Always creates a new copy of string whenever it adds a new word
     * @param words
     * @return
     */
    String joinWords(String[] words) {
        String sentence = "";
        for (String w : words) {
            sentence += w;
        }

        return sentence;
    }

    String joinWordsBuilder(String[] words) {
        StringBuilder sentence = new StringBuilder();
        for (String w : words) {
            sentence.append(w);
        }

        return sentence.toString();
    }
}
