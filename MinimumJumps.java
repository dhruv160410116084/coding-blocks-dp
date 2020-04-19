import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
// import static java.lang.Math.*;
import static java.lang.String.*;
import static java.util.Arrays.*;

public class MinimumJumps {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = parseInt(br.readLine());
            int arr[] = takeInputArray(br.readLine(), N);
            bw.write(solve(arr) + "\n");
            bw.flush();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    static int solve(int arr[]) {
       int minJumps[] = new int [arr.length];
       int jumpPath[] = new int[arr.length];
       fill(minJumps,Integer.MAX_VALUE);
       minJumps[0] = 0;

       for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(i <= j+arr[j]){
                    minJumps[i] = min(minJumps[i],minJumps[j]+1);
                }
            }
       }
       return minJumps[arr.length-1];
    }

    static int[] takeInputArray(String str, int len) {
        StringTokenizer st = new StringTokenizer(str);
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        return arr;
    }

}