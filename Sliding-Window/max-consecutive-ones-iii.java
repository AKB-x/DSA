```java
// Problem: Max Consecutive Ones III
// Link: https://leetcode.com/problems/max-consecutive-ones-iii/

// Pattern: Sliding Window (Variable)

// Trigger:
// - Longest subarray
// - At most k changes allowed

// Approach:
// - Track number of zeros in window
// - Expand window using right pointer
// - If zeros > k → shrink window from left
// - Update max length

// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Insight:
// - Track constraint (zeros), not result (ones)
// - Maintain at most k zeros in window

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,maxlength=0;
        int zeroCount=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            maxlength=Math.max(maxlength,right-left+1);
        }
        return maxlength;
        }
    }

```
