# Binary Search

## Pattern Overview

Binary Search is a search technique that repeatedly eliminates half of the search space.

Instead of checking every element one by one:

O(n)

we reduce the search space:

n → n/2 → n/4 → n/8 → ... → 1

giving:

Time: O(log n)
Space: O(1)

The fundamental idea is:

> Check the middle → determine which half can be eliminated → continue searching in the remaining half.

---

## When to Recognize Binary Search

Look for:

- A sorted array or search space
- A target/value that needs to be found
- A condition that tells us whether to move left or right
- A search space where one decision can eliminate roughly half of the possibilities

### Important

Don't only ask:

> "Is the array sorted?"

Also ask:

> "Can I eliminate half of the search space based on some condition?"

This becomes especially important for Binary Search on Answer.

---

# 1. Basic Binary Search

### Example

nums = [1, 3, 5, 7, 9, 12, 15]
target = 9

Search using three pointers:

low → beginning of search space
high → end of search space
mid → middle of search space

Check nums[mid].

- nums[mid] == target → found
- nums[mid] < target → target must be on the right
- nums[mid] > target → target must be on the left

---

# 2. Basic Template

    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        else if (target > nums[mid]) {
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }
    }

    return -1;

---

# 3. Pointer Meaning

### low

Beginning of the current search space.

    low = 0;

### high

End of the current search space.

    high = nums.length - 1;

### mid

Middle of the current search space.

    mid = low + (high - low) / 2;

Using:

    (low + high) / 2

can cause integer overflow for very large values, so prefer:

    low + (high - low) / 2

---

# 4. Eliminating the Search Space

Suppose:

    [1, 3, 5, 7, 9, 12, 15]
              ↑
             mid

If:

    target > nums[mid]

then everything on the left of mid can be eliminated.

    low = mid + 1;

If:

    target < nums[mid]

then everything on the right of mid can be eliminated.

    high = mid - 1;

### Mental Model

    [ eliminated | mid | remaining ]

Every iteration removes one half of the search space.

---

# 5. Why low <= high?

Use:

    while (low <= high)

because when:

    low == high

there is still one element left to check.

Example:

    low
     ↓
    [ 7 ]
     ↑
    high

That element is still a valid candidate.

---

# 6. Binary Search Pattern Family

Binary Search is larger than basic exact search.

    Binary Search
         |
         +-- Exact Search
         |
         +-- Boundary Search
         |
         +-- Rotated Sorted Array
         |
         +-- Find Minimum / Peak
         |
         +-- Binary Search on Answer

---

# 6.1 Exact Search

Question:

> Does this target exist, and where?

Example:

    [1, 3, 5, 7, 9]
             ↑
           target

Basic Binary Search handles this.

---

# 6.2 Boundary Search

Instead of finding an exact value, find a boundary or transition.

Example:

    False False False False True True True True
                              ↑
                         first True

Typical problems:

- First occurrence
- Last occurrence
- Lower Bound
- Upper Bound
- First element >= target
- First element > target

The important idea is:

> Find where a condition changes.

---

# 7. Monotonic Search Space

A condition is monotonic when it doesn't keep switching back and forth.

Valid:

    F F F F F T T T T

or:

    T T T T F F F F

There is a single transition.

Invalid:

    F T F T T F T

because the condition keeps changing.

Binary Search needs a predictable direction so that one half can be eliminated.

---

# 8. Binary Search on Answer

The array itself doesn't necessarily have to be sorted.

Instead, the possible answers have to form a monotonic search space.

Example:

    Possible Answer:
    1  2  3  4  5  6  7  8

    Feasible:
    F  F  F  F  T  T  T  T
                ↑
           first feasible

We can binary search for the first feasible answer.

### Common Question Patterns

Look for wording like:

- Minimum possible...
- Maximum possible...
- Smallest value such that...
- Largest value such that...
- Can we finish within X?
- Is X feasible?
- Minimum capacity...
- Minimum speed...
- Minimum time...

The key question becomes:

> If I choose a value X, can I efficiently check whether X works?

If the answer is yes and feasibility is monotonic, Binary Search may apply.

---

# 9. General Recognition Framework

When looking at a problem, ask:

    1. What is my search space?
           ↓
    2. Is it sorted or monotonic?
           ↓
    3. What does mid tell me?
           ↓
    4. Which half can I eliminate?
           ↓
    5. How do I move low/high?
           ↓
    6. What should I return when the search ends?

---

# 10. Common Variations

### Basic

Find target.

### Boundary

Find first / last valid position.

### Rotated Sorted Array

Find target in a rotated sorted array.

Example:

    [4, 5, 6, 7, 0, 1, 2]

### Minimum in Rotated Array

Find the minimum element.

### Peak

Find a peak element.

### Binary Search on Answer

Find minimum/maximum feasible value.

---

# 11. Common Mistakes

### Mistake 1 — Wrong Pointer Update

Don't do:

    low = mid;

when mid has already been checked.

Usually:

    low = mid + 1;
    high = mid - 1;

---

### Mistake 2 — Wrong Loop Condition

For the standard exact-search template:

    while (low <= high)

---

### Mistake 3 — Incorrect Midpoint

Prefer:

    int mid = low + (high - low) / 2;

---

### Mistake 4 — Not Identifying the Search Space

Before writing Binary Search, define:

> What exactly am I searching?

It could be:

- Array indices
- Values
- Positions
- Capacity
- Speed
- Time
- Another numerical answer

---

# 12. Complexity

For a search space of size n:

    n
    ↓
    n/2
    ↓
    n/4
    ↓
    n/8
    ↓
    ...
    ↓
    1

Therefore:

Time Complexity: O(log n)
Space Complexity: O(1)

for the standard iterative implementation.

---

# Mental Model

> Binary Search = Define Search Space → Check Middle → Eliminate Half → Repeat

For harder problems:

> Don't ask only whether the array is sorted. Ask whether the search space has a monotonic property that lets you eliminate half.

---

# Pattern Progression

    Binary Search
         |
         +-- Basic Exact Search
         |
         +-- First / Last Occurrence
         |
         +-- Lower Bound / Upper Bound
         |
         +-- Rotated Sorted Array
         |
         +-- Find Minimum / Peak
         |
         +-- Binary Search on Answer
                  |
                  +-- Minimum Feasible
                  |
                  +-- Maximum Feasible

---

## Core Template

    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {

        int mid = low + (high - low) / 2;

        if (condition satisfied) {
            // found / move toward answer
        }
        else if (condition tells us to go right) {
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }
    }

---

## Core Idea

Don't memorize Binary Search as a single piece of code.

Learn to identify:

1. The search space
2. The condition at mid
3. Which half can be eliminated
4. How low / high should move
5. What the final answer represents
