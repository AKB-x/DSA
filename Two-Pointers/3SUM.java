/*
------------------------------------------------------------
Problem      : 3Sum (LeetCode 15)
Pattern      : Sorting + Two Pointers
Difficulty   : Medium
------------------------------------------------------------

Trigger
-------
- Find unique triplets.
- Sum equals target (0).
- Array can be sorted.

Approach
--------
1. Sort the array.
2. Fix one element.
3. Convert remaining search into Two Sum.
4. Use Two Pointers.
5. Store valid triplets.
6. Skip duplicate fixed values.
7. Skip duplicate left/right values.

Thinking Process
----------------
Current State
    Fixed element + left + right

Extract
    sum = nums[left] + nums[right]

Update
    Store triplet if sum == target

Change State
    sum < target  -> left++
    sum > target  -> right--
    sum == target -> left++, right--, skip duplicates

Invariant
---------
Every pointer movement shrinks the search space.
Discarded values cannot form a new valid triplet.

Time Complexity
---------------
O(n²)

Space Complexity
----------------
O(1)

Key Insight
-----------
3Sum = Sort + Fix One + Two Sum + Duplicate Handling
------------------------------------------------------------
*/
