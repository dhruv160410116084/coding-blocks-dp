import java.util.Scanner;
//completed
class Tilling{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=0,m=0,t=0;
        if(scan.hasNextInt())
            t = scan.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t;i++){
            if(scan.hasNextInt())
                n = scan.nextInt();
             if(scan.hasNextInt())
                m = scan.nextInt();
          
                long dp[] = new long[n+1];
                dp[0] = 1;
               
                long ans = countNumWays(n, m,dp);
                sb.append(ans+"\n");
            
        }
        scan.close();
        System.out.print(sb);
    }

    static long countNumWays(int n,int m,long dp[]){
        //  System.out.println("n: "+n+" m: "+m);
        //  if(n <=0 || m<=0)
        //     return 0;
        // if(n<m){
        //     return 1;
        // }
        // if(n==m)
        //     return 2;
        // if(dp[n] != 0){
        //     // System.out.println("DP IS USED");
        //     return dp[n];

        // }
        // int ctr=0;
        // return dp[n]=countNumWays(n-1,m,dp)+countNumWays(n-m, m,dp);
        // try  {
        
            for(int i=1;i<=n;i++){
               dp[i] = dp[i-1];
               dp[i] += ((i-m)>=0)?dp[i-m]:0;
               dp[i]%=1000000007;
             }
           
        // } catch (Exception e) {
            //TODO: handle exception
            // System.out.println(" ctr = "+ctr);
        // }
        return (dp[n]);
    }

    


}