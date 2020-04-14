import java.io.*;
import java.util.*;

class PlaceTiles{
    static int mod = 1000000007;
    static HashMap<Long,Long> map = new HashMap<Long,Long>();                 
    public static void main(String[] args) {
        try {
            // System.out.println(19>>1);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = Integer.parseInt(br.readLine());
           
            while(T-- != 0){
                long N = Long.parseLong(br.readLine());
                long ans = solve_alt(N);
                bw.write(ans+"\n");
                
                
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
    }

    //another approach

    static long[][]  multiply(long a[][],long b[][]){
        long m[][] = new long[a[0].length][b.length];        
        for(int i=0;i<a[0].length;i++){
            for(int j=0;j<b.length;j++){
                for(int k=0;k<a[0].length;k++){
                    m[i][j] = (m[i][j]  + (a[i][k] * b[k][j] )%mod)%mod;
                }
            }
        }
        return m;
    }

    static long solve_alt(long n){
        if(n==0)
            return 0;
        if(n==1 || n==2)
            return 1;
        else{
            long mat[][]={{1,1},{1,0}};
            long temp[][]={{1,1},{1,0}};
            long I[][]={{1,0},{1,0}};
            long t=0;

            while(n>0 ){
                // System.out.println("  "+n);
                // temp = multiply(temp, temp);
                if( (n&1)==1 )
                I = multiply(I,mat);
                // else
                mat=multiply(mat, mat)  ;
                n=n>>1;
            }
               
            
            return I[0][0];
        }
    }

}   



