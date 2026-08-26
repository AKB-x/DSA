/**
 * LeetCode 724 - Find Pivot Index
 *
 * Pattern:
 * Prefix Sum
 *
 * Idea:
 * First calculate the total sum of the array.
 *
 * Then maintain a running `left` sum.
 * At index i:
 *
 *     right = totalSum - left - nums[i]
 *
 * If:
 *
 *     left == right
 *
 * then i is the pivot index.
 *
 * Important:
 * `left` must be updated AFTER checking the current index because
 * left should represent only the elements strictly before i.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int pivotIndex(int[] nums) {

        int totalSum = 0;
        int left = 0;

        // Calculate total sum
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums;
        }

        // Find pivot index
        for (int i = 0; i < nums.length; i++) {

            int right = totalSum - left - nums[i];

            if (left == right) {
                return i;
            }

            left += nums[i];
        }

        return -1;
    }
}
