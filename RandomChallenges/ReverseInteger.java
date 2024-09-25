public class ReverseInteger {
    public static int reverse(int num) {
        int reversed = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        while (num != 0) {
            int lastDigit = num % 10;

            // because the last number on the max int is 7
            if (reversed > max / 10 || (reversed == max / 10 && lastDigit > 7)) {
                return 0;
            }

            if (reversed < min / 10 || (reversed == min / 10 && lastDigit < -8)) {
                return 0;
            }

            reversed = reversed * 10 + lastDigit;

            num /= 10;
        }

        return reversed;
    }

    public static String reverseSB(int num) {
        int currentNum = num;
        StringBuilder sb = new StringBuilder();

        while (currentNum != 0) {
            sb.append(currentNum % 10);
            currentNum /= 10;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 123;
        System.out.println("ReverseSB: " + reverseSB(num));

        System.out.println("Reverse: " + reverse(num));

    }
}
