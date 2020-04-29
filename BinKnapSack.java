import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
// import static java.lang.Math.*;
import static java.lang.String.*;
// imp/ort static java.util.Arrays.*;

public class BinKnapSack {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = parseInt(st.nextToken());
                int S = parseInt(st.nextToken());
                int size[]=takeInputArray(br.readLine(), N);
                int price[] = takeInputArray(br.readLine(), N);
                int dp[][] = new int[N][S+1];
               quickSort(size, price);
                for(int i=0;i<N;i++){
                    for(int j=0;j<=S;j++){
                        if(i==0 ){
                            if(j>=size[i])
                                dp[i][j] = price[i];
                        }
                        else if(j<   size[i]){
                            dp[i][j] = dp[i-1][j];
                        }else
                        dp[i][j] =  max(dp[i-1][j],dp[i-1][j-size[i]]+price[i]);
                    }
                }
                bw.write(dp[N-1][S]+"");
                
                bw.flush();

                printMultiArray(dp);
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
    static void printMultiArray(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void quickSort(int arr[],int a[]){
        sort(arr, a,0, arr.length-1);
    }


    static int partition(int arr[], int a[],int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 

                int t = a[i];
                a[i] = a[j];
                a[j]= t;
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
        int t = a[i+1];
                a[i+1] = a[high];
                a[high]= t;
  
        return i+1; 
    } 
  
  
    static void sort(int arr[], int a[],int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr,a, low, high); 
            sort(arr,a, low, pi-1); 
            sort(arr,a, pi+1, high); 
        } 
    }
}