// Brute Force Approach
// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.*;

public class SimplifyPathBrute {

    public static String simplifyPath(String path) {

        String[] parts = path.split("/");
        List<String> list = new ArrayList<>();

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else {
                list.add(part);
            }
        }

        String result = "";

        for (String dir : list) {
            result += "/" + dir;   // costly string concatenation
        }

        return result.length() == 0 ? "/" : result;
    }
}


// Better Approach
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

public class SimplifyPathBetter {

    public static String simplifyPath(String path) {

        String[] parts = path.split("/");
        List<String> list = new ArrayList<>();

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else {
                list.add(part);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String dir : list) {
            result.append("/").append(dir);
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}


// Optimal Approach (Using Stack)
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

public class SimplifyPathOptimal {

    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}
