public class FindMinRotatedSortedArray {
    public static int search(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return Math.min(arr[0], arr[1]);
        }
        if (arr[0] < arr[arr.length - 1]) {
            return arr[0];
        }
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) return arr[mid + 1];
            if (arr[mid - 1] > arr[mid]) return arr[mid]; 

            if (arr[left] < arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 5 ,6 ,7, 8, 9, 10, 11, 12, 13, 14, 15, 1, 2 ,3 ,4};
        
        System.out.println("Min: " + search(arr));
    }
    
}