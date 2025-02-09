import java.util.HashSet;
import java.util.Set;

class Node {
    public int data;
    public Node next;

    Node (int val) {
        this.data = val;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    LinkedList() {
        this.head = null;
    }

    LinkedList(int val) {
        Node node = new Node(val);
        this.head = node;
        this.tail = node;
        length = 1;
    }

    void append(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            return;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    void prepend(int val) {
        Node node = new Node(val);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        length++;
    }

    boolean insert(int index, int val) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(val);
            return true;
        }
        if (index == length) {
            append(val);
            return true;
        }
        Node node = new Node(val);
        Node temp = getIndex(index - 1);
        node.next = temp.next;
        temp.next = node;
        length++;
        return true;
    }

    void deleteLast() {
        if (length == 0) return;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            Node pre = head;
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
            }

            tail = pre;
            tail.next = null;
        }

        length--;
    }

    void deleteFirst() {
        if (length == 0) return;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        length--;
    }

    void deleteAt(int index) {
        if (index < 0 || index >= length) return;
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == length - 1) {
            deleteLast();
            return;
        }

        Node prev = getIndex(index - 1);
        prev.next = prev.next.next;
        length--;

    }

    Node getIndex(int index) {
        if (index < 0 || index >= length) return null;
        Node current = head;
        for(int i = 0; i < index && current.next != null; i++) {
            current = current.next;
        }

        return current;
    }

    boolean set(int index, int val) {
        Node temp = getIndex(index);
        if (temp != null) {
            temp.data = val;
            return true;
        }

        return false;
    }

    void printList() {
        Node temp = head;
        if (temp == null) {
            System.out.println("empty");
        } else {
            while (temp != null) {
                System.out.print(temp.data);
                temp = temp.next;
                if (temp != null) {
                    System.out.print(" -> ");
                }
            }
        }
        System.out.println();
    }

    Node getHead() {
        return head;
    }

    Node getTail() {
        return tail;
    }

    int getLength() {
        return length;
    }

    void reverse() {
        if (head == null || head == tail) {
            return;
        }

        Node prev = null;
        Node current = head;
        Node nextNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        tail = head;
        head = prev;
    }

    Node findMiddleNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (slow != null && slow.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;

            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    void partitionList(int x) {
        if (head == null) return;

        Node lessList = new Node(0);
        Node moreList = new Node(0);
        Node lessHead = lessList;
        Node moreHead = moreList;
        Node temp = head;

        while (temp != null) {
            if (temp.data < x) {
                lessList.next = temp;
                lessList = temp;
            } else {
                moreList.next = temp;
                moreList = temp;
            }

            temp = temp.next;
        }

        moreList.next = null;
        lessList.next = moreHead.next;
        head = lessHead.next;
    }

    void removeDuplicates() {
        if (head != null) return;

        Set<Integer> values = new HashSet<Integer>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (values.contains(current.data)) {
                prev.next = current.next;
                current = prev.next;
                length--;
            } else {
                values.add(current.data);
                prev = current;
                current = current.next;
            }
        }
    }

    int binaryToDecimal() {
        Node current = head;
        int num = 0;

        while (current != null) {
            num = num * 2 + current.data;
            current = current.next;
        }

        return num;
    }

    void reverseBetween(int m, int n) {
        if (head == null) return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node current = null;
        Node temp = null;

        for (int i = 0; i < m; i++) {
            if (prev == null) return;

            prev = prev.next;
        }

        current = prev.next;

        for (int i = m; i < n; i++) {
            temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        head = dummy.next;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);

        ll.getHead();
        ll.getTail();
        ll.getLength();
        ll.printList();

        for (int i = 2; i < 5; i++)
        {
            ll.append(i);
        }

        ll.printList();
        ll.deleteLast();
        ll.printList();

        ll.deleteLast();
        ll.printList();

        ll.deleteLast();
        ll.printList();

        ll.deleteLast();
        ll.printList();

        ll.deleteLast();
        ll.printList();

        ll.append(2);
        ll.append(3);
        ll.prepend(1);
        ll.printList();

        ll.deleteFirst();
        ll.printList();
        ll.deleteFirst();
        ll.printList();
        ll.deleteFirst();
        ll.printList();
        ll.deleteFirst();
        ll.printList();

        ll.append(0);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.printList();
        System.out.println("Value at index 2: " + ll.getIndex(2).data);

        ll.set(2, 10);
        ll.printList();
        System.out.println("Value at index 2: " + ll.getIndex(2).data);
        ll.deleteFirst();
        ll.deleteLast();
        ll.deleteLast();


        ll.printList();
        ll.insert(0, 0);
        ll.insert(2, 3);
        ll.insert(2, 2);
        ll.printList();

        ll.deleteAt(4);
        ll.printList();
        ll.deleteAt(3);
        ll.printList();
        ll.deleteAt(0);
        ll.printList();
        ll.deleteAt(1);
        ll.printList();

        for (int i = 2; i < 5; i++)
        {
            ll.append(i);
        }

        ll.printList();
        ll.reverse();
        ll.printList();
        ll.reverse();
        ll.printList();
    }
    
    
}
