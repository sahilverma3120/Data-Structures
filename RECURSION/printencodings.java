//https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-encodings-official/ojquestion
/*1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
Use the input-output below to get more understanding on what is required
123 -> abc, aw, lc
993 -> iic
013 -> Invalid input. A string starting with 0 will not be passed.
103 -> jc
303 -> No output possible. But such a string maybe passed. In this case print nothing.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        String str= scn.next();
        printEncodings(str,"");

    }

    public static void printEncodings(String ques, String asf) {
        
        if(ques.length()==0){
                System.out.println(asf);
                return;
        }
                
         else if(ques.length()==1)
         {
             char ch = ques.charAt(0);
             if(ch=='0'){
                 return;
             }
             else{
                 int chv= ch-'0';
                 char code = (char)('a'+chv-1);
                    System.out.println(asf+code);
             } }
             
            else{
                char ch = ques.charAt(0);
                String roq=ques.substring(1);
                if(ch=='0'){
                 return;
             }
             else{
                 int chv= ch-'0';
                 char code = (char)('a'+chv-1);
                printEncodings(roq,asf+code);
    
             }
             String ch12= ques.substring(0,2);
             String roq1=ques.substring(2);
             int ch12v = Integer.parseInt(ch12);
             if(ch12v <= 26){
                 char code= (char)('a'+ch12v-1);
                 printEncodings(roq1,asf+code);
             }
                
            } 
             
             
         }
        }
