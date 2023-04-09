package BISHI.Amazon.recently;

public class findLongestList {
    ListNode longest(ListNode head, int n) {
        if (head == null)
            return null;

        int[] nums = new int[n];
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            nums[index] = cur.val;
            index++;
            cur = cur.next;
        }

        int left = 0, right = 0;
        int len = 0;
        int leftIndex = 0;
        while (right < n) {
            while (right + 1 < n && nums[right] >= nums[right + 1]) {
                right++;

            }
        }

        return cur;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
