package GuCheng.Fundmental.Algo.A_ScanLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a sorted list of disjoint intervals, each interval represents the set of
real numbers x such that a <= x <= b
we remove the intersections between any intervals in 2D array
and the interval toBeRemoved

return a sorted list of intervals after all such removals
 */
public class RemoveInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] i : intervals) {
            // non-overlap
            if (i[1] <= toBeRemoved[0] || i[0] >= toBeRemoved[1]) {
                res.add(Arrays.asList(i[0], i[1]));
            } else {
                if (i[0] < toBeRemoved[0]) {
                    res.add(Arrays.asList(i[0], toBeRemoved[0]));
                }

                if (i[1] > toBeRemoved[1]) {
                    res.add(Arrays.asList(toBeRemoved[1], i[1]));
                }
            }
        }

        return res;
    }
}
