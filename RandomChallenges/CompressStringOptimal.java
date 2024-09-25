public class CompressStringOptimal {
    static public String compress(String input) {
        int finalLength = countCompression(input);
        if (finalLength >= input.length())
            return input;

        StringBuilder compressed = new StringBuilder(finalLength);
        int count = 0;
        for (int i = 0; i < input.length(); ++i) {
            ++count;

            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressed.append(input.charAt(i));
                compressed.append(count);
                count = 0;
            }
        }

        return compressed.toString();
    }

    static int countCompression(String input) {
        int compressedLength = 0;
        int count = 0;

        for (int i = 0; i < input.length(); ++i) {
            ++count;

            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(count).length();
                count = 0;
            }
        }

        return compressedLength;
    }

    public static void main(String[] args) {
        String test1 = "aabcccccaaa";
        String test2 = "originalString";

        System.out.println("Test1: " + compress(test1));
        System.out.println("Test2: " + compress(test2));
        System.out.println(String.valueOf(0).length());
    }
}
