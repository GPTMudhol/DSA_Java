// Brute Force Approach
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int left = i;
            int right = i;

            // expand left
            while (left >= 0 && heights[left] >= height) {
                left--;
            }

            // expand right
            while (right < n && heights[right] >= height) {
                right++;
            }

            int width = right - left - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
