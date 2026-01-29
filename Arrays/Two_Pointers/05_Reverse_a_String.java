
import java.util.Arrays;

public class Solution {

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[] s = {'h', 'e', 'l', 'l', 'o'};
        sol.reverseString(s);

        System.out.println(Arrays.toString(s));
        // Output: [o, l, l, e, h]
    }
}
