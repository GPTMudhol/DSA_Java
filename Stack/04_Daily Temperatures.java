// Brute Force Approach
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }

        return result;
    }
}


// Better Approach (Monotonic Stack using Deque)
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Resolve all previous colder days
            while (!stack.isEmpty() && 
                   temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            // Push current index
            stack.push(i);
        }

        return result;
    }
}



// Optimal Approach (Monotonic Stack)
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && 
                   temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
}
