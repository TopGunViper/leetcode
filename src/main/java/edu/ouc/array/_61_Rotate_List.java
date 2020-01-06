package edu.ouc.array;

import edu.ouc.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 */
public class _61_Rotate_List {

    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while (cur != null){
            len ++;
            cur = cur.next;
        }
        if(len == 0 || len == 1 || k % len == 0 || k == 0){
            return head;
        }
        k = k < len ? k : k % len;
        ListNode fast = head, slow = head;
        int step = 0;
        while (fast.next != null){
            if(step < k){
                step++;
                fast = fast.next;
            }else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        ListNode tmp = slow.next;
        slow.next = null;
        fast.next = head;
        head = tmp;
        return head;
    }

    /**
     * find medium element in single linked list.
     *
     */
    ListNode getMidElem(ListNode L){
        if(L == null){
            return null;
        }
        ListNode first = L;
        ListNode second = L;
        while(first != null && first.next != null){
            first = first.next.next;
            second = second.next;
        }
        return second;
    }

    public static void main(String[] args) {
        _61_Rotate_List tester =
                new _61_Rotate_List();
        String s = "hello";
    }
}
