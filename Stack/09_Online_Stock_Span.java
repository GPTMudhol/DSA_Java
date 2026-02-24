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
