import java.util.Arrays;

/**
 * Given two strings, determine if one is a permutation of the other
 */

 public class IsPermutation {
    String sort (String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);

        return new String(content);
    }

    boolean permutation (String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        return sort(s1).equals(sort(s2));
    }

    boolean permutation2 (String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] letters = new int[128];

        char[] s1_array = s1.toCharArray();
        for (char c : s1_array) {
            ++letters[c];
        }

        for(int i = 0; i <s2.length(); ++i) {
            int c = (int) s2.charAt(i);
            --letters[c];
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String permutationString1 = "dog";
        String permutationString2 = "god";
        String nonPermutationString = "ant";

        IsPermutation IP = new IsPermutation();
        System.out.println("Using permutation()");
        System.out.print(permutationString1 + " and " + permutationString2 + " are permutations: ");
        System.out.println(IP.permutation(permutationString1, permutationString2));

        System.out.print(permutationString1 + " and " + nonPermutationString + " are permutations: ");
        System.out.println(IP.permutation(permutationString1, nonPermutationString));

        System.out.println("Using permutation2()");
        System.out.print(permutationString1 + " and " + permutationString2 + " are permutations: ");
        System.out.println(IP.permutation2(permutationString1, permutationString2));

        System.out.print(permutationString1 + " and " + nonPermutationString + " are permutations: ");
        System.out.println(IP.permutation2(permutationString1, nonPermutationString));
    }
 }