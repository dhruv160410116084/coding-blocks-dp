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

            long tot = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                tot += arr[i];
            }

            long ans = solve(arr, dp);
            ans = tot - ans;
            System.out.println(ans);

        } catch (Exception e) {

        }

    }

    static long solve(long arr[], long dp[]) {

        dp[0] = arr[0];
        dp[1] = arr[1];
        dp[2] = arr[2];
        int len = arr.length;
        for (int i = 3; i < arr.length; i++) {
            dp[i] = min(dp[i - 1], min(dp[i - 2], dp[i - 3])) + arr[i];
        }
        // if(dp[i] >-1)
        // return dp[i];

        return min(dp[len - 1], min(dp[len - 2], dp[len - 3]));

    }
}
