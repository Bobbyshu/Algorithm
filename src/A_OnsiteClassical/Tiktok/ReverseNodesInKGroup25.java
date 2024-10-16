package A_OnsiteClassical.Tiktok;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseNodesInKGroup25 {
  public ListNode reverseKGroupStack(ListNode head, int k) {
    Deque<ListNode> stk = new ArrayDeque<>();
    ListNode dummy = new ListNode(0);

    ListNode p = dummy;
    while (true) {
      int cnt = 0;
      ListNode temp = head;
      while (temp != null && cnt < k) {
        stk.add(temp);
        temp = temp.next;
        ++cnt;
      }

      if (cnt != k) {
        p.next = head;
        break;
      }

      while (!stk.isEmpty()) {
        p.next = stk.pollLast();
        p = p.next;
      }

      p.next = temp;
      head = temp;
    }

    return dummy.next;
  }

  public ListNode reverseKGroupRecursive(ListNode head, int k) {
    if (head == null)
      return null;

    ListNode a = head, b = head;
    for (int i = 0; i < k; i++) {
      if (b == null)
        return head;
      b = b.next;
    }

    ListNode newHead = reverse(a, b);
    a.next = reverseKGroupRecursive(b, k);
    return newHead;
  }

  ListNode reverse(ListNode head, ListNode tail) {
    ListNode cur = head, next = tail;
    ListNode pre = null;
    while (cur != tail) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
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


