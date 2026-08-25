/**
 * LeetCode 918 - Maximum Sum Circular Subarray
 *
 * Pattern:
 * Kadane's Algorithm - Circular Variation
 *
 * Idea:
 * There are two possibilities:
 *
 * 1. Normal maximum subarray
 *    -> maxSum
 *
 * 2. Circular maximum subarray
 *    -> totalSum - minSum
 *
 * For the circular case, instead of finding the wrapped
 * subarray directly, we remove the minimum-sum subarray
 * from the middle of the array.
 *
 * States:
 *
 * currentMax -> maximum subarray sum ending at current index
 * maxSum     -> maximum subarray sum found anywhere
 *
 * currentMin -> minimum subarray sum ending at current index
 * minSum     -> minimum subarray sum found anywhere
 *
 * totalSum   -> sum of the entire array
 *
 * Edge Case:
 * If all elements are negative, totalSum - minSum would
 * represent an empty subarray, which is invalid.
 *
 * Therefore, when maxSum < 0, return maxSum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxSubarraySumCircular(int[] nums) {

        int currentMax = nums[0];
        int currentMin = nums[0];

        int maxSum = nums[0];
        int minSum = nums[0];

        int totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentMax = Math.max(nums[i],currentMax + nums[i]);

            maxSum = Math.max(maxSum,currentMax);

            currentMin = Math.min(nums[i],currentMin + nums[i]);

            minSum = Math.min(minSum,currentMin);

            totalSum += nums[i];
        }

        // All elements are negative.
        // totalSum - minSum would create an empty subarray.
        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum,totalSum - minSum);
    }
}
