// Brute Force Approach (HashMap)
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

// Better Approach (sorting)
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


// Optimal Approach (Floyd’s Cycle Detection) 
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
