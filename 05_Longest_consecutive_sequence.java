// Brute Force Approach 
// Time Complexity O(n^2)
// Space Complexity O (1)


public class Solution {

    static boolean linearSearch(int[] arr, int num) {
        for (int x : arr) {
            if (x == num) return true;
        }
        return false;
    }

    public static int longestConsecutive(int[] arr) {
        int n = arr.length;
        int longest = 0;

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int count = 1;

            while (linearSearch(arr, x + 1)) {
                x++;
                count++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}


