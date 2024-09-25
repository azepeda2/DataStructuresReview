public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int answer = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            answer = answer ^ nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 3, 2, 4, 3, };
        System.out.println(singleNumber(arr));
    }
}
