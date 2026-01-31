// Brute Force Approach

class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }
            res[i] = sum;
        }
        return res;
    }
}


// optimal Solution 

class Solution {

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] nums = {1, 2, 3, 4};
        int[] result = obj.runningSum(nums);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
