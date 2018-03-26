package edu.ouc.linkedlist;

import edu.ouc.ListNode;

/**
 * Reverse a singly linked list.
 * 
 * A linked list can be reversed either iteratively or recursively. 
 * Could you implement both?
 * 
 * 
 * @author wqx
 *
 */
public class _206_Reverse_Linked_List_E {
	/**
	 * ����ͷ��㣬iteratively
	 * 
	 * @param head
	 * @return
	 */
    public ListNode reverseList(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode q = head.next;
    	head.next = null;
    	//ͷ�巨
    	while(q != null){
    		ListNode tmp = q.next;
    		q.next = head;
    		head = q;
    		q = tmp;
    	}
    	return head;
    }
	/**
	 * ����ͷ��㣬recursively
	 * 
	 * @param head
	 * @return
	 */
    public ListNode reverseList_recursively(ListNode head) {
    	return null;
    }
}
