// Brute Force Approach 

public class BruteForceMaxSizeSubarray {

    public static int maxSubArrayLen(int[] nums, int k) {
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;

        System.out.println(maxSubArrayLen(nums, k)); // Output: 4
    }
}


// Optimal Approach 


