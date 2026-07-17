/*
------------------------------------------------------------
Problem    : 3Sum
Platform   : LeetCode
Difficulty : Medium
Pattern    : Sorting + Two Pointers
------------------------------------------------------------

Approach
--------
1. Sort the array.
2. Fix one element.
3. Convert the remaining search into Two Sum.
4. Use Two Pointers.
5. Skip duplicate fixed elements.
6. Skip duplicate left and right values after finding a triplet.

Time Complexity : O(n²)

Space Complexity : O(1)
(Excluding the output list)

------------------------------------------------------------
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){

            if(i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while(left < right){

                int sum = nums[left] + nums[right];

                if(sum == target){

                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left - 1])
                        left++;

                    while(left < right && nums[right] == nums[right + 1])
                        right--;

                }
                else if(sum < target){
                    left++;
                }
                else{
                    right--;
                }

            }

        }

        return ans;

    }
}
