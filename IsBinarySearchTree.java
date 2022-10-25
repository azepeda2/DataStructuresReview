public class IsBinarySearchTree {
    public static boolean isBST(Node node, Integer lowerLimit, Integer upperLimit) {
        if (lowerLimit != null && node.data < lowerLimit)
            return false;

        if (upperLimit != null && upperLimit < node.data)
            return false;

        boolean isLeftNode = true;
        boolean isRightNode = true;

        if (node.left != null)
            isLeftNode = isBST(node.left, lowerLimit, node.data);

        if (node.right != null)
            isRightNode = isBST(node.right, node.data, upperLimit);

        return isLeftNode && isRightNode;
    }

    public static void main(String[] args) {
        Node zero = new Node(0, null, null);
        Node two = new Node(2, null, null);
        Node three = new Node(3, null, null);
        Node six = new Node(6, null, null);
        Node one = new Node(1, zero, two);
        Node five = new Node(5, three, six);
        Node four = new Node(4, one, five);

        Node head = four;
        System.out.println("Is Node? " + isBST(head, null, null));
        // this one should return false. change three to null in five to make true
    }

    static public class Node {
        public Integer data;
        public Node left;
        public Node right;

        Node(Integer data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
