```java
// Problem: Fruits Into Baskets
// Link: https://leetcode.com/problems/fruit-into-baskets/

// Pattern: Sliding Window (Variable)

// Trigger:
// - Subarray problem
// - At most 2 distinct elements(baskets)

// Approach:
// - Use HashMap to track frequency of fruits
// - Expand window using right pointer
// - If more than 2 unique fruits → shrink window from left
// - Remove fruit when its count becomes 0
// - Update max length for valid window

// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Insight:
// - HashMap stores frequency of fruits in current window
// - map.size() gives number of unique fruits
// - Maintain window with at most 2 distinct elements

class Solution {
    public int totalFruit(int[] fruits) {
        int left=0 , max=0;
        HashMap<Integer , Integer> map=new HashMap<>();
        for(int right=0; right<fruits.length; right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
```
