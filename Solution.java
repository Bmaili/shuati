/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
/* if (head == null || head.next == null) {
         return head;
         }
         ListNode newHead = reverseList(head.next);
         head.next.next = head;
         head.next = null;
         return newHead;*/

class Solution {
    ListNode reverse(ListNode head,ListNode tail) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next, tail);
        head.next.next=head;
        head.next=tail;
        return newHead;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode();
        ListNode res = hair;

        ListNode biaoji=head;
        ListNode kNode =head;

        outer:
        while (true) {
            int n = 0;
            ListNode star = biaoji;
            for (n = 0; n < k; n++) {
                if (kNode == null) {
                    break outer;
                }
                kNode = kNode.next;
            }
            biaoji = kNode.next;
            kNode.next = null;
            hair.next = reverse(star, kNode);
            hair = hair;

        }
        return res;
    }
}