import java.util.*;

public class lcs3 {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String s1 = scan.next();
            String s2 = scan.next();
            String s3 = scan.next();

            int dp[][][] = new int[s1.length()+1][s2.length()+1][s3.length()+1];
            for(int i=1;i<=s1.length();i++){
                for(int j=1;j<=s2.length();j++){
                    for(int k=1;k<=s3.length();k++){
                        dp[i][j][k] = -1;
                    }
                }
            }
            System.out.println(solve(s1,s2,s3,s1.length(),s2.length(),s3.length(),dp));

    }

    static int solve(String s1,String s2,String s3,int i,int j,int k,int dp[][][]){
            if(i== 0 || j==0 || k==0)
                return 0;
            if(dp[i][j][k] != -1)
                return dp[i][j][k];
            if(s1.charAt(i-1) == s2.charAt(j-1) && s2.charAt(j-1) == s3.charAt(k-1))
                return dp[i][j][k] = 1+ solve(s1,s2,s3,i-1,j-1,k-1,dp);
            return dp[i][j][k] = Math.max(solve(s1,s2,s3,i-1,j,k,dp),Math.max(solve(s1,s2,s3,i,j-1,k,dp),solve(s1,s2,s3,i,j,k-1,dp)));
    }
}