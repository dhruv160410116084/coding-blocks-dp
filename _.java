import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.lang.Math.*;
import static java.lang.String.*;
import static java.util.Arrays.*;


public class _ {
    static int mod = 1000000007;
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
            System.out.println(e);
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

    static void printMultiArray(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}