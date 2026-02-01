// Brute Force Approach O(n*D) 
// (N = trips, D = distance between start & end)
  

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] road = new int[1001];

        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            for (int i = start; i < end; i++) {
                road[i] += passengers;
                if (road[i] > capacity) {
                    return false;
                }
            }
        }

        return true;
    }
}


// Optimal Approach 

// Time: O(N + 1000) → effectively O(N)
// Space: O(1000) (constant)

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];

        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            diff[start] += passengers;
            diff[end] -= passengers;
        }

        int curr = 0;
        for (int i = 0; i < diff.length; i++) {
            curr += diff[i];
            if (curr > capacity) {
                return false;
            }
        }

        return true;
    }
}
