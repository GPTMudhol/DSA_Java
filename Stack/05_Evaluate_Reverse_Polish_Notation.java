// Brute Force Approach
// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {

        List<String> list = new ArrayList<>(Arrays.asList(tokens));

        while (list.size() > 1) {

            for (int i = 0; i < list.size(); i++) {

                String token = list.get(i);

                if (isOperator(token)) {

                    int a = Integer.parseInt(list.get(i - 2));
                    int b = Integer.parseInt(list.get(i - 1));

                    int result = 0;

                    if (token.equals("+")) result = a + b;
                    else if (token.equals("-")) result = a - b;
                    else if (token.equals("*")) result = a * b;
                    else result = a / b;

                    list.remove(i);
                    list.remove(i - 1);
                    list.remove(i - 2);

                    list.add(i - 2, String.valueOf(result));
                    break;
                }
            }
        }
        return Integer.parseInt(list.get(0));
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") ||
               s.equals("*") || s.equals("/");
    }
}
