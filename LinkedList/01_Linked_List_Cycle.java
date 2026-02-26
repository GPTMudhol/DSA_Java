// Brute Force Approach
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycleBrute {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        
        while (head != null) {
            if (set.contains(head)) {
                return true; // Cycle detected
            }
            set.add(head);
            head = head.next;
        }
        
        return false; // No cycle
    }
}


// Better Approach
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycleBetter {

    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> visited = new HashSet<>();

        ListNode current = head;

        while (current != null) {

            // If already visited → cycle
            if (visited.contains(current)) {
                return true;
            }

            visited.add(current);
            current = current.next;
        }

        return false; // No cycle
    }
}
