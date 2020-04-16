import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
// import static java.lang.Math.*;
import static java.lang.String.*;

public class MaximumPower {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // int T = parseInt(br.readLine()); 
            // while(T-- != 0){
                int N = parseInt(br.readLine());
                long arr[]=new long[N];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i=0;i<N;i++){
                    arr[i] = parseLong(st.nextToken());
                }
                System.out.println(solve(arr));

            // }
            // bw.flush();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    static long solve(long arr[]){
        long max_so_far=arr[0];
        long min_so_far = arr[0];
        long final_max=arr[0];

        for(int i=1;i<arr.length;i++){
            long temp = max_so_far;
            max_so_far = max(max_so_far*arr[i] , max(min_so_far*arr[i],arr[i])   );
            min_so_far = min(temp*arr[i],min(min_so_far*arr[i],arr[i]));

            if(final_max < max_so_far){
                final_max = max_so_far;
            }
        }
        return final_max;

    }
}