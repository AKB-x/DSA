# Next Greater Element I

**LeetCode:** 496
**Pattern:** Monotonic Stack

## Problem

Given two arrays `nums1` and `nums2`, find the next greater element of each element in `nums1` from `nums2`.

The next greater element of an element `x` is the first element greater than `x` to its right. If no such element exists, return `-1`.

## Approach

* Process `nums2` from **right to left**.
* Maintain a **monotonic decreasing stack**.
* Remove elements from the stack that are smaller than or equal to the current element.
* After removing them:

  * If the stack is empty, the next greater element is `-1`.
  * Otherwise, the stack's top element is the next greater element.
* Store the result for each element in a `HashMap`.
* Traverse `nums1` and retrieve each answer from the map.

## Time Complexity

**O(N + M)**

Where `N = nums2.length` and `M = nums1.length`.

## Space Complexity

**O(N)**

## Solution

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }

            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
```
