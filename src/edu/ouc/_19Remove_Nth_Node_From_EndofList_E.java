package edu.ouc;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass. 


 * @author wqx
 *
 */
public class _19Remove_Nth_Node_From_EndofList_E {
	/**
	 * 双指针,一先一后
	 * 增加begin结点当作头结点，方便处理
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int step = 0;
        ListNode begin = new ListNode(0);
        ListNode p = begin,q = begin;
        begin.next = head;
        while(q != null){
        	if(step <= n){
        		q = q.next;
        		step++;
        	}else{
        		p = p.next;
        		q = q.next;
        	}
        }
        p.next = p.next.next;
        return begin.next;
    }
}
