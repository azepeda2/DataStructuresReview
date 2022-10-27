public class PalindromeNumber {
    public static boolean isPalindrome(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }

            ++i;
            --j;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 1 };
        int[] arr2 = { 1, 2, 2, 1 };
        int[] arr3 = { 1, 2, 3, 1 };
        int[] arr4 = { 1, 2, 3, 2, 1 };

        System.out.println("IsPalindrome: " + isPalindrome(arr1));
        System.out.println("IsPalindrome: " + isPalindrome(arr2));
        System.out.println("IsPalindrome: " + isPalindrome(arr3));
        System.out.println("IsPalindrome: " + isPalindrome(arr4));
    }
}
