package middle;

import java.util.Stack;

//445. 两数相加 II
//https://leetcode-cn.com/problems/add-two-numbers-ii/
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

public class AddTwoNumbers445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<Integer> objects = new Stack<>();
        Stack<Integer> objects2 = new Stack<>();
        int carry=0;
        while (l1!=null){
            objects.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            objects2.push(l2.val);
            l2=l2.next;
        }
        ListNode tail = null;
        while(!objects.isEmpty()||!objects2.isEmpty()||carry!=0){
            int a1=objects.isEmpty()?0:objects.pop();
            int a2=objects2.isEmpty()?0:objects2.pop();
            int sum=a1+a2+carry;
            ListNode no = new ListNode(sum % 10);
            no.next=tail;
            tail=no;
            carry=sum/10;
        }
        return tail;
    }
}
