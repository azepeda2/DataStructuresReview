import javax.swing.undo.CompoundEdit;

public class CompressString {
    /*
     * My implementation
     * static public String compress(String input) {
     * StringBuilder sb = new StringBuilder();
     * int count = 1;
     * char currentChar = input.charAt(0);
     * sb.append(currentChar);
     * 
     * for (int i = 1; i < input.length(); ++i) {
     * if (currentChar == input.charAt(i)) {
     * ++count;
     * } else {
     * sb.append(count);
     * count = 1;
     * currentChar = input.charAt(i);
     * sb.append(currentChar);
     * }
     * }
     * 
     * sb.append(count);
     * System.out.println("inputLength: " + input.length() + " compressedLength: " +
     * sb.length());
     * 
     * if (input.length() > sb.length()) {
     * return sb.toString();
     * } else {
     * return input;
     * }
     * }
     */

    static public String compress(String input) {
        StringBuilder compressed = new StringBuilder();
        int count = 0;

        for (int i = 0; i < input.length(); ++i) {
            ++count;

            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressed.append(input.charAt(i));
                compressed.append(count);
                count = 0;
            }
        }

        return compressed.length() < input.length() ? compressed.toString() : input;
    }

    public static void main(String[] args) {
        String test1 = "aabcccccaaa";
        String test2 = "originalString";

        System.out.println("Test1: " + compress(test1));
        System.out.println("Test2: " + compress(test2));

    }
}
