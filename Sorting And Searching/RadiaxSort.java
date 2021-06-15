//link - https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/radix-sort-official/ojquestion
/*1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using radix sort.
Input Format
An Integer n 
arr1
arr2..
n integers
*/
import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
    // write code here    
  
  int max = Integer.MIN_VALUE;
  for(int val:arr){
      if(val>max){
          max=val;
      }
  }
  int exp=1;
  while(exp<=max){
      countSort(arr,exp);
      exp=exp*10;
  }
  }

  public static void countSort(int[] arr, int exp) {
    // write code hereint[] farr= new int[range];
    int[] farr= new int[10];
   for(int i=0; i<arr.length; i++){
       farr[arr[i]/exp%10]++;
   }
   for(int i=1; i<farr.length; i++){
       farr[i]=farr[i]+farr[i-1];
     
   }
   
   int[] ans= new int[arr.length];
   for(int i=arr.length-1; i>=0; i--)
   {
       int pos=farr[arr[i]/exp%10]-1;
       ans[pos]=arr[i];
           farr[arr[i]/exp%10]--;
   }
   for(int i=0;i<ans.length;i++){
       arr[i]=ans[i];
   }
    
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}
