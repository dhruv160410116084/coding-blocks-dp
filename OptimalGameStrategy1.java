import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
// import static java.lang.Long.*;
// import static java.lang.Math.*;
import static java.lang.String.*;
import static java.util.Arrays.*;

public class OptimalGameStrategy1 {
    public static void main(String[] args) {
        try {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = parseInt(br.readLine());
            int arr[] = takeInputArray(br.readLine(), N);
            int ans = solve(arr,0,N-1);
            bw.write( ans+" ");

            bw.flush();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    static int solve(int arr[],int i,int j){
        if(i==j)
            return arr[i];
        else{
            int select =0;
            char c = 0;
            if(arr[i] > arr[j]){
                select = arr[i];
                c = 'i';
            }
            else{
                select = arr[j];
                c = 'j';
            }

            int temp1 = 0;
            int temp2 = 0;
           
               temp1 =  solve(arr,i+1,j);
               temp2 = solve(arr,i,j-1);
           
            return select + max(temp1,temp2);
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

}