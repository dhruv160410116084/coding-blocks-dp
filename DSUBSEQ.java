import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.lang.Math.*;
import static java.lang.String.*;
import static java.util.Arrays.*;

public class DSUBSEQ {
    static int mod = 1000000007;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = parseInt(br.readLine()); 
            while(T-- != 0){
               String str = br.readLine();
               char arr[] =str.toCharArray();
               int dp[] = new int[arr.length+1];
               bw.write(solve(arr,dp)+"\n");
            }
            bw.flush();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }

    static int solve(char arr[] ,int dp[]){
        dp[0]=1;
        int len = arr.length;
        int lastIdx[] = new int[26];
        fill(lastIdx,-1);
       ;
        for(int i=1;i<=len;i++){
            dp[i] = (2*dp[i-1])%mod;
            if(lastIdx[ (arr[i-1] - 'A')%26 ] !=-1 )
                dp[i] = ( ( dp[i] %mod ) - (dp[ lastIdx[(arr[i-1] - 'A')%26]] % mod) +mod ) % mod;
            lastIdx[(arr[i-1]-'A')%26] = (i-1);

        }
        return dp[len];
    }
}