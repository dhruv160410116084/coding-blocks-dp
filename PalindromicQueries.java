import java.util.Scanner;

//completed
class PalindromicQueries {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = 0, m = 0,left=0,right=0;
        String str = null;
        if (scan.hasNextInt()) {
            n = scan.nextInt();
        }
        if (scan.hasNext())
            str = scan.next();
        if (scan.hasNextInt()) {
            m = scan.nextInt();
        }
        int strLen = str.length();
        boolean dp[][] = new boolean[strLen][strLen];       

        preCompute(str,strLen,dp);
        for(int i=0;i<m;i++){
            left = scan.nextInt()-1;
            right = scan.nextInt()-1;
            sb.append(isPal(dp, left, right)+"\n");
        }
            
        scan.close();
        System.out.print(sb);
    }

    static void preCompute(String str,int strLen,boolean dp [][]){
       
        char strArr [] = str.toCharArray();
        
        for(int i=0;i<strLen;i++){
            for(int j=i+1;j<=strLen;j++){
                if(i<2) {
                    dp[j-i-1][j-1] =  strArr[j-i-1] == strArr[j-1]?true:false; 
                }
                else{
                    dp[j-i-1][j-1] = dp[j-i][j-2] && strArr[j-i-1] == strArr[j-1];
                }
            }
        }   
    }

    static String isPal(boolean dp[][],int left,int right){
        return dp[left][right] == true ? "YES" : "NO";
    }
}