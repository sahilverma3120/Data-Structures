import java.io.*;
import java.util.*;

public class Main{
     public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int fibn = Fibnocaised(n, new int[n+1]);
    System.out.println(fibn);
    
}
public static int Fibnocaised(int n, int[] qb){
    // write your code here
    if(n==0 || n==1)
    {
        return n;
    }
    if(qb[n]!=0)
    {
        return qb[n];
    }
     int fb1 = Fibnocaised(n-1,qb);
     int fb2= Fibnocaised(n-2,qb);
    int fibn=fb1+fb2;
     qb[n]=fibn;
    return fibn;
    
 }

}
