import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.util.Arrays.*;


public class JobBounties {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            
                String str = br.readLine();
                int len = str.length();
                char arr[] = new char[len+1];
                int a[] = new int[len+1];
                int maxSize = 0;
                
                // int b[] = new int[len+1];
                for(int i=1;i<=len;i++){
                    arr[i] = str.charAt(i-1);
                }
                fill(a,0);
                Stack<Integer> stack = new Stack<Integer>();
                for(int i=1;i<=len;i++){
                    if(arr[i]=='(')
                        stack.push(i);
                    else if(arr[i] == ')' && !stack.empty()){
                        int start = stack.pop();
                        a[i] = start;
                        a[start] =  i-start+1;
                        if(arr[start-1] == ')'  && a[start-1] !=0){
                            int prevStart = a[start-1];
                            a[start] = i-prevStart+1;
                            a[i]=prevStart;
                        }
                        maxSize = max(maxSize,a[start]);
                    }
                    
                }
                
                System.out.println(solve(str.toCharArray()));
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }

    static int solve(char arr[]){
        Stack<Integer> stack = new Stack<Integer>();
        //  stack.push(-1);
        int maxLen = 0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] == '(')
                stack.push(i);
            else{
                if(!stack.empty()){
                    stack.pop();
                    
                }
                if(!stack.empty())
                    maxLen = max(maxLen,i-stack.peek());
                else
                    stack.push(i);
            }
        }
        return maxLen;
    }
}