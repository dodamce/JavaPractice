public class Daffodil {
    //打印1-100的水仙花数

    public static int GetBitSum(int num){
        int ret=0;
        int cout=0;//统计位数
        int dev=num;
        while(num!=0){
            cout++;
            num/=10;
        }
        while(dev!=0){
            ret+=Math.pow(dev%10,cout);
            dev/=10;
        }
        return ret;
    }
    public static void main(String[] args) {
        final int SIZE=1000;
        for(int i=0;i<SIZE;i++){
            if(GetBitSum(i)==i){
                System.out.println(i+" ");
            }
        }
    }
}
