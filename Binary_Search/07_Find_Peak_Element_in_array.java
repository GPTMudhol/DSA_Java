// Brute Force Approach 
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean left = (i == 0) || nums[i] > nums[i - 1];
            boolean right = (i == n - 1) || nums[i] > nums[i + 1];

            if (left && right) {
                return i;
            }
        }
        return -1; // never reached
    }
}


// Optimal Approach (Binary Search)
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
