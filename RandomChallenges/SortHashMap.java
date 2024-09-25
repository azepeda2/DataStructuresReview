import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortHashMap {
    public static Map<String, Double> sortByValue(Map<String, Double> map) {
        List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(map.entrySet());

        // Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
        // public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double>
        // o2) {
        // return (o1.getValue()).compareTo(o2.getValue());
        // }
        // });

        Collections.sort(list, (item1, item2) -> item1.getValue().compareTo(item2.getValue()));

        Map<String, Double> sortedMap = new HashMap<>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static void printMap(Map<String, Double> map) {
        for (Map.Entry<String, Double> en : map.entrySet()) {

            System.out.println("Key = " + en.getKey() +

                    ", Value = " + en.getValue());

        }
    }

    public static void main(String[] args) {
        Map<String, Double> itemCostMap = new HashMap<>();
        itemCostMap.put("burger", 5.00);
        itemCostMap.put("fries", 3.50);
        itemCostMap.put("shake", 4.25);
        itemCostMap.put("pie", 1.50);

        printMap(itemCostMap);
        Map<String, Double> sortedMap = sortByValue(itemCostMap);
        printMap(sortedMap);
    }
}
