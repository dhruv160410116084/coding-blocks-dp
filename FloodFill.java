import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;
import static java.lang.String.*;
import static java.util.Arrays.*;

public class FloodFill {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            ArrayList<Integer> list = new ArrayList<Integer>();
            int N = parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(parseInt(st.nextToken()));
            for (int i = 1; i < N; i++) {
                int t = parseInt(st.nextToken());
                if (t != list.get(list.size() - 1)) {
                    list.add(t);
                }
            }
            Integer arr[] = new Integer[0];
            arr = list.toArray(arr);
            // System.out.println(arr.length);
            int dp[][] = new int[arr.length][arr.length];

            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++)
                    dp[i][j] = -1;
            }
            bw.write(solve(0,arr.length-1,arr,dp)+" ");
            

            bw.flush();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    static int solve(int i,int j,Integer arr[],int dp[][]){
            // System.out.println("i : "+i+" j : "+j);
            if(dp[i][j] != -1)
                return dp[i][j];
             if(i>=j)
                return dp[i][j] = 0;
            else {
                if(arr[i] == arr[j])
                    dp[i][j] = solve(i+1,j-1,arr,dp)+1;
                else
                    dp[i][j] = Math.min(solve(i,j-1,arr,dp),solve(i+1,j,arr,dp))+1;
        
            }
        return dp[i][j];
    }

}