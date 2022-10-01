package A_OUEI.yamaxun_ouei.former;

import java.util.ArrayList;
import java.util.List;

/*
leetcode2221
https://leetcode.cn/problems/find-triangular-sum-of-an-array/
 */
public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle pas = new PascalTriangle();

    }

    public int triangularSum(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
        }
        while (res.size() > 1) {
            res = bfs(res);
        }
        return res.get(0);
    }
    public List<Integer> bfs(List<Integer> res) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < res.size() - 1; i++) {
            temp.add((res.get(i) + res.get(i + 1)) % 10);
        }
        return temp;
    }

}
