import java.util.*;

class BoxStacking{
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        StringBuilder sb = new StringBuilder();
        while(T-- != 0){
            int n = scan.nextInt();
            Box arr[] = new Box[3*n];

            for(int i=0;i<n;i++){
                long h = scan.nextLong();
                long w = scan.nextLong();
                long l = scan.nextLong();
                arr[i] = new Box(h,w,l);
            }
            for(int i=0;i<n;i++){
                arr[n+i] = new Box(arr[i].w,arr[i].h,arr[i].l);
                // arr[n+i+1] = new Box(arr[i].l,arr[i].h,arr[i].w);
            }
            for(int i=0;i<n;i++){
                // arr[n+i] = new Box(arr[i].w,arr[i].h,arr[i].l);
                arr[2*n+i] = new Box(arr[i].l,arr[i].h,arr[i].w);
            }
            // Arrays.sort(arr,(a,b) -> (long)b.area - a.area);
            Arrays.sort(arr );
            // Arrays.sort(arr,Comparator.comparingLong());
        

            for(int i=0;i<3*n;i++){
                System.out.println(arr[i]);
            }

            long height[] = new long[3*n];
            // for(int i=0;i<height.length;i++)
            // height[i] = arr[i].h;
            long max = -1;
            for(int i=0;i<height.length;i++){
                // height[i] = 0;
                long val=0;
                for(int j=0;j<i;j++){
                    if(arr[i].w < arr[j].w && arr[i].l < arr[j].l){
                        // System.out.println("in if");
                        // height[i] = Math.max(height[i],arr[i].h+ height[j]);
                        // max = Math.max(max,height[i]);
                        val = Math.max(val,height[j]);
                    }
                   
                }
                height[i] = val + arr[i].h; 
                max = Math.max(max,height[i]);
                System.out.println(i+" => "+height[i]);
            }
            sb.append(max+"\n");


        }
        System.out.println(sb);
    }
}

class Box implements Comparable<Box>{
    long h,w,l,area;
    public Box(long h,long w,long l){
        this.h = h;
        this.w = w;
        this.l = l;
        this.area = w*l;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "h: "+h+" w: "+w+" l: "+l + " area: "+area;
    }

    @Override
    public int compareTo(Box o) {
        // TODO Auto-generated method stub
        return (int) (o.area- this.area);
    }
}