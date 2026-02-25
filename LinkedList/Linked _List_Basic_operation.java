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

    // ==============================
    // DELETE OPERATIONS
    // ==============================

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
