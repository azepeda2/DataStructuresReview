public class QuickSort {
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; ++j) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return (i + 1);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(" " + arr[i]);
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
