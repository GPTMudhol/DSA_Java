// Brute Force Approach
// Time: O(n²)
// Space: O(1)

class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }
            if (count == 1) return i;
        }
        return -1;
    }
}


// Optimal Approach (Recommended)
// Time: O(n)
// Space: O(1) (constant 26)

class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }
            if (count == 1) return i;
        }
        return -1;
    }
}

// Optimal Approach 
// Time: O(n)
// Space: O(1) (constant 26)

class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
