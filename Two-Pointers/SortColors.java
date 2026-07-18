/*
------------------------------------------------------------
Problem    : Sort Colors
Platform   : LeetCode
Difficulty : Medium
Pattern    : Two Pointers (Dutch National Flag Algorithm)
------------------------------------------------------------

Approach
--------
1. Maintain three pointers:
   - left  : Next position for 0
   - mover : Current element being processed
   - right : Next position for 2

2. Traverse while mover <= right.

3. If current element is:
   - 0 : Swap with left, then left++, mover++
   - 1 : Already in correct region, mover++
   - 2 : Swap with right, right--
         (Do NOT increment mover because the swapped element
          is still unprocessed.)

Time Complexity : O(n)

Space Complexity : O(1)

------------------------------------------------------------
*/

class Solution {
    public void sortColors(int[] nums) {

        int left = 0;
        int mover = 0;
        int right = nums.length - 1;

        while (mover <= right) {

            if (nums[mover] == 0) {

                int temp = nums[left];
                nums[left] = nums[mover];
                nums[mover] = temp;

                left++;
                mover++;

            } else if (nums[mover] == 1) {

                mover++;

            } else {

                int temp = nums[right];
                nums[right] = nums[mover];
                nums[mover] = temp;

                right--;

            }
        }
    }
}
