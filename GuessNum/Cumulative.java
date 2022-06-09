public class Cumulative {
    public static void main(String[] args) {
        final int SIZE=100;
        double ret=0.0;
        int flag=1;
        for(int i=1;i<=SIZE;i++){
            ret+=(1.0/i)*flag;
            flag=-flag;
        }

        System.out.println("ret="+ret);
    }
}
