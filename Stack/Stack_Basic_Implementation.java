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


// Stack Using Deque

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}

// Stack Using Linked List

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if (top == null) {
            System.out.println("Underflow");
            return -1;
        }
        int val = top.data;
        top = top.next;
        return val;
    }
}
