import java.util.HashMap;

public class NonRepeatingCharacter {
    public static String nonRepeating(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String c = null;

        for (int i = 0; i < s.length(); ++i) {
            c = String.valueOf(s.charAt(i));
            if (!map.containsKey(c))
                map.put(String.valueOf(c), 1);
            else
                map.put(String.valueOf(s.charAt(i)), map.get(c) + 1);
        }

        for (int i = 0; i < s.length(); ++i) {
            c = String.valueOf(s.charAt(i));
            if (map.get(c) == 1)
                return c;
        }

        return null;
    }

    public static void main(String[] args) {
        String s = "abcabfcca";
        String answer = nonRepeating(s);

        if (answer != null)
            System.out.println("Non Repeating Char: " + answer.toString());
        else
            System.out.println("Non Repeating Char: None");

    }
}
