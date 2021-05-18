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
