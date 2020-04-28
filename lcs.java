import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
// import static java.lang.Math.*;
import static java.lang.String.*;
import static java.util.Arrays.*;

public class lcs {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           String x = br.readLine();
           String y = br.readLine();
           int row = x.length()+1;
           int col = y.length()+1; 
           int dp[][] = new int[row][col];
           int dir[][]=new int [row ][col];
           int CROSS = 1;
           int UP = 2;
           int  LEFT = 3;

           for(int i=1;i<row;i++){
               for(int j=1;j<col;j++){
                   if(x.charAt(i-1) == y.charAt(j-1)){
                       dp[i][j] = dp[i-1][j-1]+1;
                        dir[i][j]=CROSS;                 
                   }
                    else{
                        if(dp[i-1][j]<=dp[i][j-1]){
                            dp[i][j] = dp[i][j-1];
                            dir[i][j] = LEFT;
                        }
                        else{
                            dp[i][j] = dp[i-1][j];
                            dir[i][j] = UP;
                        }

                    }
               }
           }
           int i=x.length();
           int j = y.length();
           StringBuilder sb = new StringBuilder();
          while(i!=0 & j!=0){
              if(dir[i][j] == CROSS){
                //   bw.write(x.charAt(i-1));
                  sb.append(x.charAt(i-1));
                
                  i--;
                  j--;
              }
              else if(dir[i][j]==LEFT){
                  j--;
              }else{
                  i--;
              }
          }
           System.out.println(sb.reverse());
        
            bw.flush();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }
}