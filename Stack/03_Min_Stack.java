// Brute Force Approach
// Time Complexity: O(n²)
// Space Complexity: O(n)

class Solution {
    public boolean isValid(String s) {
        
        while (s.contains("()") || 
               s.contains("{}") || 
               s.contains("[]")) {
            
            s = s.replace("()", "")
                 .replace("{}", "")
                 .replace("[]", "");
        }
        
        return s.isEmpty();
    }
}


// Better Approach
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                    
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                    
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                    
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
            }
        }
        
        return stack.isEmpty();
    }
}

// Optimal Approach
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char ch : s.toCharArray()) {
            
            if (ch == '(') stack.push(')');
            else if (ch == '{') stack.push('}');
            else if (ch == '[') stack.push(']');
            else {
                if (stack.isEmpty() || stack.pop() != ch)
                    return false;
            }
        }
        
        return stack.isEmpty();
    }
}
