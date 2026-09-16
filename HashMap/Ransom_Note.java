## 📦 Ransom Note

### LeetCode 383 — Ransom Note

**Pattern:** HashMap — Frequency Counting / Consume Resources

**Approach:**
- Use a `HashMap<Character, Integer>` to store the frequency of each character available in `magazine`.
- Traverse `ransomNote` character by character.
- Check whether the current character exists in the map and still has available occurrences.
- If the character does not exist or its frequency reaches `0`, return `false`.
- Otherwise, consume one occurrence by decreasing its frequency.
- If all characters in `ransomNote` can be consumed, return `true`.

**Time Complexity:** O(M + N)

**Space Complexity:** O(K), where `K` is the number of distinct characters in `magazine`.

### Solution

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Storing magazine frequency
        for(int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Checking and consuming characters
        for(int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);

            if(!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }

        return true;
    }
}
