package GuCheng.Fundmental.Algo.A_ScanLine;

import java.util.Arrays;

/*
给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。

只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。

在完成所有删除操作后，请你返回列表中剩余区间的数目。

输入：intervals = [[1,4],[3,6],[2,8]]
输出：2
解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 */
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        //这里如果左端点都一样的话，是应该把右端点大的先放在前面的，因为右端点大的区间才能覆盖更多
        Arrays.sort(intervals, (o1, o2) ->
                o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        //
        int cnt = 0, rightThreshold = 0;
        for (int[] i : intervals) {
            //只有遇到比他还大的门阀，才会扩大
            if (rightThreshold < i[1]) {
                rightThreshold = i[1];
                ++cnt;
            }
        }
        return cnt;
    }
}
