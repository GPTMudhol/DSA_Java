// Min Stack problem 


// Brute Force Approach 
// Time Complexity for(push,pop,top) = O(1),getmin() O(n)
// Space Complexity = O(n)

import java.util.*;

class MinStack {

    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int num : stack) {
            min = Math.min(min, num);
        }
        return min;
    }
}


// Optimal Approach 
// Time Complexity O(1)
// getmin O(1)
// Space Complexity O(n)

import java.util.*;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}



// Most Optimal Approach
// Time Complexity: O(1) for all operations
// Space Complexity: O(n)

import java.util.*;

class MinStack {

    Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push((long) val);
            min = val;
        } else {
            if (val < min) {
                stack.push(2L * val - min);
                min = val;
            } else {
                stack.push((long) val);
            }
        }
    }

    public void pop() {
        if (stack.peek() < min) {
            min = 2 * min - stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        if (stack.peek() < min) {
            return (int) min;
        }
        return stack.peek().intValue();
    }

    public int getMin() {
        return (int) min;
    }
}

