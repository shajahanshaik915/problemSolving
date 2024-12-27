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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] a=new ListNode[k];
        int length=findLen(head);
        int size=length/k,mod=length%k;
        for(int i=0;i<k;i++){
            if(head==null){
                a[i]=null;
            }
            else{
                ListNode start=new ListNode(),cur=start;
                start.next=head;
                int n=size;
                if(mod>0){
                    n++;
                    mod--;
                }
                while(n-->0){
                    head=head.next;
                    cur=cur.next;
                }
                cur.next=null;
                a[i]=start.next;
            }
        }
        return a;
    }
    public int findLen(ListNode head){
        int count=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            count++;
        }
        return count;
    }
}
