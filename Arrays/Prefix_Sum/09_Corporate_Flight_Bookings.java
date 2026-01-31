// Brute Force Approach


class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            int first = bookings[i][0];
            int last = bookings[i][1];
            int seats = bookings[i][2];

            for (int j = first - 1; j <= last - 1; j++) {
                ans[j] += seats;
            }
        }
        return ans;
    }
}



// Optimal Approach 

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];

        for (int[] b : bookings) {
            int first = b[0] - 1;
            int last = b[1] - 1;
            int seats = b[2];

            diff[first] += seats;
            if (last + 1 < n) {
                diff[last + 1] -= seats;
            }
        }

        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }

        return diff;
    }
}
