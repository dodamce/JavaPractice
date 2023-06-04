<<<<<<< HEAD
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
=======
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
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
