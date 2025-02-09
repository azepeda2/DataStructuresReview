

class Node {
    public int data;
    public Node next;
}

public class LinkedList {
    public Node head;

    LinkedList() {
        this.head = null;
    }

    LinkedList(Node node) {
        this.head = node;
    }

    void append(Node node) {
        if (head == null) {
            head = node;
            return;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    void insertAtBeginning(Node node) {
        node.next = head;
        head = node;
    }

    void insert(Node node, int index) {
        Node current = head;
        int i = 0;

        while(i < index && current.next != null) {
            current = current.next;
            i++;
        }

        if (i < index) {
            return;
        }

        node.next = current.next;
        current.next = node;
    }

    void deleteLast() {
        Node temp = head;
        while(temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    void deleteFirst() {
        Node temp = head;
        head = head.next;
        temp.next = null;
    }

    void deleteAt(int index) {
        Node current = head;
        int i = 0;

        while(i < index && current.next != null) {
            current = current.next;
            i++;
        }

        if (i < index) {
            return;
        }

        Node temp = current;
        current = current.next;
        temp.next = null;
    }

    Node getIndex(int index) {
        Node current = head;
        int i = 0;

        while(i < index && current.next != null) {
            current = current.next;
            i++;
        }

        if (i < index) {
            return null;
        }

        return current;
    }
    
}
