// Problem: Longest Substring Without Repeating Characters
// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Pattern: Sliding Window (Variable)
// Approach:
// - Use HashSet to track characters
// - Expand right pointer
// - If duplicate → shrink window from left
// - Track max length

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
       //have to make left pointer and maxlength to track the length
       int left=0, maxlength=0; 
       //making a HashSet
       HashSet<Character> set=new HashSet<>();
       //moving right pointer
       for(int right=0; right<s.length(); right++){
         while(set.contains(s.charAt(right))){
            set.remove(s.charAt(left));   // if duplicate -> Shrink Left
            left++;
         }
         set.add(s.charAt(right));
         maxlength=Math.max(maxlength, right-left+1);
       }
       return maxlength;
    }
}
