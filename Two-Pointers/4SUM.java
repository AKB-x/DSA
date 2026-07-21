/*
Problem      : LeetCode 18 - 4Sum
Pattern      : Sorting + Two Pointers + Duplicate Handling
Difficulty   : Medium

Approach:
1. Sort the array.
2. Fix first element.
3. Fix second element.
4. Reduce remaining search to Two Sum.
5. Use left & right pointers.
6. Skip duplicates at every level.

Time Complexity  : O(n³)
Space Complexity : O(1) (excluding output)

Key Learning:
Reduce kSum problems recursively until they become Two Sum.
Always check arithmetic expressions for overflow.
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            // Skip duplicate first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                // Skip duplicate second element
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                long remainingTarget = (long) target - nums[i] - nums[j];

                while (left < right) {

                    long pairSum = (long) nums[left] + nums[right];

                    if (pairSum == remainingTarget) {

                        ans.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[left],
                                nums[right]
                        ));

                        left++;
                        right--;

                        // Skip duplicate third element
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicate fourth element
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (pairSum < remainingTarget) {

                        left++;

                    } else {

                        right--;

                    }
                }
            }
        }

        return ans;
    }
}
