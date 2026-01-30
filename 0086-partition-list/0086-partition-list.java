/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallElements = new ListNode(0);
        ListNode bigElements = new ListNode(0);

        ListNode small = smallElements;
        ListNode big = bigElements;

        while(head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
            }else{
                big.next=head;
                big = big.next;
            }
            head = head.next;
        }

        big.next = null;
        small.next = bigElements.next;
        return smallElements.next;
    }
}