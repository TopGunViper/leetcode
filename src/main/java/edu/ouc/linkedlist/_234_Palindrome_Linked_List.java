package edu.ouc.linkedlist;

import edu.ouc.ListNode;

/*
 * Given a singly linked list, determine if it is a palindrome.
 *	Follow up:
 *	Could you do it in O(n) time and O(1) space?
 */
public class _234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
    	if(head == null || head.next == null)
    		return true;
    	ListNode p = head,q = head;
    	//�ҵ��м�ڵ�
    	while(q.next != null && q.next.next != null){
    		p = p.next; 
    		q = q.next.next;
    	}
    	ListNode pre = p.next;
    	if(pre == null)
    		return true;
    	q = pre.next;
    	//���ú�������
    	pre.next = null;
    	while(q != null){
    		ListNode tmp = q.next;
    		q.next = pre;
    		pre = q;
    		q = tmp;
    	}
    	System.out.println("pre.val:" + pre.val);
    	p = head;
    	//�Ƚ������Ƿ���ͬ
    	while(pre != null){
    		if(pre.val != p.val){
    			return false;
    		}
    		pre = pre.next;
    		p = p.next;
    	}
		return true;
    }
}
