/*
=========================================================
Problem      : 844. Backspace String Compare
Link         : https://leetcode.com/problems/backspace-string-compare/
Pattern      : Two Pointers (Reverse Traversal + Skip Counter)

Trigger
-------
- String contains backspace/delete operations.
- Need to compare the final processed strings.
- O(1) extra space is preferred over using a stack.

Approach
--------
1. Traverse both strings from right to left.
2. Maintain a skip counter for each string.
3. '#' increases the skip count.
4. If skip > 0, ignore the current character and decrement skip.
5. Stop when the next valid character is found.
6. Compare valid characters from both strings.
7. Repeat until both strings are exhausted.

Time Complexity
---------------
O(n + m)

Space Complexity
----------------
O(1)

Key Insight
-----------
Don't construct the final strings.

Instead, repeatedly find the next valid character in both strings
using reverse traversal and skip counters, then compare them.

=========================================================
*/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1;
        int j=t.length()-1;
        int skipS=0;
        int skipT=0;
        while(i>=0 || j>=0){    
            while(i>=0){
                if(s.charAt(i)=='#'){
                    skipS++;
                    i--;
                }else if(s.charAt(i)!='#' && skipS>0){
                    skipS--;
                    i--;
                }else{
                    break;
                }
            }    
            while(j>=0){
                if(t.charAt(j)=='#'){
                    skipT++;
                    j--;
                }else if(t.charAt(j)!='#' && skipT>0){
                    skipT--;
                    j--;
                }else{
                    break;
                }
            }
            if(i==-1 && j>=0 || j==-1 && i>=0){
                return false;
            }
            if(i>=0 && j>=0){
                if(s.charAt(i)==t.charAt(j)){
                    i--;
                    j--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
