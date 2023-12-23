package com.Linked_List.Striver;

public class ReverseLL {

     public class ListNode { int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode reverseLL(ListNode head){
        if(head == null || head.next ==null){
            return head;
        }
        ListNode current = head;
        ListNode prev=null;
        while(current != null){
            ListNode forward=current.next;
            current.next=prev;
            prev=current;
            current=forward;
        }
        return prev;
    }


}
