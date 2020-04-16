import java.io.*;
import  java.util.*;
import static java.lang.Math.*;


public class SUPW {
    public static void main(String[] args)  {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            int dp[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int _min=0;
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                if(i==0)
                    _min = arr[i];
                else
                    _min = min(_min,arr[i]);
                
            }
			if(N<=3)
                System.out.println(_min);
			else{
               _min= solve(dp,arr);
                
                System.out.println(_min);
            }			
        
        } catch (Exception e) {
            //TODO: handle exception
        }
        

    }

    static int solve(int dp[],int arr[]){
        dp[0]=arr[0];
        dp[1] = arr[1];
        dp[2] = arr[2];
        int len = arr.length;
        for(int i=3;i<arr.length;i++){
            dp[i] = min(dp[i-1],min(dp[i-2],dp[i-3]))+arr[i];
        }

  
        return   min(dp[len-1],min(dp[len-2],dp[len-3]));
    }

}