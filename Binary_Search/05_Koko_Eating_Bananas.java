// Brute Force Approach
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}


// Better Approach (Sorting)
// Time Complexity: O(n log n)
// Space Complexity: O(1)

import java.util.Arrays;

class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}

// Optimal Approach (Binary Search)
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
