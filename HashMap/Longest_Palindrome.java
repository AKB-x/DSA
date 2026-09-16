## 📦 Longest Palindrome

### LeetCode 409 — Longest Palindrome

**Pattern:** HashMap — Frequency Counting

**Approach:**
- Use a `HashMap<Character, Integer>` to store the frequency of each character.
- Iterate through the unique characters in the map.
- If a character has an even frequency, use all of its occurrences.
- If a character has an odd frequency, use `count - 1` occurrences to form matching pairs.
- Keep track of whether at least one odd frequency exists.
- If an odd frequency exists, add `1` to place one character in the center of the palindrome.
- Return the maximum possible palindrome length.

**Time Complexity:** O(N)

**Space Complexity:** O(K), where `K` is the number of distinct characters.

### Solution

```java
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        boolean hasOdd = false;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch : map.keySet()) {
            int count = map.get(ch);

            if(count % 2 == 0) {
                result += count;
            } else {
                result += (count / 2) * 2;
                hasOdd = true;
            }
        }

        if(hasOdd) {
            result++;
        }

        return result;
    }
}
