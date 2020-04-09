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
                solve(N-1,dp,arr);
                 _min = min(dp[N-1],min(dp[N-2],dp[N-3]));
                System.out.println(_min);
            }			
        
        } catch (Exception e) {
            //TODO: handle exception
        }
        

    }

    static int solve(int i,int dp[],int arr[]){
        if(i==0||i==1|| i==2)
            return dp[i]=arr[i];
        if(dp[i]!= 0)
            return dp[i];
        return dp[i] = min(solve(i-1,dp,arr),min(solve(i-2,dp,arr),solve(i-3,dp,arr)))+arr[i];
    }

}