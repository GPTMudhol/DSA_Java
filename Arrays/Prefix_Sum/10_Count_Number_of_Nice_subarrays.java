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


// Optimal Approach O(n)

public class Solution {

    public static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        int left = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) k--;

            while (k < 0) {
                if (nums[left] % 2 != 0) k++;
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }
}
