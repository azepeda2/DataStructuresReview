public class BinarySearch {
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return - 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2 ,3 ,4, 5 ,6 ,7, 8, 9, 10, 11, 12, 13, 14, 15};
        
        System.out.println("Index: " + search(arr, 7));
    }
}
