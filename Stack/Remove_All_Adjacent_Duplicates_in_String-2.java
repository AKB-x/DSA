## 📦 Remove All Adjacent Duplicates in String II

### LeetCode 1209 — Remove All Adjacent Duplicates in String II

**Pattern:** Stack + Character Frequency

**Approach:**
- Use a stack of `(character, count)` pairs to store consecutive character groups.
- If the stack is empty, push the current character with count `1`.
- If the current character matches the stack top, increment its count.
- When the count reaches `k`, pop the entire group.
- If the character doesn't match the stack top, push a new pair with count `1`.
- Removing a group can make previously separated characters adjacent; the stack naturally handles this chain reaction.
- Reconstruct the final string by traversing the remaining pairs and appending each character according to its count.

**Time Complexity:** `O(N)`

**Space Complexity:** `O(N)`

### Solution

```java
class Solution {

    class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(stack.isEmpty()) {
                stack.push(new Pair(ch, 1));
                continue;
            }

            if(stack.peek().ch == ch) {
                stack.peek().count++;

                if(stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                stack.push(new Pair(ch, 1));
            }
        }

        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty()) {
            Pair p = stack.removeLast();

            for(int j = 0; j < p.count; j++) {
                result.append(p.ch);
            }
        }

        return result.toString();
    }
}
