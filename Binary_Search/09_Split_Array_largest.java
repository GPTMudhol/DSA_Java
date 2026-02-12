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



// Better Approach (DP)
// Time Complexity  O(n^2 * k)
// Space Complexity  O(n * k)

class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + nums[i];

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                dp[i][j] = Integer.MAX_VALUE;

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int p = 0; p < i; p++) {
                    dp[i][j] = Math.min(dp[i][j],
                            Math.max(dp[p][j - 1],
                                     prefix[i] - prefix[p]));
                }
            }
        }

        return dp[n][k];
    }
}


