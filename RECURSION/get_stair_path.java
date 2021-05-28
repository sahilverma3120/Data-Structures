/*1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
Use sample input and output to take idea about output.
pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-stair-paths-official/ojquestion
Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);

    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n==0){
        ArrayList<String> bres = new ArrayList<>();
        bres.add("");
        return bres;}
        else if(n<0){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }
        ArrayList<String> paths1=getStairPaths(n-1);
        ArrayList<String> paths2=getStairPaths(n-2);
        ArrayList<String> paths3=getStairPaths(n-3);
        
        ArrayList<String> paths = new ArrayList<>();
        
        for(String path:paths1)
        {
            paths.add(1+path);
        }
        for(String path:paths2)
        {
            paths.add(2+path);
        }
         for(String path:paths3)
        {
            paths.add(3+path);
        }
        return paths;
    }

}
