import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LowestCommonAncestor {
    public static Integer lca(Node node, Integer value1, Integer value2) {
        Stack<Integer> path1 = pathToX(node, value1);
        Stack<Integer> path2 = pathToX(node, value2);

        if (path1 == null || path2 == null)
            return null;

        Integer lcaAnswer = null;

        int path1Value;
        int path2Value;

        while (!path1.empty() && !path2.empty()) {
            path1Value = path1.pop();
            path2Value = path2.pop();

            if (path1Value == path2Value)
                lcaAnswer = path1Value;
            else
                break;
        }

        return lcaAnswer;
    }

    static Stack<Integer> pathToX(Node node, Integer value) {
        if (node == null)
            return null;

        if (node.data == value) {
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(node.data);
            return stack;
        }

        Stack<Integer> leftPath = pathToX(node.left, value);

        if (leftPath != null) {
            leftPath.push(node.data);
            return leftPath;
        }

        Stack<Integer> rightPath = pathToX(node.right, value);

        if (rightPath != null) {
            rightPath.push(node.data);
            return rightPath;
        }

        return null;
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

        System.out.println("Last Common Ancestor: " + lca(head, 0, 6));
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
