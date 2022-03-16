package easy;

//160. 相交链表
// https://leetcode-cn.com/problems/intersection-of-two-linked-lists/


import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class GetIntersectionNode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null||headB==null) {
            return null;
        }
        Set<ListNode> listNodes = new HashSet<>();
        while(headA!=null){
            listNodes.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(listNodes.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }

        return null;
    }
}
