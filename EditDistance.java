import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
// import static java.lang.Math.*;
import static java.lang.String.*;
import static java.util.Arrays.*;


public class EditDistance {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // int T = parseInt(br.readLine()); 
            
                String sOne = br.readLine();
                String sTwo = br.readLine();
    
                int len1 = sOne.length();
                int len2 = sTwo.length();
    
                int dp[][] = new int[len1 + 1][len2 + 1] ;
    
                dp[0][0] = 0;
                for(int i=0;i<=len1;i++){
                    for(int j=0;j<=len2;j++){
                        if(i == 0 )
                            dp[i][j] = j;
                        else if (j==0){
                            dp[i][j]= i;
                        } 
                        else {
                                if(sOne.charAt(i-1) == sTwo.charAt(j-1))
                                    dp[i][j] = dp[i-1][j-1];
                                else{
                                    dp[i][j] = min(dp[i-1][j],min(dp[i][j-1],dp[i-1][j-1])) +1;
                                }                      
                        }
                    }
                }
              bw.write(dp[len1][len2]+" ");
            bw.flush();
        } catch (Exception e) {
            System.out.println(e);
        }    
    }
    
}
