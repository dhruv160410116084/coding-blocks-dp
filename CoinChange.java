import java.util.Scanner;

class CoinChange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=0,m=0;
        StringBuilder sb = new StringBuilder();
        if(scan.hasNextInt())
            n = scan.nextInt();
        if(scan.hasNextInt())
            m = scan.nextInt()+1;
        if(scan.hasNextInt()){
            int coins[] = new int[m];
            coins[0] = 0;
            for(int i=1;i<m;i++){
                coins[i] = scan.nextInt();
            }
            long ans = count(n,m,coins);
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static long  count(int n,int m,int coins[]){
        long dp[][] = new long[m][n+1];
        for(int i=0;i<m;i++)
            dp[i][0] = 1;

        for(int i=1;i<m;i++){
            for(int j=1;j<=n;j++){
                // System.out.println("i: "+i+" j: "+j);
                if(j < coins[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
            }
        }    

        return dp[m-1][n];

    }
    

    
}