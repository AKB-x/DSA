// Problem: Remove Duplicates from Sorted Array
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// Pattern: Two Pointers (Same Direction / Slow-Fast)

// Trigger:
// - Sorted array
// - Remove duplicates in-place
// - Keep unique elements in the first k positions

// Approach:
// - Use fast pointer to scan the array
// - Use slow pointer to track the last unique element
// - If nums[fast] equals nums[slow], the element is a duplicate
// - If nums[fast] differs from nums[slow], a new unique element is found
// - Move slow to the next position and copy nums[fast] there
// - Return slow + 1 as the number of unique elements

// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Insight:
// - Fast always explores the array
// - Slow moves only when fast finds a new unique element
// - nums[0...slow] always contains the unique elements found so far

class Solution {
public int removeDuplicates(int[] nums) {
int slow = 0;

```
    for (int fast = 1; fast < nums.length; fast++) {
        if (nums[fast] != nums[slow]) {
            slow++;
            nums[slow] = nums[fast];
        }
    }

    return slow + 1;
}
```

}
