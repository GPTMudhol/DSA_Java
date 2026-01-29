import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i + 1}; // 1-based index
            }

            map.put(numbers[i], i + 1); // store 1-based index
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] result = sol.twoSum(numbers, target);

        System.out.println(result[0] + ", " + result[1]);
        // Output: 1, 2
    }
}
