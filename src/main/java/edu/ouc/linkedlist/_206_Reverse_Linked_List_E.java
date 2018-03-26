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
	 * 不带头结点，iteratively
	 * 
	 * @param head
	 * @return
	 */
    public ListNode reverseList(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode q = head.next;
    	head.next = null;
    	//头插法
    	while(q != null){
    		ListNode tmp = q.next;
    		q.next = head;
    		head = q;
    		q = tmp;
    	}
    	return head;
    }
	/**
	 * 不带头结点，recursively
	 * 
	 * @param head
	 * @return
	 */
    public ListNode reverseList_recursively(ListNode head) {
    	return null;
    }
}
