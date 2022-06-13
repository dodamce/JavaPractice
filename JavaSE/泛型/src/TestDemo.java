import java.lang.reflect.Array;

class TestVector<E>{
    E[]array;
    public TestVector(Class<E>clazz,int Capcity){
        array=(E[]) Array.newInstance(clazz,Capcity);
    }
}

//泛型的上界,比较两个数字的大小,只有是Comparable的派生类才可以使用这个模板
class Arg<T extends Comparable<T>>{
    public T findMax(T[]array){
        T max=array[0];
        for (T t : array) {
            if (max.compareTo(t) < 0) {
                max = t;
            }
        }
        return max;
    }
}


//静态的泛型方法
class Arg2{
    public static<T extends Comparable<T>> T findMax(T[]array){
        T max=array[0];
        for (T t : array) {
            if (max.compareTo(t) < 0) {
                max = t;
            }
        }
        return max;
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Arg<Integer>arg=new Arg<>();
        Integer[] arr={1,2,3,4,5,6,7,19};
        System.out.println(arg.findMax(arr));
        System.out.println(Arg2.findMax(arr));//泛型方法
    }
}
