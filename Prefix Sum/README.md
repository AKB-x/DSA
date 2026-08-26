# 🧮 Prefix Sum Pattern

## 📌 Description

Prefix Sum is a technique where we maintain **cumulative information** while traversing an array.

Instead of repeatedly calculating the sum of a range by traversing all its elements, we use previously calculated sums to obtain the required sum efficiently.

Prefix Sum is not limited to a `prefix[]` array. It can also be maintained using:

- A running variable
- A Prefix Sum array
- A HashMap
- Modulo
- A Deque
- Other data structures depending on the problem

---

# 🎯 When to Use

Consider Prefix Sum when a problem involves:

- Subarray sums
- Range sum queries
- Sum between two indices
- Finding a pivot / equilibrium index
- Counting subarrays with a target sum
- Finding subarrays with a particular sum
- Cumulative information
- Prefix Sum + HashMap
- Prefix Sum + Modulo
- Prefix Sum + Deque
- 2D range sums

### 🚨 Strong Trigger

> **Subarray / range + sum / cumulative relationship**

→ Consider **Prefix Sum**.

---

# 🧠 Core Idea

Instead of calculating sums repeatedly, keep track of the sum calculated so far.

For:

    nums = [2, 4, 1, 3, 5]

A prefix sum represents the cumulative sum:

    2
    2 + 4 = 6
    2 + 4 + 1 = 7
    2 + 4 + 1 + 3 = 10
    2 + 4 + 1 + 3 + 5 = 15

A common implementation uses an extra `0` at the beginning:

    prefix = [0, 2, 6, 7, 10, 15]

The extra `0` represents the sum of zero elements.

---

# 📐 Prefix Sum Definition

Using the extra `0`:

    prefix[i] = sum of the first i elements

Therefore:

    prefix[0] = 0
    prefix[1] = nums[0]
    prefix[2] = nums[0] + nums[1]
    prefix[3] = nums[0] + nums[1] + nums[2]
    ...

Standard construction:

    int[] prefix = new int[nums.length + 1];

    for (int i = 0; i < nums.length; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
    }

---

# 🔑 Range Sum Formula

To find the sum from index `L` to `R`:

    sum(L ... R) = prefix[R + 1] - prefix[L]

Why?

    prefix[R + 1]
    =
    sum of everything from index 0 through R

    prefix[L]
    =
    sum of everything before index L

Subtracting removes everything before `L`.

Therefore:

    prefix[R + 1] - prefix[L]

leaves:

    nums[L] + nums[L + 1] + ... + nums[R]

---

# ⭐ Prefix Sum Without an Array

We don't always need a `prefix[]` array.

Sometimes a single running variable is enough:

    int left = 0;

For example, `left` can represent:

    sum of all elements before the current index

This allows:

    Space = O(1)

instead of:

    Space = O(n)

when a complete prefix array is used.

This is useful when we only need the current prefix information and do not need access to older prefix sums.

---

# 🧠 Prefix Sum Mental Model

Think of Prefix Sum as:

    Original Array
          ↓
    Cumulative Information
          ↓
    Prefix Sum
          ↓
    Use differences between cumulative sums
          ↓
    Answer range / subarray questions efficiently

The key idea is:

> **Don't repeatedly calculate information you have already calculated.**

Store the cumulative information and reuse it.

---

# 📚 Question 1 — Find Pivot Index

**LeetCode 724**

## Problem

Find an index where:

    sum of elements to the LEFT
    =
    sum of elements to the RIGHT

If no such index exists, return `-1`.

---

# 💡 Approach

First calculate the total sum of the entire array.

Then traverse the array.

At index `i`:

    totalSum
    =
    left + nums[i] + right

Therefore:

    right = totalSum - left - nums[i]

Now check:

    if (left == right)
        return i;

After checking the current index:

    left += nums[i];

---

# ⚠️ Why Update `left` AFTER the Check?

At index `i`, `left` must represent:

    sum of elements strictly BEFORE i

It must NOT contain `nums[i]`.

For:

    [1, 7, 3, 6, 5, 6]

At index `3`:

            i
            ↓
    [1, 7, 3, 6, 5, 6]
     ← left →   ← right →

Therefore:

    left = 1 + 7 + 3
         = 11

    nums[i] = 6

    right = 5 + 6
          = 11

So:

    left == right

and index `3` is the pivot.

Only after checking index `3` do we do:

    left += nums[i];

which prepares `left` for the next index.

---

# 🧠 Important Mental Model

At the START of processing index `i`:

    left
     ↓
    sum of nums[0 ... i-1]

Current:

    nums[i]

Right:

    sum of nums[i+1 ... n-1]

Therefore:

    totalSum
    =
    left + nums[i] + right

So:

    right = totalSum - left - nums[i]

After processing `i`:

    left += nums[i]

Then move to `i + 1`.

---

# ❌ Common Mistake

Do NOT do:

    left += nums[i];

    int right = totalSum - left - nums[i];

because now `left` contains the current element.

The correct order is:

    1. Calculate right
    2. Check left == right
    3. Add current element to left
    4. Move to next index

---

# ⚠️ Another Common Mistake

The problem asks for the **index**, not the value.

Wrong:

    return nums[i];

Correct:

    return i;

For:

    [1, 7, 3, 6, 5, 6]

the pivot is:

    index = 3
    value = 6

The answer is:

    3

not:

    6

---

# 💻 Solution

    class Solution {
        public int pivotIndex(int[] nums) {

            int totalSum = 0;
            int left = 0;

            // Calculate total sum
            for (int i = 0; i < nums.length; i++) {
                totalSum += nums[i];
            }

            // Find pivot index
            for (int i = 0; i < nums.length; i++) {

                int right = totalSum - left - nums[i];

                if (left == right) {
                    return i;
                }

                left += nums[i];
            }

            return -1;
        }
    }

---

# 🔍 Dry Run

For:

    nums = [1, 7, 3, 6, 5, 6]

Total:

    totalSum = 28

Initially:

    left = 0

### i = 0

    right = 28 - 0 - 1
          = 27

Not equal.

    left = 0 + 1
         = 1

### i = 1

    right = 28 - 1 - 7
          = 20

Not equal.

    left = 8

### i = 2

    right = 28 - 8 - 3
          = 17

Not equal.

    left = 11

### i = 3

    right = 28 - 11 - 6
          = 11

Therefore:

    left == right

Return:

    3

---

# 🔥 Why This Is Prefix Sum

We are not storing:

    prefix[]

but:

    left

is effectively a **running prefix sum**.

At every index:

    left = sum of everything before current index

We combine it with:

    totalSum

to derive the right-side sum.

This is an important lesson:

> Prefix Sum is a technique for maintaining cumulative information, not necessarily a requirement to build a separate prefix array.

---

# 🆚 Prefix Array vs Running Variable

## Prefix Array

    int[] prefix = new int[n + 1];

Useful when:

- We need many previous prefix sums.
- We need multiple range queries.
- We need random access to prefix information.

Space:

    O(n)

## Running Prefix Variable

    int left = 0;

Useful when:

- We only need the current prefix.
- We process the array from left to right.
- Previous prefix values are not needed later.

Space:

    O(1)

For Pivot Index, a running variable is enough.

---

# 🚨 Prefix Sum + HashMap

One of the most important interview extensions is:

    Prefix Sum + HashMap

Suppose we want a subarray whose sum equals `K`.

Let:

    currentPrefix

be the sum up to the current index.

If a previous prefix sum was:

    previousPrefix

then the sum between them is:

    currentPrefix - previousPrefix

We want:

    currentPrefix - previousPrefix = K

Rearranging:

    previousPrefix = currentPrefix - K

Therefore, while traversing the array, we can ask:

    Have we seen currentPrefix - K before?

If yes, the elements between those two prefix positions have sum `K`.

This gives the important pattern:

    Prefix Sum + HashMap

Common problems:

- Subarray Sum Equals K
- Continuous Subarray Sum
- Subarray Sums Divisible by K

---

# 🔢 Prefix Sum + Modulo

Some problems ask about divisibility instead of an exact sum.

For example:

> Find whether a subarray sum is divisible by `K`.

If two prefix sums have the same remainder:

    prefix[i] % K
    =
    prefix[j] % K

then:

    (prefix[j] - prefix[i]) % K = 0

Therefore, the subarray between those positions has a sum divisible by `K`.

This leads to:

    Prefix Sum + Modulo + HashMap

---

# 📦 Prefix Sum + Deque

Prefix Sum can also be combined with a **Monotonic Deque** for harder problems.

A major example is:

    Shortest Subarray with Sum at Least K

This is particularly important because the array can contain negative numbers, making a normal sliding-window approach invalid.

The combination becomes:

    Prefix Sum
         +
    Monotonic Deque

This is an advanced Prefix Sum variation.

---

# 🧮 2D Prefix Sum

The same idea can be extended from arrays to matrices.

Instead of calculating the sum of a rectangular region repeatedly, we precompute cumulative sums for the matrix.

This allows rectangle/range sum queries to be answered efficiently.

The core idea remains:

    Precompute cumulative information
            ↓
    Use subtraction/addition
            ↓
    Avoid repeatedly traversing the region

---

# 🆚 Prefix Sum vs Kadane

Both patterns can involve subarrays and sums, but their goals are different.

## Kadane

Usually asks:

    What is the maximum/minimum subarray sum?

Think:

    Kadane
    → Optimize a subarray sum

## Prefix Sum

Usually asks:

    What is the cumulative sum?

    What is the sum between two positions?

    Can two prefix sums tell me something about a subarray?

Think:

    Prefix Sum
    → Use cumulative sums to reason about ranges/subarrays

---

# 🆚 Prefix Sum vs Sliding Window

## Sliding Window

Maintains a moving range:

    left ←──── window ────→ right

and is useful when the window can be expanded/shrunk while maintaining some condition.

## Prefix Sum

Stores cumulative information:

    prefix
      ↓
    difference between two prefix sums
      ↓
    range/subarray information

Prefix Sum is especially useful when negative numbers make a normal sliding-window strategy unsuitable.

---

# 🎯 Strong Recognition Patterns

## 1. Range Sum

Problem asks:

> "Find the sum from `L` to `R`."

Think:

    Prefix Sum

Formula:

    sum(L ... R) = prefix[R + 1] - prefix[L]

---

## 2. Pivot / Equilibrium Index

Problem asks:

> "Find an index where the sum on the left equals the sum on the right."

Think:

    Running Prefix Sum + Total Sum

Relationship:

    totalSum
    =
    left + nums[i] + right

Therefore:

    right = totalSum - left - nums[i]

---

## 3. Subarray Sum = K

Problem asks:

> "Find/count subarrays whose sum is K."

Think:

    Prefix Sum + HashMap

Key relationship:

    previousPrefix = currentPrefix - K

---

## 4. Sum Divisible by K

Think:

    Prefix Sum + Modulo + HashMap

---

## 5. Shortest Subarray With Sum ≥ K

Think:

    Prefix Sum + Monotonic Deque

---

# ⚠️ Common Mistakes

### 1. Off-by-one errors

With an extra `0`:

    prefix[i + 1] = prefix[i] + nums[i]

and:

    sum(L ... R) = prefix[R + 1] - prefix[L]

### 2. Forgetting the extra 0

Prefer:

    prefix = [0, ...]

because it makes the range formula work uniformly when:

    L = 0

### 3. Confusing prefix index with array index

For:

    nums[i]

the corresponding prefix position is:

    prefix[i + 1]

### 4. Updating a running prefix too early

If the current index is being checked, make sure the running prefix does not already contain `nums[i]` unless the problem explicitly requires it.

### 5. Forgetting frequency with HashMap

For counting subarrays, we usually need:

    prefixSum → frequency

not merely whether a prefix sum has appeared.

The same prefix sum can occur multiple times and each occurrence can represent another valid subarray.

---

# ⏱️ Complexity

## Prefix Array

Building:

    O(n)

Range query:

    O(1)

Space:

    O(n)

---

## Running Prefix Variable

Traversal:

    O(n)

Space:

    O(1)

---

## Prefix Sum + HashMap

Typical traversal:

    O(n)

Extra space:

    O(n)

---

# 🧠 Interview Approach

When you see a sum-related array problem, ask:

    1. Do I need the sum of a range?
           ↓
       Prefix Sum

    2. Do I need to find/count subarrays with sum K?
           ↓
       Prefix Sum + HashMap

    3. Is divisibility involved?
           ↓
       Prefix Sum + Modulo + HashMap

    4. Is it a shortest-subarray problem with negative numbers?
           ↓
       Prefix Sum + Monotonic Deque

    5. Is it a matrix rectangle/range sum?
           ↓
       2D Prefix Sum

---

# ⭐ Key Takeaway

Prefix Sum is fundamentally about:

    Cumulative Information
            ↓
    Reuse Previous Work
            ↓
    Avoid Recalculating Sums

The fundamental range formula is:

    sum(L ... R) = prefix[R + 1] - prefix[L]

The most important interview extension is:

    Prefix Sum + HashMap

with the key relationship:

    previousPrefix = currentPrefix - target

The goal is **not** to memorize a single Prefix Sum template.

The goal is to recognize:

> **"This problem is asking me to reason about cumulative sums or the difference between two cumulative sums."**

When you recognize that, Prefix Sum should come to mind.

---

# 📚 Questions Completed

| # | Problem | Concept | Status |
|---|---|---|---|
| 1 | [Find Pivot Index — LeetCode 724](https://leetcode.com/problems/find-pivot-index/) | Running Prefix Sum + Total Sum | ✅ |

---

# 📈 Pattern Progress

### Prefix Sum

[███░░░░░░░░░░░░░░░░░] 1 Core Question Completed

### Completed

- ✅ Find Pivot Index — LeetCode 724
  - Running Prefix Sum
  - Total Sum
  - Left / Right Sum Relationship
  - O(1) Space Optimization

### Upcoming

- ⬜ Prefix Sum + HashMap
- ⬜ Subarray Sum = K
- ⬜ Prefix Sum + Modulo
- ⬜ Prefix Sum + Deque
- ⬜ 2D Prefix Sum
- ⬜ Other high-value Prefix Sum variations

> Goal: Learn the major Prefix Sum patterns deeply enough to recognize when Prefix Sum is the right tool, rather than maximizing the number of questions solved.
