/**
 * LeetCode 53 - Maximum Subarray
 *
 * Pattern: Kadane's Algorithm
 *
 * Idea:
 * At every element, decide whether to:
 * 1. Start a new subarray from the current element
 * 2. Continue the previous subarray
 *
 * currentSum = maximum sum of a subarray ending at the current index.
 * maxSum = maximum sum found anywhere so far.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
