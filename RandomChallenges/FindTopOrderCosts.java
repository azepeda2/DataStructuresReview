public class FindTopOrderCosts {
    // Get a file of orders and add up the item costs per order and print out the top 3
    // have file input for real question.

    public static void extractInfo(String line) {
        String[] orderInfo = line.split(", ");
        String orderId = orderInfo[0];
        String itemNum = orderInfo[1];
        Double itemPrice = Double.valueOf(orderInfo[2].substring(1));
        String customerId = orderInfo[3];

        System.out.println(orderId + " | " + itemNum + " | " + itemPrice + " | " +  customerId);
    }
    



    public static void main(String[] args) {
        String sampleLine = "order001, item005, $5.00, customerA";
        extractInfo(sampleLine);
        
    }
}
