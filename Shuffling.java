import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.util.Arrays.*;

public class Shuffling {
    static int mod = 1000000007;
    static char cArr[], aArr[], bArr[];
    static int dp[][][][];

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = parseInt(br.readLine());
            while (T-- != 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = toBinaryString(parseInt(st.nextToken()));
                String b = toBinaryString(parseInt(st.nextToken()));
                String c = toBinaryString(parseInt(st.nextToken()));

                cArr = new char[c.length()];
                aArr = new char[cArr.length];
                bArr = new char[cArr.length];

                cArr = c.toCharArray();

                int i = c.length() - 1;
                int ctr = a.length() - 1;
                int aSet = 0;
                int bSet = 0;

                while (i >= 0) {
                    if (ctr >= 0) {
                        aArr[ctr + (c.length() - a.length())] = a.charAt(ctr);
                        if (a.charAt(ctr) == '1')
                            aSet++;
                    } else
                        aArr[i] = '0';

                    ctr--;
                    i--;
                }

                i = c.length() - 1;
                ctr = b.length() - 1;

                while (i >= 0) {
                    if (ctr >= 0) {
                        bArr[ctr + (c.length() - b.length())] = b.charAt(ctr);
                        if (b.charAt(ctr) == '1')
                            bSet++;
                    } else
                        bArr[i] = '0';

                    ctr--;
                    i--;
                }

                // printArr(aArr);
                // printArr(bArr);
                // printArr(cArr);
                dp = new int[c.length()][aSet+1][bSet+1][2];

                for(int ii=0;ii<c.length();ii++){
                    for(int j=0;j<=aSet;j++){
                        for(int k=0;k<=bSet;k++){
                            for(int l=0;l<2;l++){
                                dp[ii][j][k][l] = -1;
                            }
                        }
                    }
                }
                bw.write(solve(aSet, bSet, c.length() - 1, 0) + "\n");
            }
            bw.flush();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    static int solve(int aSet, int bSet, int i, int carry) {
        // System.out.println(aSet+" "+bSet+" "+i+" "+carry);
        if(i<0){
            if(aSet==0 && bSet==0 && carry ==0)
            return 1;
            return 0;
        }
        if(aSet<0 || bSet<0)
            return 0;
        if(dp[i][aSet][bSet][carry] != -1)
        return dp[i][aSet][bSet][carry];
        
        if (cArr[i] == '0') {
            int a = 0;
            int b = 0;
            if (carry == 0) {
                a = solve(aSet, bSet, i - 1, 0);
                b = solve(aSet - 1, bSet - 1, i - 1, 1);
                return dp[i][aSet][bSet][carry]=a + b;
            } else {
                a = solve(aSet - 1, bSet, i - 1, 1);
                b = solve(aSet, bSet - 1, i - 1, 1);
                return dp[i][aSet][bSet][carry]=a + b;
            }
        }

        int a = 0;
        int b = 0;
        if (carry == 0) {
            a = solve(aSet - 1, bSet, i - 1, 0);
            b = solve(aSet, bSet - 1, i - 1, 0);

        } else {
            a = solve(aSet, bSet, i - 1, 0);
            b = solve(aSet - 1, bSet - 1, i - 1, 1);

        }
        return dp[i][aSet][bSet][carry]=a + b;

    }

    static void printArr(char arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + " ");
        }
        System.out.println();
    }
}

