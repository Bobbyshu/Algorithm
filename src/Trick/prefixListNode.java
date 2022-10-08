package Trick;
// leetcode 1171，链表前缀和 (动态删除连续为0)
// 利用虚拟头节点来防止第一个节点需要被删除而导致的空指针，哈希表也要入表dummy, 0。
// 就是类似用哈希表记录前缀和，然后疯狂跳前缀和相等的格子，因为前缀和如果相等就说明中间那段的区间和为0

import java.util.HashMap;
import java.util.Map;

public class prefixListNode {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> prefix = new HashMap<>();
        int sum = 0;

        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            prefix.put(sum, d);
        }

        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            d.next = prefix.get(sum).next;
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
