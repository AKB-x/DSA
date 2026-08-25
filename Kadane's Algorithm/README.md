# ⚡ Kadane's Algorithm

## 📌 Description

Kadane's Algorithm is a Dynamic Programming / Greedy technique primarily used to find the maximum sum of a contiguous subarray.

Example:

    [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Maximum Subarray:

    [4, -1, 2, 1]

Maximum Sum:

    6

The main idea is to scan the array from left to right and decide at every element:

> Should I continue the current subarray or start a new subarray here?


---

# 🎯 When to Use

Think about Kadane's Algorithm when the problem involves:

- Arrays
- Contiguous subarrays
- Maximum sum
- Minimum sum
- Largest sum of consecutive elements
- Maximum possible sum
- Finding the best subarray
- Maximizing a running value

### 🚨 Strong Trigger

> Maximum Sum + Contiguous Subarray

→ Immediately consider Kadane's Algorithm.

### Other Trigger Words

    maximum subarray
    largest sum
    contiguous
    consecutive elements
    maximum possible sum
    subarray with maximum sum
    maximum/minimum running sum


---

# 🧠 Core Idea

At every element, there are two choices:

    1. Start a new subarray
    2. Continue the previous subarray

Suppose:

    currentSum = -5
    current element = 4

Continue:

    -5 + 4 = -1

Start fresh:

    4

Since:

    4 > -1

we start a new subarray.

This gives the core decision:

    currentSum = max(nums[i], currentSum + nums[i])


---

# 🔑 The Two Important Variables

## 1. currentSum

Represents:

> The maximum sum of a subarray ending at the current index.

It answers:

    "What is the best subarray I can have
     if it MUST end at this element?"


## 2. maxSum

Represents:

> The maximum subarray sum found anywhere so far.

So:

    currentSum
        ↓
    Best subarray ending HERE

    maxSum
        ↓
    Best subarray found ANYWHERE


---

# 🔄 Core Decision

For every element nums[i]:

    Option 1:
    Start a new subarray

    nums[i]

    Option 2:
    Continue the previous subarray

    currentSum + nums[i]

Choose the larger:

    currentSum = Math.max(nums[i], currentSum + nums[i]);

Then update the global answer:

    maxSum = Math.max(maxSum, currentSum);


---

# 🧱 Basic Template

    int currentSum = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < nums.length; i++) {

        currentSum = Math.max(nums[i], currentSum + nums[i]);

        maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;


### Mental Template

    TAKE OR RESTART
           ↓
    UPDATE CURRENT
           ↓
    UPDATE GLOBAL

Or simply:

    current = max(element, current + element)

    best = max(best, current)


---

# 📊 Example Walkthrough

Consider:

    [-2, 1, -3, 4, -1, 2, 1, -5, 4]

| Element | Best subarray ending here | currentSum | maxSum |
|---:|---|---:|---:|
| -2 | [-2] | -2 | -2 |
| 1 | [1] | 1 | 1 |
| -3 | [1,-3] | -2 | 1 |
| 4 | [4] | 4 | 4 |
| -1 | [4,-1] | 3 | 4 |
| 2 | [4,-1,2] | 5 | 5 |
| 1 | [4,-1,2,1] | 6 | 6 |
| -5 | [4,-1,2,1,-5] | 1 | 6 |
| 4 | [4,-1,2,1,-5,4] | 5 | 6 |

Final:

    maxSum = 6


---

# 💡 Most Important Intuition

A negative running sum can become baggage.

Example:

    currentSum = -10
    nums[i] = 5

Continue:

    -10 + 5 = -5

Start fresh:

    5

So:

    5 > -5

We discard the previous subarray and start from 5.

### BUT

A negative number does NOT automatically mean restart.

Example:

    [4, -1, 2]

If we keep -1:

    4 + (-1) + 2 = 5

This is better than starting fresh at 2.

So the actual decision is always:

    nums[i]

        VS

    currentSum + nums[i]

Choose the better one.


---

# 🧮 Dynamic Programming View

There is a DP idea underneath Kadane's Algorithm.

Define:

    dp[i] = maximum sum of a subarray ending at index i

Then:

    dp[i] = max(nums[i], dp[i-1] + nums[i])

But we don't need to store the entire dp[] array.

We only need:

    dp[i-1]

So we compress the state into:

    currentSum

This gives:

    Time  → O(n)
    Space → O(1)


---

# 🟢 Greedy Interpretation

Kadane can also be understood as a greedy decision.

At every element:

> Keep the previous subarray only if it helps.

Otherwise:

> Start a new subarray.

So Kadane can be viewed as:

    Dynamic Programming
            +
    Greedy Decision


---

# ⚠️ Important Edge Case: All Negative Numbers

Consider:

    [-5, -2, -8, -1]

The answer is:

    -1

NOT:

    0

Therefore, don't blindly initialize:

    int maxSum = 0;

Instead:

    int currentSum = nums[0];
    int maxSum = nums[0];

This correctly handles arrays containing only negative numbers.


---

# ⚠️ Common Mistakes

## 1. Confusing Subarray and Subsequence

A subarray must be contiguous.

For:

    [1, 2, 3, 4]

Valid:

    [1, 2]
    [2, 3]
    [3, 4]
    [1, 2, 3]

Invalid:

    [1, 3]

because 2 was skipped.


## 2. Starting the Loop at 0

If we initialize:

    int currentSum = nums[0];
    int maxSum = nums[0];

then nums[0] has already been processed.

Therefore:

    for (int i = 1; i < nums.length; i++)

not:

    for (int i = 0; i < nums.length; i++)

### Rule

> If initialization already uses index 0 → start the loop at index 1.


## 3. Initializing maxSum to 0

Wrong when all numbers are negative:

    int maxSum = 0;

Correct:

    int maxSum = nums[0];


## 4. Forgetting the Global Maximum

currentSum can decrease later.

Example:

    [4, -1, 2, 1, -5]

At one point:

    currentSum = 6

Later:

    currentSum = 1

But the answer is still:

    6

Therefore we need:

    maxSum = Math.max(maxSum, currentSum);


## 5. Thinking Every Negative Number Means Restart

Wrong idea:

    Negative number → restart

Instead:

    current element
           VS
    currentSum + current element

Choose the better one.


---

# 🔧 Variations

Kadane's core idea can be extended to other problems.

### Maximum Subarray Sum

    current = max(x, current + x)


### Minimum Subarray Sum

    current = min(x, current + x)


### Maximum Product Subarray

Requires tracking both:

    maxProduct
    minProduct

because a negative number can turn a minimum product into a maximum.


### Maximum Circular Subarray

Can combine:

    Maximum Normal Subarray
            +
    Minimum Subarray

with a special case for arrays containing only negative values.


---

# 📚 Questions Completed

| # | Problem | Concept | Status |
|---|---|---|---|
| 1 | [Maximum Subarray — LeetCode 53](https://leetcode.com/problems/maximum-subarray/) | Basic Kadane | ✅ |
| 2 | [Minimum Sum Subarray — GeeksforGeeks](https://www.geeksforgeeks.org/problems/smallest-sum-contiguous-subarray/1) | Inverted Kadane | ✅ |
| 3 | [Maximum Product Subarray — LeetCode 152](https://leetcode.com/problems/maximum-product-subarray/) | Max + Min State Kadane | 🟡 |
| 4 | [Maximum Subarray Sum with One Deletion — LeetCode 1186](https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/) | Two-State DP + Kadane | 🟡 |
| 5 | [Maximum Absolute Sum of Any Subarray — LeetCode 1749](https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/) | Maximum + Minimum Kadane | 🟢 |
| 6 | [Maximum Sum Circular Subarray — LeetCode 918](https://leetcode.com/problems/maximum-sum-circular-subarray/) | Circular Kadane + Maximum/Minimum Kadane | 🟢 |

---

# 📈 Pattern Progress

### Kadane's Algorithm

[████████████████░░░░] 6 Core Questions Completed

### Completed

- ✅ Maximum Subarray — LeetCode 53
- ✅ Minimum Sum Subarray — GeeksforGeeks
- 🟡 Maximum Product Subarray — LeetCode 152
- 🟡 Maximum Subarray Sum with One Deletion — LeetCode 1186
- 🟢 Maximum Absolute Sum of Any Subarray — LeetCode 1749
- 🟢 Maximum Sum Circular Subarray — LeetCode 918

### Key Variations Covered

- ✅ Basic Kadane
- ✅ Minimum Kadane
- ✅ Maximum + Minimum State
- ✅ Kadane + Two-State DP
- ✅ Maximum Absolute Sum
- ✅ Circular Kadane

### Remaining / Upcoming

- ⬜ Important Kadane variations from the playlist
- ⬜ Any high-value interview variation that adds a genuinely new concept

> Goal: Understand the pattern and its major variations deeply enough to recognize
> when Kadane's Algorithm applies, rather than maximizing the number of questions solved.

---

# 🧠 Mental Checklist

When reading a problem:

    Is it an ARRAY?
          ↓
    Is it asking about a SUBARRAY?
          ↓
    Must it be CONTIGUOUS?
          ↓
    Are we MAXIMIZING or MINIMIZING something?
          ↓
    Think KADANE


---

# 🧠 Pattern Connection

Don't memorize the code.

Understand the decision:

                     nums[i]
                        │
              ┌─────────┴─────────┐
              ↓                   ↓
        Start Fresh        Continue Previous
           nums[i]          currentSum + nums[i]
              └─────────┬─────────┘
                        ↓
                  Take Maximum
                        ↓
                  currentSum
                        ↓
                  Update maxSum

The entire pattern can be remembered as:

    TAKE OR RESTART
          ↓
    UPDATE CURRENT
          ↓
    UPDATE GLOBAL


---

# ⏱️ Complexity

For the standard Kadane problem:

    Time Complexity  → O(n)
    Space Complexity → O(1)

We scan the array once and only maintain a constant number of variables.


---

# ⭐ Key Takeaways

1. Kadane's Algorithm finds the maximum sum contiguous subarray.
2. The core decision is continue or restart.
3. currentSum = best subarray sum ending at the current index.
4. maxSum = best subarray sum found anywhere.
5. If the previous subarray hurts more than it helps, start fresh.
6. A negative number does NOT automatically mean restart.
7. Initialize with nums[0] when negative values are possible.
8. If initialized with nums[0], start the loop from i = 1.
9. Kadane is essentially DP state compression + greedy decision making.
10. The strongest trigger is:

    CONTIGUOUS SUBARRAY
            +
    MAXIMUM / MINIMUM SUM
            ↓
         KADANE


---

# 🚀 Pattern Status

**Kadane's Algorithm → 🟡 In Progress**

The pattern will be marked complete after the important variations have been practiced and understood.

The goal is not to memorize individual solutions.

The goal is to recognize:

> "I need the best contiguous segment, so I should ask whether continuing the current segment is better than starting fresh."
> 
