/**
 * LeetCode 560 - Subarray Sum Equals K
 *
 * Pattern:
 * Prefix Sum + HashMap
 *
 * Idea:
 * A subarray sum can be represented as the difference between
 * two prefix sums:
 *
 *     currentPrefix - previousPrefix = k
 *
 * Therefore:
 *
 *     previousPrefix = currentPrefix - k
 *
 * At every index, we check whether `currentPrefix - k`
 * has appeared before.
 *
 * The HashMap stores:
 *
 *     prefixSum -> frequency
 *
 * The frequency is important because the same prefix sum can
 * occur multiple times, and each occurrence can represent
 * another valid subarray.
 *
 * We initialize:
 *
 *     0 -> 1
 *
 * because a prefix sum of 0 exists once before the array starts.
 * This allows us to detect subarrays that begin at index 0.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int currentPrefix = 0;
        int count = 0;

        // Prefix sum 0 exists once before the array starts
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            currentPrefix += nums[i];

            int previousPrefix = currentPrefix - k;

            // Add the number of previous prefixes that form sum k
            if (map.containsKey(previousPrefix)) {
                count += map.get(previousPrefix);
            }

            // Store/update frequency of current prefix
            map.put(currentPrefix,map.getOrDefault(currentPrefix, 0) + 1);
        }

        return count;
    }
}
