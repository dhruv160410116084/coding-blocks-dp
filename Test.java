import java.util.*;
import java.io.*;
import static java.lang.Math.*;

class Test {
public static void main(String args[] ) throws Exception {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    while(T--!=0){
       int N = Integer.parseInt(br.readLine());
       String str = br.readLine();
       int len = str.length();
       Stack<Character> stack = new Stack<Character>();
       for(int i=0;i<N;i++){
          char c=str.charAt(i);
          if(c>='A' && c<='Z'){
              bw.write(c);
          }
         else  if(stack.empty() || getPrec(c) > getPrec(stack.peek()) || c=='(' ){
              stack.push(c);
          }
          else if(c == ')'){
            while(!stack.empty() &&  stack.peek() != '(')
              bw.write(stack.pop());
            if(!stack.empty() && stack.peek() == '(')
                  stack.pop();
        }
          else{
              while(   !stack.empty() &&  (     stack.peek() !='(' &&  getPrec(stack.peek()) >= getPrec(c) ) ){
                  bw.write(stack.pop());
              }
              stack.push(c);
          }
          //a+b*(c^d-e)^(f+g*h)-i

       }
       while(!stack.empty()){
           bw.write(stack.pop());
       }

       bw.newLine();

    }
    bw.flush();
    }

    static int getPrec(char c){
        int ans=0;
        switch(c){
            case '^':
                    ans=3;
                    break;
            case '*':

            case '/':
                    ans=2;
                    break;
            case '+':
            case '-':
                    ans =1;
                    break;
        }
        return ans;
    }
}
