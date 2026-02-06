// Brute Force Approach 
// Time Complexity: O(n * m)
// Space Complexity: O(m)

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder sb = new StringBuilder(magazine);

        for (char c : ransomNote.toCharArray()) {
            int idx = sb.indexOf(String.valueOf(c));
            if (idx == -1) {
                return false;
            }
            sb.deleteCharAt(idx);
        }
        return true;
    }
}


// Better Approach (HashMap) 
// Time Complexity: O(n + m)
// Space Complexity: O(n)

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
