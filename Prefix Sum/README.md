# 🧮 Prefix Sum Pattern

## 📌 Description

Prefix Sum is a technique where we maintain **cumulative information** while traversing an array.

Instead of repeatedly calculating the sum of a range by traversing all its elements, we use previously calculated sums to obtain the required sum efficiently.

Prefix Sum is not limited to a `prefix[]` array. It can also be maintained using:

- A running variable
- A Prefix Sum array
- A HashMap
- Other data structures depending on the problem

---

# 🎯 When to Use

Consider Prefix Sum when a problem involves:

- Subarray sums
- Range sum queries
- Sum between two indices
- Finding a pivot/equilibrium index
- Counting subarrays with a target sum
- Finding subarrays with a particular sum
- Cumulative information
- Prefix Sum + HashMap
- Prefix Sum + Modulo

### 🚨 Strong Trigger

> **Subarray / range + sum / cumulative relationship**

→ Consider **Prefix Sum**.

---

# 🧠 Core Idea

Instead of calculating sums repeatedly, keep track of the sum calculated so far.

For example:

```text
nums = [1, 7, 3, 6, 5, 6]

running sum:

1
1 + 7 = 8
1 + 7 + 3 = 11
1 + 7 + 3 + 6 = 17
...
