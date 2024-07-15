package Leetcode.weeklycontest.Normal.NO406;

import java.util.HashSet;
import java.util.Set;

public class t2 {
  public ListNode modifiedList(int[] nums, ListNode head) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      set.add(n);
    }

    ListNode dummy = new ListNode(0, head);
    ListNode cur = dummy;
    while (cur.next != null) {
      if (set.contains(cur.next.val)) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return dummy.next;
  }
}
class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
