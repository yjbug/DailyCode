package yj.lintcode;

import tools.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class AddTwoSum {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode pre = new ListNode(0);
        ListNode res = pre;
        int carry = 0;
        int a,b;
        while(carry!=0||l1!=null||l2!=null){
            a=0;
            b=0;
            if(l1!=null){
                a=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                b=l2.val;
                l2 = l2.next;
            }
            int temp = a+b+carry;
            carry = temp/10;
            pre.next = new ListNode(temp%10);
            pre = pre.next;
        }
        return res.next;
    }
}