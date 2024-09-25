public class OneArrayIsRotationOfAnother {
    public static boolean isRotation(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;

        for (j = 0; j < arr2.length; ++j) {
            if (arr1[i] == arr2[j]) {
                break;
            }
        }

        if (arr1[i] != arr2[j])
            return false;

        while (i < arr1.length) {
            if (arr1[i] != arr2[j])
                return false;

            ++i;
            j = (j + 1) % arr2.length;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
        int[] arr2 = { 4, 5, 6, 7, 1, 2, 3 };

        System.out.println("Is rotation: " + isRotation(arr1, arr2));
    }
}
