# Meeting Rooms

## Approach

Sort the `start` and `end` arrays separately.

Use two pointers:
- `i` → next meeting starting
- `j` → earliest meeting ending

If `start[i] < end[j]`, a new meeting starts before the current meeting ends, so we need another room.

Otherwise, a meeting has ended and its room can be reused.

Track the maximum number of rooms required using `result`.

## Code

class Solution {
    public int minMeetingRooms(int[] start, int[] end) {

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;

        int room = 0;
        int result = 0;

        while (i < start.length && j < end.length) {

            if (start[i] < end[j]) {
                room++;
                result = Math.max(result, room);
                i++;
            } else {
                room--;
                j++;
            }
        }

        return result;
    }
}
