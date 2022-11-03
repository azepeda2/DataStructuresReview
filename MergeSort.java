public class MergeSort {
    /*
     * Merges two subarrays of arr
     * first subarray is arr[left.. mid]
     * second subarray is arr[mid + 1.. right]
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; ++j) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            sort(arr, left, middle);
            sort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 7, 6 };

        System.out.println("Input Array:");
        printArray(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");
        printArray(arr);
    }

}