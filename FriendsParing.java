import java.util.Scanner;
//completed
class FriendsParing {
    public static void main(String[] args) {
     
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = 0,t=0;
        long ans = 0;
        if(scan.hasNextInt())
            t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            if(scan.hasNextInt()){
                n = scan.nextInt();
                long dp[] = new long[n + 1];
                ans = count(n,dp);
                sb.append(ans+"\n");

            }
        }
        scan.close();
        System.out.print(sb);
    }

    static long count(int n, long dp[]) {
        
      
      

        for (int i = 0; i <= n; i++) {
                if(i<3)
                    dp[i] = i;
                else
                    dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }

        return dp[n];

    }
}
