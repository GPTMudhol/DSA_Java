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


// Better Solution 
// Time Complexity O(n log n)
// Space Complexity O(1) (ignoring sort space)

import java.util.*;

public class Solution {

    public static int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;

        Arrays.sort(arr);

        int longest = 1;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) continue;
            else if (arr[i] == arr[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}


// Better Solution 
// Time Complexity O(n)
// Space Complexity O(n)

import java.util.*;

public class Solution {

    public static int longestConsecutive(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int longest = 1;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int x = num;
                int count = 1;

                while (set.contains(x + 1)) {
                    x++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
