
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // frequency of s1
        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        int windowSize = s1.length();

        // first window
        for (int i = 0; i < windowSize; i++) {
            freq2[s2.charAt(i) - 'a']++;
        }

        if (isSame(freq1, freq2)) return true;

        // slide window
        for (int i = windowSize; i < s2.length(); i++) {
            // add new char
            freq2[s2.charAt(i) - 'a']++;
            // remove old char
            freq2[s2.charAt(i - windowSize) - 'a']--;

            if (isSame(freq1, freq2)) return true;
        }

        return false;
    }

    private boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
