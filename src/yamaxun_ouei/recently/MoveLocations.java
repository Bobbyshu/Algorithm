package yamaxun_ouei.recently;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MoveLocations {
    public int[] moveLocations(int[] nums, int[] from,int[] to) {
        Set<Integer> location = new HashSet<>();
        for (int num : nums) {
            location.add(num);
        }

        for (int i = 0; i < from.length; i++) {
            int f = from[i], t = to[i];
            location.remove(f);
            location.add(t);
        }

        int[] res = new int[location.size()];
        int index = 0;
        for (int loc : location) {
            res[index] = loc;
            index++;
        }

        Arrays.sort(res);
        return res;
    }
}
