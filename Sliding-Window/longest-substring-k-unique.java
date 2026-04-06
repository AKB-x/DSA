
// Problem: Longest Substring with K Unique Characters
// Link: https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

// Pattern: Sliding Window (Variable)

// Trigger:
// - Longest substring
// - Exactly K distinct characters

// Approach:
// - Use HashMap to track frequency of characters
// - Expand window using right pointer
// - If unique characters > k → shrink window from left
// - Remove character when its count becomes 0
// - When unique == k → update max length

// Time Complexity: O(n)
// Space Complexity: O(k)

// Key Insight:
// - Use while loop to shrink until window becomes valid
// - HashMap helps track frequency (not just presence)

class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int left=0,max=-1;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            //int count = map.getOrDefault(ch, 0);
            //count = count + 1;
            //map.put(ch, count);
            //      OR 
            map.put(ch,map.getOrDefault(ch,0)+1); //Increase the frequency of character ch by 1
            while(map.size()>k){
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                if (map.get(leftChar) == 0) {
                map.remove(leftChar);
            }
            left++;
            }
            if(map.size()==k){
                max=Math.max(max,right-left+1);
            }
        }
        return max;
    }

}
