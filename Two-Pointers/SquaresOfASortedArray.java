/*
------------------------------------------------------------
Problem    : 977. Squares of a Sorted Array
Platform   : LeetCode
Difficulty : Easy
Pattern    : Two Pointers (Two-End Selection)
------------------------------------------------------------

Approach
--------
1. Maintain two pointers at both ends.
2. Compare absolute values.
3. The larger absolute value produces the larger square.
4. Place that square at the current write position.
5. Move only the pointer that produced the larger square.
6. Repeat until all elements are processed.

Time Complexity  : O(n)
Space Complexity : O(n)

------------------------------------------------------------
*/

class Solution {
    public int[] sortedSquares(int[] nums) {

        int[] ans = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;
        int write = nums.length - 1;

        while (left <= right) {

            int leftAbs = Math.abs(nums[left]);
            int rightAbs = Math.abs(nums[right]);

            // Larger absolute value produces the larger square
            if (leftAbs < rightAbs) {

                ans[write] = rightAbs * rightAbs;
                right--;

            } else {

                ans[write] = leftAbs * leftAbs;
                left++;

            }

            // Fill answer array from the end
            write--;
        }

        return ans;
    }
}
