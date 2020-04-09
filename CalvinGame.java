import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer; 
import static java.lang.Math.*;
import java.util.Arrays;

public class CalvinGame {
    public static void main(String[] args)  {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            K--;
            st = new StringTokenizer(br.readLine());
            int arr[] = new int[N];
            int dpf[] = new int[N];
            int dpb[] = new int[N];
    
            Arrays.fill(dpb,Integer.MIN_VALUE);
            Arrays.fill(dpf,Integer.MIN_VALUE);
    
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Forward(N-1, K, arr, dpf);
            Backward(N-1, K, arr, dpb);
            int ans = Integer.MIN_VALUE;
            for(int i=K;i<N;i++){
                int t = dpf[i] + dpb[i] - arr[i];
                ans = max(ans,t);
            }
            System.out.println(ans);    
        } catch (Exception e) {
            
        }
        


        
    }

    static int Forward(int i,int K,int arr[],int dpf[]){
        if(i<K)
            return Integer.MIN_VALUE;
        else if(i == K)
            return dpf[i] = 0;
        else if(dpf[i] != Integer.MIN_VALUE)
            return dpf[i];
        return dpf[i] = arr[i]+ max(Forward(i-1, K, arr, dpf),Forward(i-2, K, arr, dpf));

    }

   static  int Backward(int i,int K,int arr[],int dpb[]){
        if(i<0)
            return Integer.MIN_VALUE;
        else if(i == 0)
            return dpb[i] = arr[i];
        else if(dpb[i] != Integer.MIN_VALUE)
            return dpb[i];
        return dpb[i] = arr[i] + max(Backward(i-1, K, arr, dpb),Backward(i-2, K, arr, dpb));
    }
}

