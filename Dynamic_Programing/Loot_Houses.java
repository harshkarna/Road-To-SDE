/*
Loot Houses

        A thief wants to loot houses. He knows the amount of money in each house.
         He cannot loot two consecutive houses. Find the maximum amount of money he can loot.
        Input format :
        The first line of input contains an integer value of 'n'. It is the total number of houses.

        The second line of input contains 'n' integer values separated by a single space denoting the amount of money each house has.
        Output format :
        Print the the maximum money that can be looted.
        Constraints :
        0 <= n <= 10 ^ 4

        Time Limit: 1 sec
        Sample Input 1 :
        6
        5 5 10 100 10 5
        Sample Output 1 :
        110
        Sample Input 2 :
        6
        10 2 30 20 3 50
        Sample Output 2 :
        90
        Explanation of Sample Output 2 :
        Looting first, third, and the last houses([10 + 30 + 50]) will result in the maximum loot,
         and all the other possible combinations would result in less than 90.

       Link -   https://www.youtube.com/watch?v=pchOMyPbp0I&t=2s
*/

package com.Dynamic_Programing;

public class Loot_Houses {


/*
    Recursive approach
    private static int robFrom(int[] wealth, int currentIndex) {
        if(currentIndex >=wealth.length){
            return 0;
        }
        int stealCurrent=wealth[currentIndex] +robFrom(wealth,currentIndex+2);
        int skipCurrent=robFrom(wealth,currentIndex+1);

        return Math.max(stealCurrent,skipCurrent);

    }

    private static int getMaxLootCount(int[] arr) {
        return robFrom(arr,0);

    }
*/


//    Recursive DP + memoization

    private static int robFrom(int[] wealth, int currentIndex,int[] dp) {
        if(currentIndex >=wealth.length){
            return 0;
        }
        if(dp[currentIndex]!=-1){
            return dp[currentIndex];
        }
        int stealCurrent=wealth[currentIndex] +robFrom(wealth,currentIndex+2,dp);
        int skipCurrent=robFrom(wealth,currentIndex+1,dp);

        dp[currentIndex] =Math.max(stealCurrent,skipCurrent);
        return  dp[currentIndex];
    }


    private static int getMaxLootCount(int n,int[] arr) {
        int[] dp=new int[n+1];
        for(int i= 0 ;i <dp.length;i++){
            dp[i]=-1;
        }
        return robFrom(arr,0,dp);

    }


    //Iterative DP
    public static int getMaxLootCountI(int[] arr) {
        int n = arr.length;
        //Special case
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int currHouse = 2; currHouse < n; currHouse++) {
            dp[currHouse] = Math.max(dp[currHouse - 1], (arr[currHouse] + dp[currHouse - 2]));
        }
        return dp[n-1];

    }

    public static void main(String[] args) {
        int n=6;
        int[] arr={10,2,30,20,3,50};

        System.out.println(getMaxLootCount(n,arr));
        System.out.println(getMaxLootCountI(arr));


        }

}
