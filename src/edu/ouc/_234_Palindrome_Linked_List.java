package edu.ouc;

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
    	//找到中间节点
    	while(q.next != null && q.next.next != null){
    		p = p.next; 
    		q = q.next.next;
    	}
    	ListNode pre = p.next;
    	if(pre == null)
    		return true;
    	q = pre.next;
    	//逆置后半段链表
    	pre.next = null;
    	while(q != null){
    		ListNode tmp = q.next;
    		q.next = pre;
    		pre = q;
    		q = tmp;
    	}
    	System.out.println("pre.val:" + pre.val);
    	p = head;
    	//比较链表是否相同
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
