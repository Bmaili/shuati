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


class Solution {
    public ListNode reorderList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode h1 = head;
        ListNode h2 = head.next;



        return head;
    }
}