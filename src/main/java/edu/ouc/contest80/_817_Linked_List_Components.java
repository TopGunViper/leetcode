package edu.ouc.contest80;

import java.util.HashSet;
import java.util.Set;

public class _817_Linked_List_Components {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> g = new HashSet<>();
        for (int i : G) g.add(i);
        //g.addAll();
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            if(g.contains(cur.val)){
                count++;
                while(cur != null && g.contains(cur.val)){
                    cur = cur.next;
                }
            }else {
                cur = cur.next;
            }

        }
        return count;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String args[]) {
        //test case1
        _817_Linked_List_Components
                tester = new _817_Linked_List_Components();

    }
}
