import java.util.*;

public class VivekLovesArray {
    public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		while(t-- != 0){
			int n = scan.nextInt();
			int arr[] = new int[n];
			int sum[] = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = scan.nextInt();
				if(i==0)
					sum[i] = arr[i];
				else
					sum[i] = sum[i-1]+arr[i];
			}
			
 				sb.append(solve(0,arr.length-1,arr,sum)+"\n");
		}
		System.out.println(sb);
    }

	  static int getSum(int l,int r,int arr[]){
		  if(r<0)
			  return 0;
        if(l-1 < 0)
			return arr[r];
        return arr[r] - arr[l-1];
    }

    static int solve(int l,int r,int arr[],int sum[]){
      
	
        // for(int i=l;i<r;i++){
		// 	int lSum = getSum(l,i,sum);
		// 	int rSum =  getSum(i+1,r,sum);
        //     if(lSum == rSum ){
        //         res = Math.max(solve(l,i,arr,sum),solve(i+1,r,arr,sum))+1;
        //     }
        // }	
		if(l == r)
		return 0;
		// System.out.println("l :"+l+" r: "+r+" sum[l");
		if(getSum(0,l-l,sum) == getSum(0,r,sum)){
			// System.out.println("if executed");
			return r-l;
		}
		int res = 0;
		int low = l;
		int high = r;
		
		while(low<high){
			int mid = (low+high)/2;
			int lSum = getSum(l,mid,sum);
			int rSum = getSum(mid+1,r,sum);
			// System.out.println("l: "+l+"  r: "+r+" mid: "+mid+ " lSum : "+lSum+" rSum: "+rSum);
			if(lSum == rSum){
				 res = Math.max(solve(l,mid,arr,sum),solve(mid+1,r,arr,sum))+1;
				break;
			}
			  if(lSum < rSum)
			  		low= mid+1;
			  else high=mid;
		}
		return res;
    }
}