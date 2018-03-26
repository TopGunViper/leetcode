package edu.ouc.linkedlist;

import edu.ouc.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 *  Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity 
and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ... 

 * @author wqx
 *
 */
public class _328_Odd_Even_Linked_List_E {
	/**
	 *  Memory Limit Exceeded 
	 *  
	 * @param head
	 * @return
	 */
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode evenList = new ListNode(0);
		evenList.next = null;
		ListNode tail = evenList;
		ListNode pre,p,tmp;

		pre = head;
		p = head.next;

		int step = 0;

		while(p != null){
			if(step%2 == 0){
				tmp = p;

				p = p.next;
				pre.next = p;

				tmp.next = tail.next;
				tail.next = tmp;
				tail = tmp;
			}else{
				p = p.next;
				pre = p;
			}
			step++;
		}
		pre.next = evenList.next;
		return head;
	}
	/**
	 * ”≈ªØ∞Ê
	 * 
	 * @param head
	 * @return
	 */
	public ListNode oddEvenList2(ListNode head) {
		if (head != null) {
			ListNode odd = head, even = head.next, evenHead = even; 
			while (even != null && even.next != null) {
				odd.next = odd.next.next; 
				even.next = even.next.next; 
				odd = odd.next;
				even = even.next;
			}
			odd.next = evenHead; 
		}
		return head;
	}
}
