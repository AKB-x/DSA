```java
/*
------------------------------------------------------------
Problem    : Trapping Rain Water
Platform   : LeetCode 42
Difficulty : Hard
Pattern    : Two Pointers
------------------------------------------------------------

Approach
--------
- Maintain two pointers from both ends.
- Track the maximum height seen from the left and right.
- Process the side with the smaller maximum, since its trapped
  water is already determined.
- Move the corresponding pointer and update its maximum.

Time Complexity : O(n)
Space Complexity: O(1)

------------------------------------------------------------
*/

class Solution {
    public int trap(int[] height) {

        if (height == null || height.length == 0)
            return 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int water = 0;

        while (left < right) {

            if (leftMax <= rightMax) {

                // Water at left is determined
                water += leftMax - height[left];

                left++;

                // Update left boundary
                leftMax = Math.max(leftMax, height[left]);

            } else {

                // Water at right is determined
                water += rightMax - height[right];

                right--;

                // Update right boundary
                rightMax = Math.max(rightMax, height[right]);
            }
        }

        return water;
    }
}
```
