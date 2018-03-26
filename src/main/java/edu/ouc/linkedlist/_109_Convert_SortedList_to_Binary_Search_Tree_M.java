package edu.ouc.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.ouc.ListNode;
import edu.ouc.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * @author wqx
 * 2,Jan 2016
 */
public class _109_Convert_SortedList_to_Binary_Search_Tree_M {
    public static TreeNode sortedListToBST(ListNode head) {
    	ListNode node = head;
    	List<ListNode> list = new ArrayList<ListNode>();
    	while(node != null){
    		list.add(node);
    		node = node.next;
    	}
    	return createBST(list,0,list.size()-1);
    }
    private static TreeNode createBST(List<ListNode> list,int start,int end){
  	  if (start > end) return null;  
  	  int mid = start + (end - start) / 2;
  	  TreeNode node  = new TreeNode(list.get(mid).val);
  	  node.left = createBST(list, start, mid-1);
  	  node.right= createBST(list, mid+1, end);
  	  return node;
  }
}
