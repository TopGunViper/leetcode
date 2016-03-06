package edu.ouc.linkedlist;

import edu.ouc.ListNode;

public class _2_Add_Two_Numbers_Medium {

	/**
	 * Question:
	 * 
	 * You are given two linked lists representing two non-negative numbers. 
	 * The digits are stored in reverse order and each of their nodes contain a single digit.
	 * Add the two numbers and return it as a linked list.
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node1,node2,p;
		node1 = l1;node2 = l2;
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		ListNode result = new ListNode((node1.val + node2.val)%10);
		result.next = null;
		p = result;
		int c = (node1.val + node2.val)/10;
		node1 = node1.next;node2 = node2.next;
		while(node1 != null && node2 != null){
			int val = node1.val + node2.val + c;
			c = val/10;
			val %= 10;
			//System.out.println("val=" +val + "c=" + c);
			ListNode tmp = new ListNode(val);
			tmp.next = p.next;
			p.next = tmp;p=tmp;
			node1 = node1.next;node2 = node2.next;
		}
		ListNode notNull = node1 == null ? node2 : node1;

		while(notNull != null){
			int val = notNull.val + c;
			c = val/10;
			val %= 10;
			//System.out.println("val:" + val);
			ListNode tmp = new ListNode(val);
			tmp.next = p.next;
			p.next = tmp;p=tmp;
			notNull = notNull.next;
		}
		if(c != 0){
			ListNode tmp = new ListNode(c);
			tmp.next = p.next;
			p.next = tmp;p=tmp;
		}
		return result;

	}
	/**
	 * 优化解法
	 */
	public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
	    if(l1==null) return l2;
	    if(l2==null) return l1;

	    ListNode head = new ListNode(0);
	    ListNode p = head;

	    int tmp = 0;
	    while(l1!=null || l2!=null || tmp!=0) {
	        if(l1!=null) {
	            tmp += l1.val;
	            l1 = l1.next;
	        }
	        if(l2!=null) {
	            tmp += l2.val;
	            l2 = l2.next;
	        }

	        p.next = new ListNode(tmp%10);
	        p = p.next;
	        tmp = tmp/10;
	    }
	    return head.next;
	}
}
