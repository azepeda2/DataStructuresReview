class BubbleSort {
    void sort(int[] array) {

        for (int lastIndexUnsorted = array.length - 1; lastIndexUnsorted > 0; lastIndexUnsorted--) {
            for (int i = 0; i < lastIndexUnsorted; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
    }

    void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i + 1];
            array[i + 1] = array[i];
            array[i] = temp;
        }
    }

    void print(int[] array) {
        for (int val : array) {
            System.out.println(val);
        }
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] array = {20, 35, -15, 7, 55, 1, -22};
        bs.print(array);
        bs.sort(array);
        bs.print(array);

    }
}