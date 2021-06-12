
}/*1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the number of combinations of the n coins using which the 
     amount "amt" can be paid.

Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be 
                  used for many installments in payment of "amt"
Note2 -> You are required to find the count of combinations and not permutations i.e.
                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same 
                  combination. You should treat them as 1 and not 3.
*/
// link - https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/coin-change-combination-official/ojquestion
//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/coin-change-combination-official/ojquestion
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[] coins=new int[n];
        for(int i=0; i<coins.length;i++){
            coins[i]=scn.nextInt();
        }

 int tar=scn.nextInt();
 int[] dp = new int[tar+1];
  dp[0]=1;

 for(int amt=0; amt<=tar; amt++){
 for(int coin:coins){
     if(coin<=amt){
     int rant = amt-coin;
     dp[amt]= dp[amt]+dp[rant];
     
 }
}

    }
    System.out.println(dp[tar]);
}
}
