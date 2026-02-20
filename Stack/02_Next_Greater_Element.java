// Brute Force Approach
// Time Complexity: O(n * m)
// Space Complexity: O(1)

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            int index = -1;
            
            // Find index in nums2
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    index = j;
                    break;
                }
            }
            
            // Find next greater element
            int nextGreater = -1;
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    nextGreater = nums2[j];
                    break;
                }
            }
            
            result[i] = nextGreater;
        }
        
        return result;
    }
}


// Better Approach
// Time Complexity: O(m² + n)
// Space Complexity: O(m)

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int m = nums2.length;
        int[] nextGreater = new int[m];
        
        // Step 1: Compute next greater for nums2
        for (int i = 0; i < m; i++) {
            nextGreater[i] = -1;
            for (int j = i + 1; j < m; j++) {
                if (nums2[j] > nums2[i]) {
                    nextGreater[i] = nums2[j];
                    break;
                }
            }
        }
        
        // Step 2: Build result for nums1
        int[] result = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    result[i] = nextGreater[j];
                    break;
                }
            }
        }
        
        return result;
    }
}
