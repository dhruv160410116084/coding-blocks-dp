import java.util.Scanner;
//completed
class CountBinaryStr{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t=0,n=0;
        StringBuilder sb = new StringBuilder();
        if(scan.hasNextInt())
            t = scan.nextInt();
        for(int i=0;i<t;i++){
            if(scan.hasNextInt()){
                n = scan.nextInt();
                long dp[] = new long[n+1];
                long ans = count(n,dp);
                sb.append(ans+"\n");
            }
        }
        scan.close();
        System.out.print(sb);
    }

    static long count(int n,long dp[]){
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}