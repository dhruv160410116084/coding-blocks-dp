import java.io.*;
import java.util.*; 
import static java.lang.Math.*;

public class RainWaterTapping {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = Integer.parseInt(br.readLine());
            while(T-- !=0){
                int N = Integer.parseInt(br.readLine());
                int arr[] = new int[N];
                StringTokenizer  st = new StringTokenizer(br.readLine());
                for(int i=0;i<N;i++){
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                int maxR=arr[N-1];
                int maxL = arr[0];
    
                int Larr[]=new int[N];
                int Rarr[]=new int[N];
                Larr[0]=maxL;
                Rarr[N-1]=maxR;
                for(int i=1;i<N;i++){
                    maxL=max(maxL,arr[i]);
                    Larr[i]=maxL;
                    maxR=max(maxR,arr[N-1-i]);
                    Rarr[N-1-i]=maxR;
                }
                int ans=0;
                for(int i=0;i<N;i++){
                    ans+=min(Larr[i],Rarr[i])-arr[i];
                }
                    bw.write(ans+"\n");
     
            }
            bw.flush();
                   } catch (Exception e) {
            //TODO: handle exception
        }
    }
}