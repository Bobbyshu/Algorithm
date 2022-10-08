package Trick;
// leetcode 1171，链表前缀和
//

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
