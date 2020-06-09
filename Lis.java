import java.util.*;
import java.io.*;
class Lis{
   public static void main(String[] args) {
        int arr[] = {10,9,2,5,3,7,101,18};
       int ans= 0;
       for(int i=arr.length-1;i>=0;i--)
       {
         ans = Math.max(ans,  Lis(arr,i));
       }
       System.out.println("ans: "+ ans);

    }

    static int Lis(int arr[],int i){
        if(i < 0)
            return 0;
        int m = 1;
        for(int j=0;j<i;j++){
            if(arr[j] < arr[i])
                m = Math.max(m,1+Lis(arr,j));
        }
        return m;
    }
}

