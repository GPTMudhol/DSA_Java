// Brute Force Approach
// Time Complexity: O(n²)
// Space Complexity: O(n)

public int[] asteroidCollision(int[] asteroids) {
    List<Integer> list = new ArrayList<>();
    for (int a : asteroids) {
        list.add(a);
    }

    boolean changed = true;

    while (changed) {
        changed = false;
        for (int i = 0; i < list.size() - 1; i++) {

            int first = list.get(i);
            int second = list.get(i + 1);

            if (first > 0 && second < 0) {

                if (Math.abs(first) > Math.abs(second)) {
                    list.remove(i + 1);
                } else if (Math.abs(first) < Math.abs(second)) {
                    list.remove(i);
                } else {
                    list.remove(i + 1);
                    list.remove(i);
                }

                changed = true;
                break;
            }
        }
    }

    return list.stream().mapToInt(i -> i).toArray();
}


// Better Approach (Stack)
// Time Complexity: O(n)
// Space Complexity: O(n)

public int[] asteroidCollision(int[] asteroids) {

    Stack<Integer> stack = new Stack<>();

    for (int asteroid : asteroids) {

        boolean destroyed = false;

        while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {

            if (stack.peek() < -asteroid) {
                stack.pop();
                continue;
            } else if (stack.peek() == -asteroid) {
                stack.pop();
            }

            destroyed = true;
            break;
        }

        if (!destroyed) {
            stack.push(asteroid);
        }
    }

    int[] result = new int[stack.size()];
    for (int i = stack.size() - 1; i >= 0; i--) {
        result[i] = stack.pop();
    }

    return result;
}


// Optimal Approach (Using Array as Stack)
// Time Complexity: O(n)
// Space Complexity: O(n)

public int[] asteroidCollision(int[] asteroids) {

    int[] stack = new int[asteroids.length];
    int top = -1;

    for (int asteroid : asteroids) {

        boolean destroyed = false;

        while (top >= 0 && asteroid < 0 && stack[top] > 0) {

            if (stack[top] < -asteroid) {
                top--;
                continue;
            } else if (stack[top] == -asteroid) {
                top--;
            }

            destroyed = true;
            break;
        }

        if (!destroyed) {
            stack[++top] = asteroid;
        }
    }

    return Arrays.copyOf(stack, top + 1);
}
