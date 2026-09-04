/**
 * LeetCode 525 - Contiguous Array
 *
 * Pattern:
 * Prefix Sum / Difference + HashMap
 *
 * Idea:
 * Keep track of the difference between the number of 0s and 1s:
 *
 *     diff = zeroes - ones
 *
 * If the same difference appears again, the elements between
 * those two indices contain an equal number of 0s and 1s.
 *
 * The HashMap stores:
 *
 *     diff -> earliest index
 *
 * We store only the first occurrence because we want the
 * maximum possible subarray length.
 *
 * If diff == 0, the subarray from index 0 to i has equal
 * numbers of 0s and 1s, so its length is i + 1.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int findMaxLength(int[] nums) {

        int zeroes = 0;
        int ones = 0;
        int res = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
            } else {
                ones++;
            }
            int diff = zeroes - ones;

            if (diff == 0) {
                res = Math.max(res, i + 1);
            }

            if (map.containsKey(diff)) {
              
                int index = map.get(diff);
                int length = i - index;
                res = Math.max(length, res);

            } else {
                map.put(diff, i);
            }
        }

        return res;
    }
}
