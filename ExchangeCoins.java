import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
// import static java.lang.Math.*;
import static java.lang.String.*;

public class ExchangeCoins {
    static HashMap<Long,Long> hs = new HashMap<Long,Long>();
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // int T = parseInt(br.readLine());
             
            String str = br.readLine();
            while(true){
                if(str.equals(""))
                    break;
                
                long N = parseLong(str);
                // System.out.println(solve(N));
                long ans = solve(N);
                bw.write(String.valueOf(ans)+"\n");
                str = br.readLine();
                if(str == null)
                    break;
                // StringTokenizer st = new StringTokenizer(br.readLine());
            }
            bw.flush();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    static long solve(long n){
        if(n<12)
            return n;
        if(hs.containsKey(n))
            return hs.get(n);

        long ans =max(n,solve(n/2)+solve(n/3)+solve(n/4));
        hs.put(n,ans);
        return ans;
    }
}