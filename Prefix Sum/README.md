# 🧮 Prefix Sum Pattern

## 📌 Description

Prefix Sum is a technique used to store **cumulative information** from an array so that we can answer sum-related questions efficiently.

Instead of repeatedly calculating the sum of a range or subarray, we precompute cumulative sums and reuse them.

Prefix Sum is not limited to a `prefix[]` array. Depending on the problem, it can be combined with:

- A running variable
- A Prefix Sum array
- A HashMap
- Modulo
- A Monotonic Deque
- 2D Prefix Sum

---

# 🎯 When to Use

Consider Prefix Sum when a problem involves:

- Range sums
- Subarray sums
- Sum between two indices
- Cumulative sums
- Counting subarrays with a particular sum
- Finding subarrays with a target sum
- Divisibility of subarray sums
- Matrix / rectangular range sums

### 🚨 Strong Trigger

> **If a problem involves subarrays/ranges and their sums, consider Prefix Sum.**

---

# 🧠 Core Idea

Given:

```text
nums = [2, 4, 1, 3, 5]
```

The cumulative sums are:

```text
2
2 + 4 = 6
2 + 4 + 1 = 7
2 + 4 + 1 + 3 = 10
2 + 4 + 1 + 3 + 5 = 15
```

A common implementation adds an extra `0` at the beginning:

```text
prefix = [0, 2, 6, 7, 10, 15]
```

The extra `0` represents the sum of zero elements.

The idea is:

> **Calculate cumulative information once and reuse it instead of recalculating sums repeatedly.**

---

# 📐 Prefix Sum Definition

Using an extra `0`:

```text
prefix[i] = sum of the first i elements
```

Therefore:

```text
prefix[0] = 0
prefix[1] = nums[0]
prefix[2] = nums[0] + nums[1]
prefix[3] = nums[0] + nums[1] + nums[2]
...
```

Standard construction:

```java
int[] prefix = new int[nums.length + 1];

for (int i = 0; i < nums.length; i++) {
    prefix[i + 1] = prefix[i] + nums[i];
}
```

---

# 🔑 Range Sum Formula

To find the sum from index `L` to `R`:

```text
sum(L ... R) = prefix[R + 1] - prefix[L]
```

Why?

```text
prefix[R + 1]
=
sum of everything from index 0 through R

prefix[L]
=
sum of everything before index L
```

Subtracting them removes everything before `L`.

What remains is:

```text
nums[L] + nums[L + 1] + ... + nums[R]
```

---

# ⭐ Prefix Sum Without an Array

We don't always need a `prefix[]` array.

Sometimes a single running variable is enough:

```java
int prefixSum = 0;
```

If we only need the current cumulative sum, this gives:

```text
Space = O(1)
```

instead of:

```text
Space = O(n)
```

for a complete prefix array.

### General Idea

```text
prefixSum
    ↓
running cumulative information
    ↓
use it to calculate the required result
```

---

# 🚨 Prefix Sum + HashMap

One of the most important interview extensions is:

```text
Prefix Sum + HashMap
```

Suppose we want to find/count a subarray whose sum is `K`.

Let:

```text
currentPrefix
```

be the cumulative sum up to the current index.

Suppose an earlier prefix sum was:

```text
previousPrefix
```

Then the sum between them is:

```text
currentPrefix - previousPrefix
```

We want:

```text
currentPrefix - previousPrefix = K
```

Rearranging:

```text
previousPrefix = currentPrefix - K
```

Therefore, while traversing the array, we can check:

```text
Have we seen currentPrefix - K before?
```

If yes, the elements between those two prefix positions have sum `K`.

This gives the important pattern:

```text
Prefix Sum + HashMap
```

For counting problems, the HashMap usually stores:

```text
prefixSum → frequency
```

because the same prefix sum can occur multiple times.

---

# 🔢 Prefix Sum + Modulo

Some problems involve divisibility instead of an exact target sum.

Suppose we want a subarray whose sum is divisible by `K`.

If two prefix sums have the same remainder:

```text
prefix[i] % K == prefix[j] % K
```

then:

```text
(prefix[j] - prefix[i]) % K = 0
```

Therefore, the subarray between those positions has a sum divisible by `K`.

This leads to:

```text
Prefix Sum + Modulo + HashMap
```

---

# 📦 Prefix Sum + Monotonic Deque

Prefix Sum can also be combined with a **Monotonic Deque** for harder problems.

A major example is:

```text
Shortest Subarray with Sum at Least K
```

This becomes important when negative numbers are present and a normal sliding-window approach cannot be used.

The combination is:

```text
Prefix Sum
    +
Monotonic Deque
```

---

# 🧮 2D Prefix Sum

The same idea can be extended from arrays to matrices.

Instead of repeatedly calculating the sum of a rectangular region, we precompute cumulative sums for the matrix.

This allows rectangular range sums to be answered efficiently.

The core idea remains:

```text
Precompute cumulative information
        ↓
Use previous information
        ↓
Avoid repeatedly traversing the same region
```

---

# 🆚 Prefix Sum vs Kadane

Both can involve subarrays and sums, but their goals are different.

## Kadane

Usually asks:

```text
What is the maximum/minimum subarray sum?
```

Think:

```text
Kadane
→ Optimize a subarray sum
```

## Prefix Sum

Usually asks:

```text
What is the cumulative sum?

What is the sum between two positions?

Can two prefix sums tell me something about a subarray?
```

Think:

```text
Prefix Sum
→ Use cumulative sums to reason about ranges/subarrays
```

---

# 🆚 Prefix Sum vs Sliding Window

## Sliding Window

Maintains a moving range:

```text
left ←──── window ────→ right
```

and expands/shrinks the window according to a condition.

## Prefix Sum

Stores cumulative information:

```text
prefix
  ↓
difference between prefix sums
  ↓
range/subarray information
```

Prefix Sum is especially useful when negative numbers make a normal sliding-window strategy unsuitable.

---

# 🎯 Recognition Patterns

### 1. Range Sum

> "Find the sum from `L` to `R`."

Think:

```text
Prefix Sum
```

Formula:

```text
sum(L ... R) = prefix[R + 1] - prefix[L]
```

---

### 2. Subarray Sum = K

> "Find/count subarrays whose sum is K."

Think:

```text
Prefix Sum + HashMap
```

Key relationship:

```text
previousPrefix = currentPrefix - K
```

---

### 3. Sum Divisible by K

Think:

```text
Prefix Sum + Modulo + HashMap
```

---

### 4. Shortest Subarray With Sum ≥ K

Think:

```text
Prefix Sum + Monotonic Deque
```

---

### 5. Matrix Range Sum

Think:

```text
2D Prefix Sum
```

---

# ⚠️ Common Mistakes

### 1. Off-by-One Errors

With an extra `0`:

```text
prefix[i + 1] = prefix[i] + nums[i]
```

and:

```text
sum(L ... R) = prefix[R + 1] - prefix[L]
```

---

### 2. Forgetting the Extra `0`

Prefer:

```text
prefix = [0, ...]
```

because it makes the range formula work uniformly even when:

```text
L = 0
```

---

### 3. Confusing Prefix Index With Array Index

For:

```text
nums[i]
```

the corresponding prefix position is:

```text
prefix[i + 1]
```

---

### 4. Updating a Running Prefix Too Early

If the current index is being checked, make sure the running prefix represents exactly the elements that should belong to the prefix side.

Always be clear about:

```text
What does my prefix variable represent RIGHT NOW?
```

---

### 5. Forgetting Frequency With HashMap

For counting subarrays, store:

```text
prefixSum → frequency
```

not just whether a prefix sum exists.

The same prefix sum can occur multiple times, and each occurrence may represent another valid subarray.

---

# ⏱️ Complexity

## Prefix Array

Building:

```text
O(n)
```

Each range query:

```text
O(1)
```

Space:

```text
O(n)
```

---

## Running Prefix Variable

Traversal:

```text
O(n)
```

Space:

```text
O(1)
```

---

## Prefix Sum + HashMap

Typical traversal:

```text
O(n)
```

Extra space:

```text
O(n)
```

---

# 🧠 Interview Approach

When you see a sum-related array problem, ask:

```text
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
```

---

# ⭐ Key Takeaway

Prefix Sum is fundamentally about:

```text
Cumulative Information
        ↓
Reuse Previous Work
        ↓
Avoid Recalculating Sums
```

The fundamental range formula is:

```text
sum(L ... R) = prefix[R + 1] - prefix[L]
```

One of the most important interview extensions is:

```text
Prefix Sum + HashMap
```

with the key relationship:

```text
previousPrefix = currentPrefix - target
```

The goal is **not** to memorize a single Prefix Sum template.

The goal is to recognize:

> **"This problem is asking me to reason about cumulative sums or the difference between two cumulative sums."**

When you recognize that, Prefix Sum should come to mind.

---

# 📈 Pattern Progress

### Prefix Sum

[███░░░░░░░░░░░░░░░░░] Pattern Started

### Core Variations

- ⬜ Basic Prefix Sum
- ⬜ Running Prefix Sum
- ⬜ Prefix Sum + HashMap
- ⬜ Prefix Sum + Modulo
- ⬜ Prefix Sum + Monotonic Deque
- ⬜ 2D Prefix Sum

> Goal: Learn the major Prefix Sum variations deeply enough to recognize when Prefix Sum is the right tool, rather than maximizing the number of questions solved.
