// Brute Force Approach 
// Time Complexity O(n)
// Space Complexity O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == -1) first = i;
                last = i;
            }
        }
        return new int[]{first, last};
    }
}

// Better Approach 
// Time Complexity O(log n + k)
// Space Complexity O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int idx = binarySearch(nums, target);
        if (idx == -1) return new int[]{-1, -1};

        int left = idx, right = idx;

        while (left - 1 >= 0 && nums[left - 1] == target) left--;
        while (right + 1 < nums.length && nums[right + 1] == target) right++;

        return new int[]{left, right};
    }

    int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
