import java.util.HashSet;

/**
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 */
public class IsUnique {
    
    /**
     * Solution using built in HashSet
     * @param string
     * @return
     */
    public boolean isUnique (String string) {
        HashSet<Character> chars = new HashSet<Character>();

        for (int i = 0; i < string.length(); ++i) {
            if (!chars.add(string.charAt(i))) {
                System.out.println("The letter " + string.charAt(i) + " is repeated in the string.");
                return false;
            }
        }
        
        System.out.println(string + " does not have repeating characters.");

        return true;
    }

    /**
     * Solution using only base arrays and chars
     * @param string
     * @return
     */
    public boolean isUniqueBase (String string) {
        for (int i = 0; i < string.length() - 1; ++i) {
            for (int j = i + 1; j < string.length(); ++j) {
                if (string.charAt(i) == string.charAt(j)) {
                    System.out.println("The letter " + string.charAt(i) + " is repeated in the string: " + string);
                    return false;
                }
            }
        }

        System.out.println(string + " does not have repeating characters.");

        return true;
    }

    /**
     * Solution using a bit vector assuming only lowercase letters are used
     * @param string
     * @return
     */
    public boolean isUniqueCharsBits (String string) {
        int checker = 0;
        for (int i = 0; i < string.length(); i++) {
            int val = string.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                System.out.println("The letter " + string.charAt(i) + " is repeated in the string: " + string);
                return false;
            }
            
            checker |= (1 << val);
        }

        System.out.println(string + " does not have repeating characters.");

        return true;
    }

    public static void main(String[] args) {
        IsUnique IS = new IsUnique();
        IS.isUnique("string");
        IS.isUniqueBase("strings");
        IS.isUniqueCharsBits("string");
    }
}
