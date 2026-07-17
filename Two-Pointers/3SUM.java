# 3Sum

**LeetCode:** 15  
**Difficulty:** Medium  
**Pattern:** Sorting + Two Pointers

---

## Problem Statement

Given an integer array `nums`, return all the **unique triplets** `[nums[i], nums[j], nums[k]]` such that:

- `i != j`
- `j != k`
- `i != k`
- `nums[i] + nums[j] + nums[k] == 0`

The solution set must not contain duplicate triplets.

---

# Pattern Recognition

Use this pattern when:

- The problem asks for **unique triplets/pairs**
- The array **can be sorted**
- The target is a fixed sum
- Duplicate answers must be avoided

---

# Intuition

Instead of checking every possible triplet (`O(n³)`):

1. Sort the array.
2. Fix one element.
3. Convert the remaining problem into **Two Sum**.
4. Solve it using the **Two Pointer** technique.

Sorting allows meaningful pointer movement and makes duplicate handling easy.

---

# Algorithm

1. Sort the array.
2. Iterate through each element.
3. Skip duplicate fixed elements.
4. Set

```java
left = i + 1;
right = nums.length - 1;
target = -nums[i];
```

5. Search using Two Pointers.
6. Store valid triplets.
7. Move both pointers.
8. Skip duplicate `left` and `right` values.

---

# Thinking Process

### Current State

```
fixed, left, right
```

### Extract Information

```
sum = nums[left] + nums[right]
```

### Update Answer

If

```
sum == target
```

store the triplet.

### Change State

```
sum < target
    left++

sum > target
    right--

sum == target
    store answer
    left++
    right--
    skip duplicates
```

Repeat until

```
left >= right
```

---

# Duplicate Handling

## Fixed Pointer

```java
if(i > 0 && nums[i] == nums[i - 1])
    continue;
```

Avoids generating the same triplets again.

---

## Left Pointer

After

```java
left++;
```

skip duplicate values.

Reason:

The previous value has already produced every possible triplet.

---

## Right Pointer

After

```java
right--;
```

skip duplicate values.

Reason:

The previous value has already been considered.

---

# Invariant

For every fixed element,

```
left ............... right
```

represents the remaining search space.

Every pointer movement shrinks this search space.

No discarded element can contribute to a new valid triplet.

---

# Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time | O(n²) |
| Space | O(1) (excluding output) |

---

# Common Mistakes

- Forgetting to sort the array.
- Starting `left` from `0`.
- Not skipping duplicate fixed elements.
- Not skipping duplicate `left` and `right` values.
- Skipping duplicates **before** moving the pointers.
- Comparing the wrong indices while removing duplicates.

---

# Key Insight

> **3Sum is simply:**

```
Sort
      ↓
Fix One Element
      ↓
Two Sum (Two Pointers)
      ↓
Skip Duplicates
```

It is **not** a completely new algorithm. It is a combination of already known patterns.

---

# What I Learned

- How sorting enables the Two Pointer technique.
- How to reduce a 3Sum problem into a Two Sum problem.
- Why duplicate handling is required.
- Why pointers always move inward.
- How to maintain a shrinking search space.
- How to derive the algorithm instead of memorizing it.

---

# Related Problems

- Two Sum II
- 3Sum Closest
- 4Sum
- Container With Most Water
- Two Sum
