import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.lang.Math.*;
import static java.lang.String.*;


public class _ {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = parseInt(br.readLine()); 
            while(T-- != 0){
                int N = parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());
            }
            bw.flush();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    static int[] takeInputArray(String str, int len) {
        StringTokenizer st = new StringTokenizer(str);
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        return arr;
    }
    static long[] takeInputArrayLong(String str, int len) {
        StringTokenizer st = new StringTokenizer(str);
        long arr[] = new long[len];
        for (int i = 0; i < len; i++) {
            arr[i] = parseLong(st.nextToken());
        }
        return arr;
    }
}