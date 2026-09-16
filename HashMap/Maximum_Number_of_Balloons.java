## 📦 Maximum Number of Balloons

### LeetCode 1189 — Maximum Number of Balloons

**Pattern:** HashMap — Frequency Counting / Limiting Resource

**Approach:**
- Store the required frequency of each character in `"balloon"` using a `HashMap`.
- Count the frequency of characters available in `text`.
- Iterate through the required characters.
- For each character, calculate how many complete copies can be formed using `have / need`.
- The minimum value among all required characters is the limiting resource.
- Return the minimum number of complete `"balloon"` strings that can be formed.

**Time Complexity:** O(N)

**Space Complexity:** O(K), where `K` is the number of distinct characters.

### Solution

```java
class Solution {
    public int maxNumberOfBalloons(String text) {
        int result = Integer.MAX_VALUE;

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();

        need.put('b', 1);
        need.put('a', 1);
        need.put('l', 2);
        need.put('o', 2);
        need.put('n', 1);

        for(int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            have.put(ch, have.getOrDefault(ch, 0) + 1);
        }

        for(char ch : need.keySet()) {
            if(have.containsKey(ch)) {
                int count = have.get(ch) / need.get(ch);
                result = Math.min(result, count);
            } else {
                return 0;
            }
        }

        return result;
    }
}
