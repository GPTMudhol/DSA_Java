// Brute Force Approach
// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.*;

class StockSpanner {

    private List<Integer> prices;

    public StockSpanner() {
        prices = new ArrayList<>();
    }

    public int next(int price) {
        prices.add(price);
        int span = 1;
        int i = prices.size() - 2;

        while (i >= 0 && prices.get(i) <= price) {
            span++;
            i--;
        }

        return span;
    }
}


// Better Approach
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class StockSpanner {

    private Stack<Integer> stack;
    private List<Integer> prices;
    private int index;

    public StockSpanner() {
        stack = new Stack<>();
        prices = new ArrayList<>();
        index = -1;
    }

    public int next(int price) {
        index++;
        prices.add(price);

        while (!stack.isEmpty() && prices.get(stack.peek()) <= price) {
            stack.pop();
        }

        int span;
        if (stack.isEmpty()) {
            span = index + 1;
        } else {
            span = index - stack.peek();
        }

        stack.push(index);

        return span;
    }
}
