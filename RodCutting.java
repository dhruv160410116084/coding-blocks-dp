import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
// import static java.lang.Math.*;
import static java.lang.String.*;

public class RodCutting {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // int T = parseInt(br.readLine()); 
            // while(T-- != 0){
                int N = parseInt(br.readLine());
                long arr[] = takeInputArrayLong(br.readLine(), N+1);
                long dp[] = new long[N+1];
                System.out.println(solve(arr,N,dp));
                
            // }
            bw.flush();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }


    static long solve(long arr[],int n,long dp[]){
        // if(n==0)
        //     return 0;
        
        // if(dp[n]>0)
        //     return dp[n];
        // long q=arr[n];
        // for(int i=1;i<n;i++){
        //     q = max(q,arr[i]+solve(arr,n-i,dp));
        // }
        // return dp[n]=q;

        for(int i=1;i<=n;i++){
            long q = arr[i];
            for(int j=1;j<i;j++){
                q = max(q,arr[j]+dp[i-j]);
            }
            dp[i] = q;
        }
        return dp[n];
    }
        
    

    static long[] takeInputArrayLong(String str, int len) {
        StringTokenizer st = new StringTokenizer(str);
        long arr[] = new long[len+1];
        for (int i = 1; i < len; i++) {
            arr[i] = parseLong(st.nextToken());
        }
        return arr;
    }
}