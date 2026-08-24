/**
 * LeetCode 1186 - Maximum Subarray Sum with One Deletion
 *
 * Pattern:
 * Kadane's Algorithm + Two-State Dynamic Programming
 *
 * States:
 *
 * noDelete
 * -> Maximum subarray sum ending at the current index
 *    with 0 deletions.
 *
 * oneDelete
 * -> Maximum subarray sum ending at the current index
 *    where one deletion has been used.
 *
 * For oneDelete, there are two possibilities:
 *
 * 1. The deletion already happened earlier:
 *      prevOneDelete + arr[i]
 *
 * 2. Delete the current element:
 *      prevNoDelete
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maximumSum(int[] arr) {

        int noDelete = arr[0];
        int oneDelete = 0;
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int prevNoDelete = noDelete;
            int prevOneDelete = oneDelete;

            noDelete = Math.max(
                arr[i],
                prevNoDelete + arr[i]
            );

            oneDelete = Math.max(
                prevOneDelete + arr[i],
                prevNoDelete
            );

            ans = Math.max(
                ans,
                Math.max(noDelete, oneDelete)
            );
        }

        return ans;
    }
}
