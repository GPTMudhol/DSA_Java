public class LinkedListDemo {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // Head of the list
    Node head;

    
    // INSERT OPERATIONS

    // Insert at Beginning
    // Time Complexity: O(1)
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at End
    // Time Complexity: O(n)
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Insert at Position (1-based index)
    // Time Complexity: O(n)
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }


    
    // DELETE OPERATIONS

    // Delete from Beginning
    // Time Complexity: O(1)
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Delete from End
    // Time Complexity: O(n)
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    // Delete by Value
    // Time Complexity: O(n)
    public void deleteByValue(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found");
            return;
        }

        temp.next = temp.next.next;
    }


    
    // SEARCH

    // Search element
    // Time Complexity: O(n)
    public boolean search(int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    
    // TRAVERSAL

    // Display Linked List
    // Time Complexity: O(n)
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    
    // SEARCH

    // Search element
    // Time Complexity: O(n)
    public boolean search(int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // ==============================
    // TRAVERSAL
    // ==============================

    // Display Linked List
    // Time Complexity: O(n)
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    
    // ==============================
    // MAIN METHOD
    // ==============================

    public static void main(String[] args) {

        LinkedListDemo list = new LinkedListDemo();

        // Insert operations
        list.insertAtBeginning(10);
        list.insertAtBeginning(5);
        list.insertAtEnd(20);
        list.insertAtPosition(15, 3);

        System.out.println("Linked List after insertions:");
        list.display();

        // Delete operations
        list.deleteFromBeginning();
        list.deleteFromEnd();
        list.deleteByValue(15);

        System.out.println("Linked List after deletions:");
        list.display();

        // Search
        System.out.println("Is 10 present? " + list.search(10));
    }
            }
