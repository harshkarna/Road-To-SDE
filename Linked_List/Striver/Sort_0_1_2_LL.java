package com.Linked_List.Striver;

import com.Linked_List.Node;

public class Sort_0_1_2_LL {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //Approach 1: TAKE the counts of 0,1,2 and then do data replacement of LL
    //Just one problem like we need to traverse LL twice here

    private static Node sortList(Node  head){
        Node temp=head;
        int zeroCount=0;
        int oneCount=0;
        int twoCount=0;

        while (temp != null ){
            if(temp.data==0){
                zeroCount++;
            }
            else if(temp.data==1){
                oneCount++;
            }
            else if(temp.data==2){
                twoCount++;
            }
            temp=temp.next;
        }

        // Now do data replacement
        temp=head;
        while(temp!=null){
            if(zeroCount!=0){
                temp.data=0;
                zeroCount--;
            }
            else if(oneCount!=0){
                temp.data=1;
                oneCount--;
            }
            else if(twoCount==2){
                temp.data=2;
                twoCount--;
            }
            temp=temp.next;
        }
        return head;
    }



    //Approach 2 : make the links for 0 , 1 and 2 and then connect all these 3 linked list, we cam use
    //dummy node to start
    private static Node sortList_v1(Node  head){
        if (head==null || head.next== null) return head;
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero=zeroHead;
        Node one=oneHead;
        Node two=twoHead;

        Node temp = head;
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=zero.next;
            }
            else if(temp.data==1){
                one.next=temp;
                one=one.next;
            }
            else{
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }

        //handle zero
        if(oneHead.next!=null){
            zero.next=oneHead.next;
        }
        else{
            zero.next=twoHead.next;
        }

        //handle one
        one.next=twoHead.next;

        Node newHead=zeroHead.next;
        return newHead;


    }



}
