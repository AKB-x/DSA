```java
// Hard Sliding Window Variation (Important Interview Problem)

// Problem: Longest Repeating Character Replacement
// Link: https://leetcode.com/problems/longest-repeating-character-replacement/

// Pattern: Sliding Window (Variable)

// Trigger:
// - Longest substring
// - At most k replacements allowed
// - Make all characters same

// Approach:
// - Use HashMap to track frequency of characters
// - Track max frequency character in current window
// - Expand window using right pointer
// - If (window size - maxFreq > k) → shrink window
// - Update max length for valid window

// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Insight:
// - window size - maxFreq = replacements needed
// - maxFreq = most frequent character in window
// - We do NOT reduce maxFreq while shrinking

class Solution {
    public int characterReplacement(String s, int k) {
        int left=0, maxlength=0, maxfreq=0;
        HashMap<Character,Integer> map=new HashMap<>();
        //adding elements into map
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right); //taking the character on right pointer
            map.put(ch,map.getOrDefault(ch,0)+1); //if the char exists then add into map+1
            maxfreq=Math.max(maxfreq,map.get(ch)); //updating the maxfrequency 
            //Shrink condition
            while((right-left+1)-maxfreq>k){
                //remove characters by moving left
                char ch1=s.charAt(left);
                map.put(ch1,map.get(ch1)-1);
                if(map.get(ch1)==0){
                    map.remove(ch1);
                }
                left++;
            }
            maxlength=Math.max(maxlength,right-left+1); //max window length
        }
        return maxlength;
        }
    }

```
