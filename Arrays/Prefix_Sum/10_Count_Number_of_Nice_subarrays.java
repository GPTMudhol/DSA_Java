// Brute Force Approach O(n^2)


public class Solution {

    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int odd = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 != 0) odd++;
                if (odd == k) count++;
                if (odd > k) break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }
}
