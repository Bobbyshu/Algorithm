package yamaxun_ouei.former;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
The numbers of awards per movie are awards = [1, 5, 4, 6, 8, 9, 2]
and the maximum allowed difference is k = 3.
One way to divide the movies into the minimum number of groups is:
The first group can contain [2, 1]
The maximum difference between awards of any two movies is 1 which does not exceed K.
The second group can contain [5, 4, 6]
The maximum difference between awards of any two movies is 2 which does not exceed k.
The third group can contain [8,9]
The maximum difference between awards of any two movies is 1 which does not exceed k.
The movies can be divided into a minimum of 3 groups.
 */
public class MovieAward {
    public static void main(String[] args) {
        MovieAward award = new MovieAward();
        int[] nums = new int[]{1,5,4,6,8,9,2};
        System.out.println(award.award(nums, 3));
    }

    int award(int[] nums, int k) {
        Arrays.sort(nums);
        Deque<Integer> queue = new ArrayDeque<>();
        int segement = 0;

        for (int num : nums) {
            if (!queue.isEmpty() && num >= queue.peekFirst() + k) {
                queue.clear();
                segement++;
            }
            queue.addLast(num);
        }

        return segement + 1;
    }
}
