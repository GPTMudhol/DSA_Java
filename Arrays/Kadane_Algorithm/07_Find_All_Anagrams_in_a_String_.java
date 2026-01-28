
import java.util.*;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> map = new HashMap<>();

        // Build frequency map for p
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int matched = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);

            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) {
                    matched++;
                }
            }
            right++;

            // When window size equals p length
            if (right - left == p.length()) {
                if (matched == map.size()) {
                    result.add(left);
                }

                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matched--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                left++;
            }
        }

        return result;
    }

 
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> output = solution.findAnagrams(s, p);

        System.out.println("Anagram starting indices: " + output);
    }
}
