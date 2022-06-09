public class Cout9 {
    public static void main(String[] args) {
        final int SIZE=100;
        int ret=0;
        for(int i=0;i<=SIZE;i++){
            if(i%10==9){
                ret++;
            }
            if(i/10==9){
                ret++;
            }
        }
        System.out.println("ret="+ret);
    }
}
