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

// Optimal Approach (Floyd’s Algorithm)
// Time Complexity: O(n)
// Space Complexity: O(1)

class LinkedListCycleOptimal {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 step
            fast = fast.next.next;     // 2 steps

            if (slow == fast) {
                return true;  // Cycle detected
            }
        }

        return false;  // No cycle
    }
}
