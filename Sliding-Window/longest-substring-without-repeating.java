// Problem: Longest Substring Without Repeating Characters
// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Pattern: Sliding Window (Variable)
// Approach 1:
// - Use HashSet to track characters
// - Expand right pointer
// - If duplicate → shrink window from left
// - Track max length

// Approach 2: HashMap (Frequency Based) 
// - Track frequency of characters 
// - If frequency > 1 → shrink window 
// - Ensures no duplicates in window

// Key Insight: 
// - HashSet → existence 
// - HashMap → frequency 
// - Direct duplicate check: map.get(ch) > 1

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

// Approach 2 : 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0 , max = 0;
        HashMap<Character , Integer> map=new HashMap<>();
        for(int right=0; right<s.length(); right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>1){
                char ch1=s.charAt(left);
                map.put(ch1,map.get(ch1)-1);
                if(map.get(ch1)==0){
                    map.remove(ch1);
                }
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}
