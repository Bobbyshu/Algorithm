package A_OnsiteClassical.Tiktok;

import java.util.PriorityQueue;

public class NO23_MergekSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    return merge(lists, 0, lists.length - 1);
  }

  private ListNode merge(ListNode[] lists, int left, int right) {
    if (left == right) return lists[left];
    int mid = left + (right - left) / 2;
    ListNode l1 = merge(lists, left, mid);
    ListNode l2 = merge(lists, mid + 1, right);
    return mergeTwoLists(l1, l2);
  }

  private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1,l2.next);
      return l2;
    }
  }
  public ListNode mergeKListsPQ(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
    for (ListNode node : lists) {
      if (node != null) {
        pq.offer(node);
      }
    }

    ListNode dummyHead = new ListNode(0);
    ListNode cur = dummyHead;

    while (!pq.isEmpty()) {
      ListNode min = pq.poll();
      cur.next = min;
      cur = cur.next;
      if (min.next != null) {
        pq.offer(min.next);
      }
    }

    return dummyHead.next;
  }
}
