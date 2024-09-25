public class URLSpaceReplacer {
    void replaceSpaces(String str, int trueLength) {
        int numberOfSpaces = countOfChar(str.toCharArray(), 0, trueLength, ' ');
        int newIndex = trueLength - 1 + numberOfSpaces * 2;
        char[] string = stringToCharArray(str, newIndex);

        System.out.println("trueLength: " + trueLength + " numberOfSpaces: " + numberOfSpaces + " newIndex: " + newIndex + " string: " + string.length);

        /* If there are excess spaces, add a null character. This indicates that the 
         * spaces after that point have not been replaced with %20.
         */
        if (newIndex + 1 < string.length) string[newIndex + 1] = '\0';
        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -= 1) {
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

    }


    int countOfChar(char[] string, int start, int end, int target) {
        int count = 0;
        for (int i = start; i < end; ++i) {
            if (string[i] == target) {
                count++;
            }
        }

        return count;
    }

    char[] stringToCharArray(String string, int newLength) {
        char[] charArray = new char[newLength];
        for (int i = 0; i < string.length(); ++i) {
            charArray[i] = string.charAt(i);
        }

        System.out.println("Char Length: " + charArray.length);
        return charArray;
    }

    public static void main(String[] args) {
        URLSpaceReplacer URLSR = new URLSpaceReplacer();
        URLSR.replaceSpaces("Mr John Smith", 13);
    }
}