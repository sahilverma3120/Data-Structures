
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next == null) { // fast and slow pointer method to detect cycle
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast == null || fast.next == null) // if any of the conditions match then there is no cycle
            return null;
        slow = head; // to find out why this is done, visit the given link
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
