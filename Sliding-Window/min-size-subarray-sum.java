```java
// Problem: Minimum Size Subarray Sum
// Link: https://leetcode.com/problems/minimum-size-subarray-sum/

// Pattern: Sliding Window (Variable)

// Trigger:
// - "Minimum length subarray" + Contiguous subarray problem
// - "Sum ≥ target"

// Approach:
// - Expand window by adding nums[right]
// - When sum ≥ target → shrink window from left
// - Update minimum length during shrinking
// - Continue until full array is processed

// Time Complexity: O(n)
// Space Complexity: O(1)
  
// Edge Case: If no subarray satisfies condition → return 0

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0,
            left=0,
            min=Integer.MAX_VALUE;  // +ve infinte
        for(int right=0;right<nums.length;right++){
            sum=sum+nums[right];
            while(sum>=target){
                min=Math.min(min,right-left+1);
                sum=sum-nums[left];
                left++;
            }
        }
        return (min==Integer.MAX_VALUE) ? 0 : min;
    }
}
```
