// Stack Implementation Using Array

class Stack {
    int[] arr;
    int top;
    int capacity;

    Stack(int size) {
        capacity = size;
        arr = new int[size];
        top = -1;
    }

    // Push Operation
    void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    // Pop Operation
    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    // Peek Operation
    int peek() {
        if (top == -1) {
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }
}


// Stack Using Java Built-in Stack Class

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());   // 30
        System.out.println(stack.peek());  // 20
        System.out.println(stack.isEmpty());
    }
}

