// Problem: Valid Palindrome
// Link: https://leetcode.com/problems/valid-palindrome/

// Pattern: Two Pointers (Opposite Direction)

// Trigger:
// - Palindrome validation
// - Compare characters from both ends
// - Ignore non-alphanumeric characters

// Approach:
// - Start left and right pointers at opposite ends
// - Skip non-alphanumeric characters using while loops
// - Compare valid characters after converting them to lowercase
// - If characters differ, return false
// - If characters match, move both pointers inward

// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Insight:
// - Compare directly in the original string instead of creating a reversed copy
// - Use while instead of if because multiple invalid characters may appear consecutively

class Solution {
public boolean isPalindrome(String s) {
int left = 0;
int right = s.length() - 1;

```
    while (left < right) {
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }

        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        }

        if (Character.toLowerCase(s.charAt(left)) !=
            Character.toLowerCase(s.charAt(right))) {
            return false;
        }

        left++;
        right--;
    }

    return true;
}
```

}
