package edu.ouc.linkedlist;

import edu.ouc.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * @author wqx
 *
 */
public class _21_Merge_Two_Sorted_Lists_E {
	/**
	 * 递归实现合并两有序链表
	 * 
	 * @param l1
	 * @param l2
	 * @return 合并后的有序链表
	 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
    		return l2;
    	if(l2 == null)
    		return l1;
    	if(l1.val < l2.val){
    		l1.next = mergeTwoLists(l1.next,l2);
    		return l1;
    	}else{
    		l2.next = mergeTwoLists(l1,l2.next);
    		return l2;
    	}
    }
}
