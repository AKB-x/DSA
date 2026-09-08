## 📦 Merge Intervals

### LeetCode 56 — Merge Intervals

**Pattern:** Sorting + Intervals

**Approach:**
- Sort intervals by their starting point.
- Keep track of the current interval using `start1` and `end1`.
- Compare the next interval `[start2, end2]` with the current interval.
- If `end1 >= start2`, the intervals overlap, so merge them using `Math.max(end1, end2)`.
- If they don't overlap, add the current interval to the result and start processing the next interval.
- Add the final interval after the loop.

**Time Complexity:** `O(n log n)`

**Space Complexity:** `O(n)`

### Solution

```java
class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> result = new ArrayList<>();

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (end1 >= start2) {
                end1 = Math.max(end1, end2);
            } else {
                result.add(new int[]{start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }

        result.add(new int[]{start1, end1});

        return result.toArray(new int[result.size()][]);
    }
}
