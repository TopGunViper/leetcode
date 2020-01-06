package edu.ouc.array;

import edu.ouc.ListNode;

/**
 *
 */
public class _142_Linked_List_Cycle_II {
    
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }

        if(fast == null || fast.next == null){
            return null;
        }
        // find entrance
        ListNode cur = head;
        while (cur != slow){
            slow = slow.next;
            cur = cur.next;
        }
        return slow;
    }

    public boolean detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }

        if(fast == null || fast.next == null){
            return false;
        }
        return true;
    }
	public static void main(String[] args) {
		
	}

}
