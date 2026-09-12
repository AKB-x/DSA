# 📦 Interval Intersection — LeetCode 986

## 🧩 Pattern

**Two Pointers + Intervals**

## 💡 Approach

We have two lists of sorted, non-overlapping intervals.

Use two pointers:
- `i` → current interval in `firstList`
- `j` → current interval in `secondList`

At every step, compare the two current intervals.

### 🔑 Finding the Intersection

The intersection starts at the later start point:

`start = max(start1, start2)`

The intersection ends at the earlier end point:

`end = min(end1, end2)`

If:

`start <= end`

then an intersection exists, so add `[start, end]` to the result.

### 🔄 Moving the Pointers

After checking the intersection, compare the ending points:

`if (end1 <= end2)`

Move `i` forward.

Otherwise, move `j` forward.

### 🧠 Why?

The interval that ends first cannot intersect with any future interval from the other list, so that interval is finished and its pointer can be moved.

### ⚠️ Important Java Detail

When comparing the starting points, use `else if` rather than two separate `if` statements.

If:

`start1 == start2`

both conditions would be true and the same intersection would be added twice.

### 🎯 Key Takeaway

> **Find the overlap using max(start) and min(end), add it if valid, then move the pointer of the interval that ends first.**

## 💻 Solution

```java
class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        ArrayList<int[]> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {

            int start1 = firstList[i][0];
            int end1 = firstList[i][1];

            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            if (start1 <= start2) {

                if (end1 >= start2) {
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                    result.add(new int[]{s, e});
                }

            } else if (start2 <= start1) {

                if (end2 >= start1) {
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                    result.add(new int[]{s, e});
                }
            }

            if (end1 <= end2) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
