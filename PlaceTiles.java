import java.io.*;
import java.util.*;

class PlaceTiles{
    static int mod = 1000000007;
    static HashMap<Long,Long> map = new HashMap<Long,Long>();                 
    public static void main(String[] args) {
        try {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // int temp = ( ((46386 * 46386 ) % mod) +  ((28657*28657)%mod ) ) ; 
            // System.out.println("temp : "+temp);
            
            int T = Integer.parseInt(br.readLine());
           
            while(T-- != 0){
                long N = Long.parseLong(br.readLine());
                // long dp[] = new long[N+2];
                // System.out.println(Integer.MAX_VALUE+"  Max int: ");
                long ans = f(N+1);
                bw.write(ans+"\n");
                // long a=1;
                // long b=2;
                // if(N==1)
                //     bw.write(a+"\n");
                // else if(N==2)
                //     bw.write(b+"\n");
                // else{
                //     long c=0;
                //     for(long i=3;   i<=N;i++){
                //         c=a+b;
                //         c%=1000000007;
                //         a=b;
                //         b=c;
                //     }
                //     bw.write(c+"\n");
                // }
                
            }
            bw.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static long f(long n){
        if (n==0)
            return 0;
        else if(n==1)
            return 1;
        else if(n==2)
            return 1;
        else if( map.containsKey(n))
            return map.get(n);
        
        else if (n%2 ==0){
            long k = n/2;
            
                long ans = ( ( (    
                                                ( 2* f(k-1) )% mod  
                                                       +  
                                                f(k)) % mod ) 
                                                        *
                                                  f(k)   )%mod;
                map.put(n,ans);
                return ans;
            
        }
        long k=(n+1)/2;
                           long ans=      ( 
                                ((f(k)*f(k) )%mod )
                                          +  
                                (   (f(k-1)* f(k-1) ) %mod   )  

                                )%mod ;

                map.put(n,ans);
                return ans;

        // else if(n%2==0){
        //     int k=n/2;
        
        //     return dp[n] =  ( ( (    
        //                             ( 2* f(k-1,dp) )% mod  
        //                                    +  
        //                             f(k,dp)) % mod ) 
        //                                     *
        //                               f(k,dp)   )%mod;
        // }
        // int k = (n+1)/2;
        // return dp[n] =   ( 
        //                     ((f(k,dp)*f(k,dp) )%mod )
        //                               +  
        //                     (   (f(k-1,dp)* f(k-1,dp) ) %mod   )  
                            
        //                     )%mod ;
    }
}   