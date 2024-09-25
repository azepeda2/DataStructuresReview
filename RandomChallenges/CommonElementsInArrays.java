import java.util.ArrayList;

public class CommonElementsInArrays {
    public static ArrayList<Integer> commonElements(int[] arr1, int[] arr2) {
        ArrayList<Integer> commonList = new ArrayList<Integer>();

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                commonList.add(arr1[i]);
                ++i;
                ++j;
            } else if (arr1[i] > arr2[j]) {
                ++j;
            } else {
                ++i;
            }
        }

        return commonList;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 4, 6, 7, 9 };
        int[] arr2 = { 1, 2, 4, 5, 9, 10 };

        System.out.println("Common Elems: " + commonElements(arr1, arr2).toString());
    }
}
