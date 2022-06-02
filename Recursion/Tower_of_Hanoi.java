//Tower of Hanoi
//
//        Tower of Hanoi is a mathematical puzzle where we have three rods and n disks.
//        The objective of the puzzle is to move all disks from source rod to destination rod using third rod (say auxiliary). The rules are :
//        1) Only one disk can be moved at a time.
//        2) A disk can be moved only if it is on the top of a rod.
//        3) No disk can be placed on the top of a smaller disk.
//        Print the steps required to move n disks from source rod to destination rod.
//        Source Rod is named as 'a', auxiliary rod as 'b' and destination rod as 'c'.
//        Input Format :
//        Integer n
//        Output Format :
//        Steps in different lines (in one line print source and destination rod name separated by space)
//        Constraints :
//        0 <= n <= 20
//        Sample Input 1 :
//        2
//        Sample Output 1 :
//        a b
//        a c
//        b c
//        Sample Input 2 :
//        3
//        Sample Output 2 :
//        a c
//        a b
//        c b
//        a c
//        b a
//        b c
//        a c
//

package com.Recursion;

public class Tower_of_Hanoi {

    public static void tower_of_hanoi(int n,char source,char auxiliary,char destination){

//        if(n==1){  //base case as 1
//            System.out.println(source + " to " + destination);
//        }
//        else {
//            tower_of_hanoi(n - 1, source, destination, auxiliary);
//            System.out.println(source + " to " + destination);
//            tower_of_hanoi(n - 1, auxiliary, source, destination);
//        }

        if(n==0){ //base case as 0
            return;
        }
            tower_of_hanoi(n - 1, source, destination, auxiliary);
            System.out.println("Disk " + n + " move from "+ source + " to " + destination);
            tower_of_hanoi(n - 1, auxiliary, source, destination);

    }


    public static void main(String[] args) {

        int n =2;
        char source='a';
        char auxiliary='b';
        char destination='c';
        tower_of_hanoi(n,source,auxiliary,destination);



    }
}
