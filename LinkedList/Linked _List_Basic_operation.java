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
