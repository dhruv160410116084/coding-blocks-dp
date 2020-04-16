import java.util.*;
import java.io.*;
import static java.lang.Math.*;

class Cellmitosis {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            long dp[]=new long[N+1];
            System.out.println(solve(N,x,y,z,dp));
            
        } catch (Exception e) {
            //TODO: handle exception
            // System.out.println(e);
        }
  }

  static long solve(int i,int x,int y,int z,long dp[]){
  if(i<0)
    return 0;
      if(i==1)
        return dp[1]=0;
      if(dp[i]>1 && dp[i]!=0)
        return dp[i];
       if((i&1)==0)
        return dp[i] = min(solve(i/2,x,y,z,dp)+x,solve(i-1,x,y,z,dp)+y);

      return dp[i] = min(solve((i+1)/2,x,y,z,dp)+x+z,solve(i-1,x,y,z,dp)+y);
  }
}