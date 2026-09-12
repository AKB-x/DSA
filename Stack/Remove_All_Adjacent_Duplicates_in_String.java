## 📦 Remove All Adjacent Duplicates in String

### LeetCode 1047 — Remove All Adjacent Duplicates In String

**Pattern:** Stack

**Approach:**
- Use a stack to keep track of characters that have not been removed.
- If the stack is empty, push the current character.
- If the current character is the same as the top of the stack, pop the top because they form a duplicate pair.
- Otherwise, push the current character.
- Removing a pair can create a new adjacent duplicate pair, and the stack automatically handles this.
- Since we use `push()`, the characters are stored in reverse order, so use `removeLast()` to construct the final answer in the correct order.

**Time Complexity:** `O(n)`

**Space Complexity:** `O(n)`

### Solution

class Solution {
    public String removeDuplicates(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == current) {
                stack.pop();
            } else {
                stack.push(current);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.removeLast());
        }

        return result.toString();
    }
}
