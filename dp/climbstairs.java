/*1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. You are required to print the number of different paths via which you can climb to the top.*/
// link https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
      int n =scn.nextInt();
      int res1 = countpathstab(n);
      System.out.println(res1);
    }
      public static int countpaths(int n, int[] qb){
          
        if(n==0){
            System.out.println("");
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(qb[n] >0){
        return qb[n];
      }
            int num1= countpaths(n-1,qb);
            int num2= countpaths(n-2,qb);
            int num3= countpaths(n-3,qb);
            int res=num1+num2+num3;
            qb[n]=res;
            return res;
        
    }


public static int countpathstab(int n){
int[] dp = new int[n+1];
dp[0]=1;

for(int i =1;i<=n; i++){
 if(i==1){
     dp[i]=dp[i-1];
 }
 else if(i==2){
     dp[i]=dp[i-1]+dp[i-2];
     }
 else{
     dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
 }
