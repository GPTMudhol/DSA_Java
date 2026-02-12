// Brute Force Approach
// Time Compliexity  O(2ⁿ)
// Space Complexity  O(n)

class Solution {
    int result = Integer.MAX_VALUE;

    public int splitArray(int[] nums, int k) {
        helper(nums, 0, k, 0, 0);
        return result;
    }

    private void helper(int[] nums, int index, int k, int currentSum, int maxSum) {
        if (index == nums.length) {
            if (k == 0) {
                result = Math.min(result, maxSum);
            }
            return;
        }

        if (k < 0) return;

        // Continue current subarray
        helper(nums, index + 1, k, currentSum + nums[index],
                Math.max(maxSum, currentSum + nums[index]));

        // Start new subarray
        helper(nums, index + 1, k - 1, nums[index],
                Math.max(maxSum, nums[index]));
    }
}

