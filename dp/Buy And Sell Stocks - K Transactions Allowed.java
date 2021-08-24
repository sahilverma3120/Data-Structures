//1. You are given a number n, representing the number of days.
//2. You are given n numbers, where ith number represents price of stock on ith day.
//3. You are given a number k, representing the number of transactions allowed.
//4. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
//Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).

import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());

      int[][] dp = new int[k + 1][n];

      for(int i = 1; i <= k; i++){
         int fadd = Integer.MIN_VALUE;

         for(int j = 1; j < n; j++){
            if(dp[i - 1][j - 1] - arr[j - 1] > fadd){
               fadd = dp[i - 1][j - 1] - arr[j - 1];
            }

            if(fadd + arr[j] > dp[i][j - 1]){
               dp[i][j] = fadd + arr[j];
            } else {
               dp[i][j] = dp[i][j - 1];
            }
         }
      }

      System.out.println(dp[k][n - 1]);
   }

}
