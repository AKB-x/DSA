## 📦 Valid Parentheses

### LeetCode 20 — Valid Parentheses

**Pattern:** Stack

**Approach:**
- Use a stack to store opening brackets.
- If the current character is an opening bracket `(`, `{`, `[`, push it into the stack.
- If the current character is a closing bracket, check whether the stack is empty.
- If the stack is empty, there is no opening bracket to match it, so return `false`.
- Otherwise, check whether the closing bracket matches the top of the stack.
- If it matches, pop the opening bracket.
- If it does not match, return `false`.
- After processing the complete string, the stack must be empty for the parentheses to be valid.

**Time Complexity:** `O(n)`

**Space Complexity:** `O(n)`

### Solution

```java
class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == '(' || 
               s.charAt(i) == '{' || 
               s.charAt(i) == '['){

                stack.push(s.charAt(i));

            } else {

                if(stack.isEmpty()){
                    return false;
                }

                if((s.charAt(i) == ')' && stack.peek() == '(') ||
                   (s.charAt(i) == ']' && stack.peek() == '[') ||
                   (s.charAt(i) == '}' && stack.peek() == '{')){

                    stack.pop();

                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
