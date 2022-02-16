class Solution {
    
    
    public ListNode swapPairs(ListNode head){
        if(head==null || head.next==null){return head;}
        ListNode A=head,B=A.next;
        A.next=B.next;
        B.next=A;
        A.next=swapPairs(A.next);
        return B;
    }
}
