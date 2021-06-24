/*Sum Of Two Arrays
Easy  Prev   Next
1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. The two arrays represent digits of two numbers.
6. You are required to add the numbers represented by two arrays and print the
arrays.
*/
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n1 = Integer.parseInt(br.readLine());
    int[] a1 = new int[n1];
    for(int i = 0; i < n1; i++){
       a1[i] = Integer.parseInt(br.readLine());
    }

    int n2 = Integer.parseInt(br.readLine());
    int[] a2 = new int[n2];
    for(int i = 0; i < n2; i++){
       a2[i] = Integer.parseInt(br.readLine());
    }

    int[] sum = new int[n1 > n2? n1: n2];
    int i = n1 - 1;
    int j = n2 - 1;
    int k = sum.length - 1;
    int c = 0;
    while(i >= 0 || j >= 0){
       int d = c;

       if(i >= 0)
         d += a1[i];

      if(j >= 0)
         d += a2[j];

       c = d / 10;
       d = d % 10;
       sum[k] = d;

       i--;
       j--;
       k--;
    }

    if(c > 0){
       System.out.println(c);
    }
    for(int val: sum){
       System.out.println(val);
    }
 }

}
