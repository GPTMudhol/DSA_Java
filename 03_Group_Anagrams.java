/// Brute Force Approach 
// Time Complexity: O(n² * m log m)
// Space Complexity: O(n)

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        boolean[] used = new boolean[strs.length];
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {

            if (used[i]) continue;

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            used[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                if (!used[j] && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    used[j] = true;
                }
            }

            result.add(group);
        }

        return result;
    }

    private boolean isAnagram(String a, String b) {

        if (a.length() != b.length()) return false;

        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        Arrays.sort(ca);
        Arrays.sort(cb);

        return Arrays.equals(ca, cb);
    }
}


// Optimal Approach 
// Time Complexity: O(n * m)
// Space Complexity: O(n)

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                key.append('#').append(count[i]);
            }

            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
