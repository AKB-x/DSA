```java
// Problem: Minimum Window Substring
// Link: https://leetcode.com/problems/minimum-window-substring/

// Pattern: Sliding Window (Advanced)

// Trigger:
// - Smallest substring
// - Must contain all characters of another string
// - Frequency-based matching

// Approach:
// - Create a frequency map (need) from string t
// - Use another map (window) to track current window
// - Expand window using right pointer
// - When frequency matches required → increment 'have'
// - When have == needCount → window is valid
// - Shrink window from left to minimize size
// - Track smallest valid window

// Time Complexity: O(n)
// Space Complexity: O(n)

// Key Insight:
// - We need at least required frequency (not exact match)
// - 'have' tracks how many characters are satisfied
// - Shrink window only when it is valid

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0;
        int needCount = need.size();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            // ADD
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            // CHECK MATCH
            if (need.containsKey(ch) &&
                window.get(ch).equals(need.get(ch))) {
                have++;
            }
            // SHRINK
            while (have == needCount) {
                // UPDATE ANSWER
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) &&
                    window.get(leftChar) < need.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
```
