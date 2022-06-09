import java.util.Arrays;

public class Array{
    public static void PrintArr(int[]arr) {
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            if(i!=arr.length-1){
                System.out.print(arr[i]+",");
            } 
            else{
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");

    }

    //判断数组是否时递增
    public static boolean UpperArray(int[]arr){
        if(arr==null){
            return false;
        }
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }

    //冒泡排序
    public static void Sort(int[]arr){
        for(int i=0;i<arr.length;i++){
            boolean flg=false;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                    flg=true;
                }
            }
            if(flg==false){
                break;
            }
        }
    }
    public static void main(String[] args) {
        //int[]arr=new int[]{};
        int[]arr={3,1,5,7,2,1,6,1,4,1,12,6};
        System.out.println(UpperArray(arr));
        Sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}