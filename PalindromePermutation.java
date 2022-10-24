public class PalindromePermutation {
    /*
     * Solution1 using a hashtable
     */

     boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequency(phrase);
        return checkMaxOneOdd(table);
     }

     /* Check that no more than one character has an odd count. */
     boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
     }

     /* Map each character to a number. a -> 0, b -> 1, c -> 2, etc 
      * This is case insensitive. Non-letter characters map to -1. 
      */
      int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        
        return -1;
      }

      /* Count how many times each character appears. */
      int[] buildCharFrequency(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - 
                              Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
      }

      /* Solution 2 */

      boolean isPermutationOfPalindrome2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - 
                              Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++; 
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }

        return countOdd <= 1;
      }



      public static void main(String[] args) {
        PalindromePermutation PR = new PalindromePermutation();
        System.out.println(PR.isPermutationOfPalindrome("Tact Coa"));
        System.out.println(PR.isPermutationOfPalindrome2("Tact Coa"));
      }
}