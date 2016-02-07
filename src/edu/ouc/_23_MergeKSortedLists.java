package edu.ouc;

/**
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 *  
 * @author wqx
 *
 */
public class _23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
    	return mergeSort(lists,0,lists.length-1);
    }
    public ListNode mergeSort(ListNode[] list,int low,int high){
    	if(low == high) return list[low];
    	if(low < high){
    		int mid = (low+high)/2;
    		ListNode l1 = mergeSort(list,low,mid);
    		ListNode l2 = mergeSort(list,mid+1,high);
    		return merge(l1,l2);
    	}
    	return null;
    }
    public ListNode merge(ListNode l1,ListNode l2){
    	if(l1 == null)
    		return l2;
    	if(l2 == null)
    		return l1;
    	if(l1.val < l2.val){
    		l1.next = merge(l1.next,l2);
    		return l1;
    	}else{
    		l2.next = merge(l1,l2.next);
    		return l2;
    	}
    }
}