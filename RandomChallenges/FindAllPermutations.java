public class FindAllPermutations {
    public static void StringPermutations(String input) {
        StringPermutations("", input);
    }

    private static void StringPermutations(String permuation, String input) {
        if (input.length() == 0) {
            System.out.println(permuation);
        } else {
            for (int i = 0; i < input.length(); i++) {
                StringPermutations(permuation + input.charAt(i),
                        input.substring(0, i) + input.substring(i + 1, input.length()));
            }
        }

    }

    public static void main(String[] args) {
        StringPermutations("ABC");
    }
}
