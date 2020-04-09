import java.util.*;
import java.io.*;
public class Catlan {
    static long dp[][] = new long[201][201];
    public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        System.out.println(nCr(2*n, n)/(n+1));

    }

    static long nCr(int n,int r){
        if(n==r || r==0)
            return 1;
        else{
            if(dp[n][r] != 0)
                return dp[n][r];
            
            return dp[n][r]=nCr(n-1, r-1) + nCr(n-1, r);

        }
    }
}