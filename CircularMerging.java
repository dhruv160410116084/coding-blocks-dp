import java.util.*;

public class CircularMerging {
    static  int sum[];
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            String s = "";
            while(t-- != 0){
                int n = scan.nextInt();
                int arr[] = new int[n];
                int dp[][] = new int[n][n];
               sum = new int[n];
                // int dp[][] = new int[n][n];
    
                for(int i=0;i<n;i++){
                    arr[i] = scan.nextInt();
                }
                sum[0] = arr[0];
                for(int i=1;i<n;i++){
                    sum[i] = arr[i]+sum[i-1];
                }
                for(int i=0;i<n;i++)
                    for(int j=0;j<n;j++)
                        dp[i][j] = -1;
                int ans = Integer.MAX_VALUE;
    
                for(int i=0;i<n;i++){
                ans = Math.min(ans,solve(arr,dp,i,mod(i+n-1,n)));    
                }
                s = s+ans+"\n";
            }
            System.out.println(s);
           
        }
        
      static int cirSum(int arr[],int l,int r){
          if(l<=r){
              if(l == r)
                return arr[l];
              if(l == 0 )
                return sum[r];
             return sum[r]-sum[l-1];
          }else{
              int a = sum[sum.length-1]-sum[l-1];
              int b = sum[r];
              return a+b;
          }
      }
    static int solve(int arr[],int dp[][],int l,int r){
            if(dp[l][r] != -1)
                return dp[l][r];
            if(l == r)
                return dp[l][r]=0;
            if(mod(l+1,arr.length) == r)
                return dp[l][r] = arr[l]+ arr[r];
            int res = Integer.MAX_VALUE;
            for(int i=l;i!=r;i=mod(i+1,arr.length)){
                res = Math.min(res,solve(arr,dp,l,i)+solve(arr,dp,mod(i+1,arr.length),r )+cirSum(arr, l,r));
            }
            return dp[l][r]=res;
            
    }  

    static int mod(int x,int n){
        if(x<n)
            return x;
        // if(x>=n)
        return x-n;
    }
}