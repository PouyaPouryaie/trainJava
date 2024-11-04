package basictrain.codetrain.leetcode.algorithm1.interview;

import java.util.*;

/* Overlapping Intervals
The Overlapping Intervals pattern is used to merge or handle overlapping intervals in an array.

In an interval array sorted by start time, two intervals [a, b] and [c, d] overlap if b >= c
(i.e., the end time of the first interval is greater than or equal to the start time of the second interval).

Explanation
1. Sort the intervals by their start time.
2. Create an empty list called merged to store the merged intervals.
3. Iterate through the intervals and check if it overlaps with the last interval in the merged list.
4. If it overlaps, merge the intervals by updating the end time of the last interval in merged.
5. If it does not overlap, simply add the current interval to the merged list.

Example:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

 */
public class MergeIntervals {

    public static void main(String[] args) {
//        var nums1 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        var nums1 = new int[][]{{1, 4}, {0, 0}};
//        var nums1 = new int[][]{{1, 4}, {0, 2}, {3, 5}};
        var nums1 = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        var k = 4;
        var result = merge(nums1);
        // because the array is 2D we use deepToString
        System.out.println("merge list: " + Arrays.deepToString(result));
    }

    public static int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] previous = intervals[0];
        List<int[]> merged = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(interval[0] <= previous[1]) {
                previous[1] = Math.max(previous[1], interval[1]);
            }else {
                merged.add(previous);
                previous = interval;
            }
        }
         merged.add(previous);

        return merged.toArray(new int[merged.size()][]);
    }
}
