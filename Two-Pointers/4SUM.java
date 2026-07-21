/*
Problem      : LeetCode 18 - 4Sum
Pattern      : Sorting + Two Pointers + Duplicate Handling
Difficulty   : Medium

Approach:
1. Sort the array.
2. Fix first element.
3. Fix second element.
4. Reduce remaining search to Two Sum.
5. Use left & right pointers.
6. Skip duplicates at every level.

Time Complexity  : O(n³)
Space Complexity : O(1) (excluding output)

Key Learning:
Reduce kSum problems recursively until they become Two Sum.
Always check arithmetic expressions for overflow.
*/
