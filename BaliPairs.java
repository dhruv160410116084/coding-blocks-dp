import java.io.*;
import java.util.*;

 class BaliPairs {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            
            int T = Integer.parseInt(br.readLine());
            while(T-- != 0){
                int N = Integer.parseInt(br.readLine());
                
                int l[] = new int[N];
                int r[] = new int[N];
                int o_e,e_e;
                int o_o=  o_e=  e_e = 0;
                long m=1000000007;
                for(int i=0;i<N;i++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    l[i] = Integer.parseInt(st.nextToken());
                    r[i] = Integer.parseInt(st.nextToken());
                    if(l[i]%2 != r[i]%2 )
                        o_e++;
                    else if(l[i] %2 == 0 && r[i] %2 == 0)
                        e_e++;
                    else    
                        o_o++;
                }
        
                if(o_e == 0 && o_o % 2 == 0)
                    System.out.println(0);
                else if (o_e == 0 && o_o%2 == 1){
                    long t = getAnsMod(2,N,m);
                  System.out.println(t);
                }else
                    System.out.println(getAnsMod(2,N-1,m));
        
               
            }
        } catch (Exception e) {
            
        }
      

    }

    static long getAnsMod(long x,long n,long m){
       if(n == 0)
        return 1;
    else if (n%2 == 0)
        return getAnsMod((x*x)% m,n/2,m);
    else
        return (x*getAnsMod((x*x)%m, (n-1)/2, m))%m;
}
 }