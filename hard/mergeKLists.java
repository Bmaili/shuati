package hard;

import java.util.PriorityQueue;

//https://leetcode-cn.com/problems/merge-k-sorted-lists/
// 23. 合并K个升序链表
//         给你一个链表数组，每个链表都已经按升序排列。
//
//         请你将所有链表合并到一个升序链表中，返回合并后的链表。


// Definition for singly-linked list.
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

public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode head = new ListNode();
        ListNode node = head;

        if (lists.length == 0) {
            return null;
        }

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }

        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            if (poll.next != null) {
                queue.add(poll.next);
            }
            node.next = poll;
            node = poll;
        }
        return head.next;
    }
}
