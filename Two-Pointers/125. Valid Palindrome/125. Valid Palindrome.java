1class Solution {
2    public boolean isPalindrome(String s) {
3        int left=0;
4        int right=s.length()-1;
5        while(left<right){
6            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
7                left++;
8            }
9            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
10                right--;
11            }
12            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
13                return false;
14            }
15            left++;
16            right--;
17        }
18        return true;
19        }
20    }
21