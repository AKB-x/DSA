## 📦 Daily Temperatures

### LeetCode 739 — Daily Temperatures

**Pattern:** Monotonic Stack

**Approach:**
- Traverse the array from right to left.
- Use a monotonic decreasing stack storing indices of future temperatures.
- Pop indices whose temperatures are less than or equal to the current temperature.
- If the stack is empty, no warmer day exists, so `result[i] = 0`.
- Otherwise, the top of the stack is the nearest warmer day, so store `stack.peek() - i`.
- Push the current index onto the stack.

**Time Complexity:** O(N)

**Space Complexity:** O(N)

### Solution

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            int current = temperatures[i];

            while(!stack.isEmpty() &&
                  current >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return result;
    }
}
