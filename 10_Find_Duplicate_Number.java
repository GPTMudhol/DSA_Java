// Brute Force Approach 
// Time Complexity: O(n)
// Space Complexity: O(n)


class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return num;
            }
            map.put(num, 1);
        }
        return -1;
    }
}


// Time Complexity: O(n log n)
// Space Complexity: O(1)  

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
