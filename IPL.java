import java.io.*;
import java.util.*;
import static java.lang.Math.*;

 class IPL {
    public static void main(String[] args) {
        try {  
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long arr[] = new long[N];
            long dp[] = new long[N];
            Arrays.fill(dp,-1);
            long _min =Integer.MAX_VALUE;
            long tot = 0;
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                tot+=arr[i];
                _min = min(_min,arr[i]);
            }
            if(N<4)
                System.out.println(tot-_min);
            else{
                solve(arr,dp,N-1);
                long ans = min(dp[N-1],min(dp[N-2],dp[N-3]));
                ans = tot-ans;
                System.out.println(ans);    
            }
                    } catch (Exception e) {
            //TODO: handle exception
        }


    }

    static long solve(long arr[],long dp[],int i){
            if(i<3)
                return dp[i]=arr[i];
         
            if(dp[i] >-1)
                    return dp[i];
      
            return   dp[i] = min(solve(arr, dp, i-1),min(solve(arr, dp, i-2),solve(arr, dp, i-3))) + arr[i];
                
    }
}