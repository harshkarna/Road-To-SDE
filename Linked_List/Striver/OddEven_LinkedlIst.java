package com.Linked_List.Striver;

import java.util.ArrayList;

public class OddEven_LinkedlIst {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    //Approach 1 : Brute : Store the odd numbers first then even in array then copy back in LL (bUT IT USES EXTRA space)
    private static Node oddEvenList(Node head) {
        if (head==null || head.next== null) return head;

        ArrayList<Integer> arr = new ArrayList<>();
        Node temp=head;

        //let's do for odd first
        while(temp!=null && temp.next!=null) {
            arr.add(temp.data);
            temp=temp.next.next;//2 place
        }
        //if LL is odd length then we might skip last element so check
        if(temp!=null) arr.add(temp.data);

        //let's do for even now
        temp=head.next;

        while(temp!=null && temp.next!=null) {
            arr.add(temp.data);
            temp=temp.next.next;//2 place
        }
        //if LL is odd length then we might skip last element so check
        if(temp!=null) arr.add(temp.data);

        //Now it's time to replace data in LL from arraylist
        int i=0;
        temp=head;
        while(temp!=null){
            temp.data=arr.get(i);
            i++;
            temp=temp.next;
        }

        return head;

    }

    private static Node oddEvenList_v1(Node head) {
        if (head==null || head.next== null) return head;
        Node odd=head;
        Node even=head.next;
        Node evenHead=head.next;

        while(even!=null || even.next!=null ){
            //make odd even next to their next of next node
            odd.next=odd.next.next;
            even.next=even.next.next;

            //now make them stand on the current next node which is twice ahead
            odd=odd.next;
            even=even.next;
        }
        //now as make odd (tail ) to connect to even head
        odd.next=evenHead;
        return head;

    }


    public static void main(String[] args) {

    }
}
