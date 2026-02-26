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
