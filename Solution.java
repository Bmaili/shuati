import java.io.ObjectInputFilter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val,  ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dumpmyHead = new ListNode();
        dumpmyHead.next = head;
        ListNode tmp = dumpmyHead;

        while (tmp.next!=null&&tmp.next.next!=null){
            ListNode n1 = tmp.next;
            ListNode n2 = tmp.next.next;
            tmp.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            tmp = n1;
        }



        return dumpmyHead.next;
    }

    public static void main(String[] args) {

    }
}
