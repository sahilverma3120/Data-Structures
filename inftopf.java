import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack <String> postfix = new Stack<>();
    Stack <Character> ops = new Stack<>();
    
    for(int i=0; i<exp.length(); i++)
    {
       char ch = exp.charAt(i);
      if(ch=='('){
         ops.push(ch);
      }
      else if((ch >='0' && ch<='9') || 
      (ch>='a'  && ch<='z')||
      (ch>='A' && ch<='Z')){
          postfix.push(ch+ "");
    }
    else if(ch==')'){
        while(ops.peek() !='('){
            process(ops , postfix); 
        }//till the openeing bracket
        ops.pop();
    }
    else if(ch == '+' || ch=='-'  || ch=='*' || ch=='/'){
        while(ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())) {
        process(ops , postfix);    
        }
    
     ops.push(ch);    //pushing current operator
          }
    }
    while(ops.size() > 0)
    {
        process(ops,postfix);
    }
    System.out.println(postfix.pop());
    
}
public static void process(Stack <Character> ops,Stack <String> postfix)
    {        char op = ops.pop();
            String postv2 = postfix.pop();
            String postv1 =postfix.pop();
            String postv = postv1 + postv2 + op;
            postfix.push(postv);
            }
    
    public static int precedence(char op){
        if(op =='+'  || op =='-'){
            return 1;
        }
        else if(op=='*' || op=='/'){
            return 2;
        }
        else{
            return 0;
        }
    }
}
    // code
