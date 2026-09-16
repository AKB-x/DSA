## 📦 First Unique Character in a String

### LeetCode 387 — First Unique Character in a String

**Pattern:** HashMap — Frequency Counting

**Approach:**
- Use a `HashMap<Character, Integer>` to store the frequency of every character.
- Traverse the string once to build the frequency map.
- Traverse the string again in the original order.
- Return the index of the first character whose frequency is `1`.
- If no unique character exists, return `-1`.

**Time Complexity:** O(N)

**Space Complexity:** O(K), where `K` is the number of distinct characters.

### Solution

```java
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }
}
