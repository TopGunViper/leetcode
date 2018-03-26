package edu.ouc.linkedlist;

public class _237_DeleteNodeinaLinkedList_Easy {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
	 public void deleteNode(ListNode node) {
	        if(node == null || node.next == null){
	        	return;
	        }
	        node.val = node.next.val;
	        node.next = node.next.next;
	 }
}
