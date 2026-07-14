// Problem: Move Zeroes
// Link: https://leetcode.com/problems/move-zeroes/

// Pattern: Two Pointers (Same Direction / Slow-Fast)

// Trigger:
// - In-place array modification
// - Preserve relative order
// - Move all zeroes to the end
// - No extra array allowed

// Approach:
// - Use fast pointer to scan the array
// - Use slow pointer to track the next position for a non-zero element
// - Copy every non-zero element to nums[slow]
// - Increment slow after each write
// - After traversal, fill the remaining positions with zeroes

// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Insight:
// - Fast scans the array, while slow builds the final arrangement
// - After placing all non-zero elements, the remaining positions must be zero

class Solution {
public void moveZeroes(int[] nums) {

```
    int slow = 0;

    for (int fast = 0; fast < nums.length; fast++) {

        if (nums[fast] != 0) {
            nums[slow] = nums[fast];
            slow++;
        }
    }

    while (slow < nums.length) {
        nums[slow] = 0;
        slow++;
    }
}
```

}
