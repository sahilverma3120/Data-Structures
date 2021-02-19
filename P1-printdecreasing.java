import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        // write your code here
        int n=scn.nextInt();
        printdecreasing(n);
    }

    public static void printdecreasing(int n){
        if(n==0)
        {
            return;
        }
        System.out.println(n);
        printdecreasing(n-1);
    }

}
