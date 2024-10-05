package A_OnsiteClassical.MIE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KthLargestElementInArray {
  public int findKthLargest(int[] nums, int k) {
    List<Integer> lst = new ArrayList<>();
    for (int num : nums) {
      lst.add(num);
    }
    return quickSelect(lst, k);
  }

  public int quickSelect(List<Integer> nums, int k) {
    // pick random pivot
    Random rand = new Random();
    int pivot = nums.get(rand.nextInt(nums.size()));

    List<Integer> more = new ArrayList<>(), equal = new ArrayList<>(), less = new ArrayList<>();
    for (int num : nums) {
      if (num > pivot) {
        more.add(num);
      } else if (num == pivot) {
        equal.add(num);
      } else {
        less.add(num);
      }
    }

    if (k <= more.size()) {
      return quickSelect(more, k);
    }

    if (nums.size() - less.size() < k) {
      return quickSelect(less, k - nums.size() + less.size());
    }

    return pivot;
  }
}
