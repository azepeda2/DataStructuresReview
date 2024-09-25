import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11, 24, 12, 51, 6, 2);
        Collections.sort(list);
        System.out.println(list.toString());
    }
}
