public class URLReplaceSpaces {
    void replaceSpaces(char[] string, int trueLength) {
        int numberOfSpaces = countOfChar(string, 0, trueLength, ' ');
        int newIndex = trueLength - 1 + numberOfSpaces * 2;

        /*
         * If there are excess spaces, add a null character. This indicates that the
         * spaces after that point have not been replaced with a %20.
         */
        if (newIndex + 1 < string.length)
            string[newIndex + 1] = '\0';
        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -= 1) {
            System.out.println("index: " + newIndex + " " + string[newIndex]);
            if (string[oldIndex] == ' ') {
                string[newIndex] = '0';
                string[newIndex - 1] = '2';
                string[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                string[newIndex] = string[oldIndex];
                newIndex -= 1;
            }
        }

        System.out.println(string.toString());
    }

    /* Count occurrences of target between start (inclusive) and end (exclusive). */
    int countOfChar(char[] string, int start, int end, int target) {
        int count = 0;
        for (int i = start; i < end; ++i) {
            if (string[i] == target) {
                count++;
            }
        }
        System.out.println("numberOfSpaces: " + count);
        return count;
    }

    public static void main(String[] args) {
        URLReplaceSpaces URS = new URLReplaceSpaces();
        URS.replaceSpaces("Mr John Smith".toCharArray(), 13);
    }
}