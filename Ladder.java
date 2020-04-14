import java.io.*;
import java.util.StringTokenizer;

public class Ladder {
    static int mod = 1000000007;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int arr[]=new int[N+1];
            int dp[]=new int[N+1];
            dp[1]=1;
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if(arr[N]==1)
                System.out.println(0);
            else
            System.out.println(solve(N,K,arr,dp));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }

    static int solve(int n,int m,int arr[],int dp[]){
        if(n<1)
            return 0;
        if(n==1 )
            return 1;
        if(arr[n] == 1)
            return 0;
        if(dp[n]!=0)
            return dp[n];
       
                int ans=0;
                for(int i=1;i<=m;i++){
                    dp[n] =  (dp[n]+solve(n-i,m,arr,dp)) % mod;
                }
            return dp[n];
    }
}