
/*Insertion Sort List
Medium


Share
Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.

*/

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
    public  ListNode insertionSortList(ListNode head) {
        ListNode first = new ListNode();
        first.next = head;
        ListNode before = null;
        while(head != null){
            ListNode next = head.next;
            ListNode temp = first;
            if(before != null && head.val <= before.val){
                while (temp.next != null && temp != head){
                    if(temp.next.val > head.val){
                        ListNode switchNode = head.next;
                        head.next = temp.next;
                        temp.next = head;
                        if(before != null){
                            before.next = switchNode;
                        }
                        break;
                    }
                    temp = temp.next;
                }
            }else {
                before = head;
            }
            head = next;
        }
        return first.next;
    }
}
