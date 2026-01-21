
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            // Skip non-alphanumeric characters
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            // Compare characters
            if (Character.toLowerCase(s.charAt(start)) !=
                Character.toLowerCase(s.charAt(end))) {
                return false;
            }

            // Move pointers
            start++;
            end--;
        }
        return true;
    }
}
public class Main{
  public static void main(String [] args){
    Solution obj = new Solution();
    char s = "Hello world";

    System.out.print(obj.isPalindrome(s));
  }
}
    
