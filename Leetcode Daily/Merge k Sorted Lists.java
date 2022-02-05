/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        
        int interval=1;
        while(interval<lists.length){
            for(int i=0;i+interval<lists.length;i=i+interval*2){
                lists[i]=mergeTwoLists(lists[i],lists[i+interval]);
            }
            interval*=2;
        }
        return lists[0];
    }
    
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode newHead=new ListNode(l1.val);
        ListNode temp=newHead;
        while(l2!=null && l1!=null){
            if(l1.val<=l2.val){
                temp.next=new ListNode(l1.val);
                l1=l1.next;
            }else{
                temp.next=new ListNode(l2.val);
                l2=l2.next;
            }
            temp=temp.next;
        }
        
        if(l1!=null){
            temp.next=l1;
        } 
        else{
            temp.next=l2;
        }
        return newHead.next;
    }
}
