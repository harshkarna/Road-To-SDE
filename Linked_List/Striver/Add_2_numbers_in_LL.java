package com.Linked_List.Striver;

import com.Linked_List.Node;

public class Add_2_numbers_in_LL {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //use the concept of dummy node

    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node current = dummy;
            int carry=0;
            while(l1 != null || l2 != null || carry == 1){
                int sum=0;
                if(l1!=null) {
                    sum+=l1.data;
                    l1=l1.next;
                }
                if(l2!=null) {
                    sum+=l2.data;
                    l2=l2.next;
                }
                sum+=carry;
                carry=sum/10;
                Node newNode=new Node(sum % 10);

                //on first iteration dummy next will be newNode and then rest iteration will also occur
                current.next=newNode;
                //move the current forward
                current=current.next;

            }
            return dummy.next;
    }

    public static void main(String[] args) {


    }
}
