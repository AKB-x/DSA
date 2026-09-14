## 📦 Next Greater Element II

### LeetCode 503 — Next Greater Element II

**Pattern:** Monotonic Stack + Circular Array

**Approach:**
- Treat the array as circular, so elements near the end can search from the beginning.
- Preload the stack with elements from `n-2` down to `0` to represent the wrapped-around portion.
- Traverse the actual array from `n-1` down to `0`.
- Remove elements from the stack that are smaller than or equal to the current element.
- If the stack is empty, no greater element exists → `-1`.
- Otherwise, the stack's top is the next greater element.
- Push the current element onto the stack for future elements.

**Time Complexity:** `O(N)`

**Space Complexity:** `O(N)`

### Solution

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result[] = new int[nums.length];

        for(int i = nums.length - 2; i >= 0; i--){
            stack.push(nums[i]);
        }

        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i] >= stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                result[i] = -1;
            }else{
                result[i] = stack.peek();
            }

            stack.push(nums[i]);
        }

        return result;
    }
}
