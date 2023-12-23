package com.Linked_List.Striver;

public class Remove_the_nth_node_from_end_of_ll {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*Solution 1: Naive Approach [Traverse 2 times]
    Intuition: We can traverse through the Linked List while maintaining a count of nodes,
    let’s say in the variable count, and then traversing for the 2nd time for (n – count)
    nodes to get to the nth node of the list.

    problem is time complexity - we are traversing 2 times one for count then len-N
*/
    private static Node removeNthFromEnd(Node head, int n) {
        int count=0;
        Node temp=head;

        while(temp !=null){
            count++;
            temp = temp.next;
        }

        //check if count == N , it means its head
        if(count ==n) {
            Node newHead=head.next;
            return newHead;
        }

        //noW calculate resultant (one node prev to to node which is to be deleted) = cnt - n
        int res =count-n;
        temp=head;

        while(temp !=null){
            res--;
            if(res==0){
                break;
            }
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;

    }

/*
    Solution 2: [Efficient] Two pointer Approach

    Unlike the above approach, we don’t have to maintain the count value, we can find the nth node just by one traversal by using two pointer approach.

    Intuition :
    What if we had to modify the same above approach to work in just one traversal? Let’s see what all information we have here:

    We have the flexibility of using two-pointers now.
    We know, that the n-th node from the end is the same as (total nodes – n)th node from start.
    But, we are not allowed to calculate total nodes, as we can do only one traversal.
    What if, one out of the two-pointers is at the nth node from start instead of the end? Will it make anything easier for us?

    Yes, with two pointers in hand out of which one is at the n-th node from start, we can just advance both of them
    till the end simultaneously, once the faster reaches the end, the slower will stand at the n-th node from the end.

*/

    private static Node removeNthFromEnd_v1(Node head, int n) {

        Node fast = head;
        Node slow = head;

        for(int i = 1; i <= n; i++)
            fast = fast.next;

        if(fast==null ) return head.next;

        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;

    }


    public static void main(String[] args) {


    }
}
