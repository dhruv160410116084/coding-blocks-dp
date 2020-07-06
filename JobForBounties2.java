import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.util.Arrays.*;


public class JobForBounties2 {
  static  int rewards[] ;
  static  int duration[];
  static  int deadline[];
  static int T;
  static int N;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
             T = parseInt(st.nextToken()); 
             N = parseInt(st.nextToken());
             rewards   = takeInputArray(br.readLine(), N);
             duration = takeInputArray(br.readLine(), N);
             deadline = takeInputArray(br.readLine(), N);
             
            int ans = solve(0,0,0);

            System.out.println(ans);
            bw.flush();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }

    static int solve(int i,int curTime,int prof){
        if(i>= N)
            return prof;
        System.out.println(i+" "+curTime+" "+prof);
        int a=0,b=0;
        int latestTime =  curTime+duration[i];
        if( latestTime <= deadline[i]){
            
            a=solve(i+1,latestTime,prof+rewards[i]);
        }
            b=solve(i+1,curTime,prof);
        return max(a,b);
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