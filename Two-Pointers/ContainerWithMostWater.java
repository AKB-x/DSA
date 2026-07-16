// Problem: Container With Most Water
// Link: https://leetcode.com/problems/container-with-most-water/

// Pattern: Two Pointers (Opposite Direction)

// Trigger:
// - Two boundary lines
// - Maximize area
// - Width decreases every move
// - Choose the best pair of lines

// Approach:
// - Start with the leftmost and rightmost lines
// - Calculate the current container area
// - Update the maximum area found so far
// - Move the pointer with the smaller height
// - Repeat until both pointers meet

// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Insight:
// - The shorter line limits the water level
// - Moving the taller line cannot increase the area because the width decreases while the limiting height remains unchanged
// - Evaluate the current container before moving any pointer

class Solution {
public int maxArea(int[] height) {
int left = 0;
int right = height.length - 1;
int maxArea = 0;

```
    while (left < right) {

        int area = (right - left) * Math.min(height[left], height[right]);
        maxArea = Math.max(maxArea, area);

        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }

    return maxArea;
}
```

}
