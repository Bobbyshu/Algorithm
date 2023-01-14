package GuCheng.Fundmental.Algo.D_MonotonicStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NextGreaterNodeInLinkedList1019 {
  public int[] nextLargerNodes(ListNode head) {
    //list to arr and use the framework
    List<Integer> list = new ArrayList<>();

    while (head != null) {
      list.add(head.val);
      head = head.next;
    }

    int[] res = new int[list.size()];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = res.length - 1; i >= 0; --i) {
      while (!stack.isEmpty() && list.get(i) >= stack.peekLast()) {
        stack.pollLast();
      }
      res[i] = stack.isEmpty() ? 0 : stack.peekLast();
      stack.addLast(list.get(i));
    }

    return res;
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
