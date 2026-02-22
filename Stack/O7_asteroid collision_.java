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
