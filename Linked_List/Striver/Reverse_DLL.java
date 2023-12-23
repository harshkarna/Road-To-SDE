package com.Linked_List.Striver;

public class Reverse_DLL {
    static class Node {
        int data;
        Node next;
        Node back;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }
        Node(int data, Node next , Node back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }

    }
    /*2 approaches
    1.Using stacks :
    2.Using swap the front and back ( single traversal )
    * */

    public static Node reverseDLL(Node  head) {
        if(head == null || head.next== null)
        {
            return head;
        }
        Node last =null;
        Node current =head;
        while(current !=null){
            //swap the prev and front
            last=current.back;
            current.back = current.next;
            current.next = last;
            //Move the current forward , do back because now links are reversed
            current=current.back;
        }
        //as current will be on null and last will be on second last index because it didn't enter the while loop
        return last.back;

    }

    public static void main(String[] args) {


    }
}
