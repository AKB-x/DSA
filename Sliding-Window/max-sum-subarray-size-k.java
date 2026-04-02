// Problem: Maximum Sum Subarray of Size k
// Link: https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
// Pattern: Sliding Window (Fixed)
// Approach:
// - Maintain Window Sum
// - Add next and remove previous
// - Track max length

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int sum=0,
            max=0;
        //calculation of sum in the window
        for(int i=0;i<k;i++){
            sum=sum+arr[i];
        }
        max=Math.max(max,sum);
        //making the window move 
        for(int i=k ; i<arr.length; i++){
            sum = sum + arr[i];  // add next
            sum = sum - arr[i-k];  // remove previous 
            max=Math.max(max,sum);  // track maximum
        }
        return max;
    }
}
