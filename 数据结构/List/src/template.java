<<<<<<< HEAD
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

class MyArrayList<T>{
    private T[]array;
    private int useSize;
    MyArrayList(){
        this.array=(T[])new Object[10];
        useSize=0;
    }

    public void add(T num){
        array[useSize]=num;
        useSize++;
    }

    public T get(int pos){
        return array[pos];
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}

public class template {
    public static void main(String[] args) {

        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=0;i<10;i++){
            arr.add(i);
        }

        arr.clear();

        arr.add(123);
        System.out.println(arr);
//
//        Iterator<Integer>pos=arr.iterator();
//
//        ListIterator<Integer>posList=arr.listIterator();
//
//        while(pos.hasNext()){
//            System.out.print(pos.next()+" ");
//        }

//        MyArrayList<Integer>arr=new MyArrayList<>();
//        arr.add(1);
//        arr.add(2);
//        MyArrayList<String>str=new MyArrayList<>();
//        str.add("123");
//        str.add("123");
//        System.out.println(str);
    }
}
=======
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

class MyArrayList<T>{
    private T[]array;
    private int useSize;
    MyArrayList(){
        this.array=(T[])new Object[10];
        useSize=0;
    }

    public void add(T num){
        array[useSize]=num;
        useSize++;
    }

    public T get(int pos){
        return array[pos];
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}

public class template {
    public static void main(String[] args) {

        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=0;i<10;i++){
            arr.add(i);
        }

        arr.clear();

        arr.add(123);
        System.out.println(arr);
//
//        Iterator<Integer>pos=arr.iterator();
//
//        ListIterator<Integer>posList=arr.listIterator();
//
//        while(pos.hasNext()){
//            System.out.print(pos.next()+" ");
//        }

//        MyArrayList<Integer>arr=new MyArrayList<>();
//        arr.add(1);
//        arr.add(2);
//        MyArrayList<String>str=new MyArrayList<>();
//        str.add("123");
//        str.add("123");
//        System.out.println(str);
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
