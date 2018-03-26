package edu.ouc.linkedlist;

import edu.ouc.ListNode;

/**
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. 

 * @author wqx
 *
 */
public class _83_Remove_Duplicates_from_Sorted_List_E {
	/**
	 * 利用已知链表有序特性，容易很多
	 * @param head
	 * @return
	 */
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null || head.next == null) return head;
        ListNode p = head,q = head.next;
        while(q != null){
        	if(p.val == q.val){
        		p.next = q.next;
        		q = q.next;
        	}else{
        		p = q;
        		q = q.next;
        	}
        }
        return head;
    }
}
