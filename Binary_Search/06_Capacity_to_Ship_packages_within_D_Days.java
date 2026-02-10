// Brute Force Approach 
// Time Complexity: O((sum - max) * n)
// Space Complexity: O(1)

class Solution {

    private int findDays(int[] weights, int cap) {
        int days = 1;
        int load = 0;

        for (int w : weights) {
            if (load + w > cap) {
                days++;
                load = w;
            } else {
                load += w;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;
        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }

        for (int cap = max; cap <= sum; cap++) {
            if (findDays(weights, cap) <= days) {
                return cap;
            }
        }
        return sum;
    }
}
