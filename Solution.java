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
        if (head == null||head.next==null) {
            return head;
        }

        ListNode hair = new ListNode();
        ListNode res = hair;

        ListNode kNode =head;
        ListNode nextHair = head;

        while (true){
            for (int i = 1; i < k; i++) {
                if(kNode.next==null){
                    hair.next = head;
                    return res.next;
                }
                kNode = kNode.next;
            }
            nextHair = kNode;
            kNode = kNode.next;
            nextHair.next=null;
            hair.next = reverse(head, nextHair);
            hair=head;
            head = kNode;
            if(kNode==null){
                hair.next = head;
                return res.next;
            }
        }


    }
}