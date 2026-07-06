// Problem: Two Sum II - Input Array Is Sorted
// Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

// Pattern: Two Pointers (Sorted Search Space)

// Trigger:
// - Sorted array
// - Find a pair with a target sum
// - Return indices of two elements

// Approach:
// - Start left and right pointers at opposite ends
// - Calculate the sum of numbers[left] and numbers[right]
// - If sum equals target, return the 1-indexed positions
// - If sum is smaller than target, move left forward
// - If sum is greater than target, move right backward

// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Insight:
// - If sum < target, the current left value is too small and can be discarded
// - If sum > target, the current right value is too large and can be discarded
// - Sorted order proves which pointer must move

class Solution {
public int[] twoSum(int[] numbers, int target) {
int left = 0;
int right = numbers.length - 1;

```
    while (left < right) {
        int sum = numbers[left] + numbers[right];

        if (sum == target) {
            return new int[]{left + 1, right + 1};
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }

    return new int[]{};
}
```

}
