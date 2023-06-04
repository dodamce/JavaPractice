<<<<<<< HEAD
import java.util.Arrays;

class TestClone implements Cloneable{
    int[] arr;
    TestClone(){
        arr=new int[]{1,2,3,4};
    }

    @Override
    public String toString() {
        return "TestClone{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        TestClone obj=(TestClone) super.clone();
        obj.arr=this.arr.clone();
        return obj;
    }
}

public class Error {
    public static void fuc(int x)throws RuntimeException{
        if(x==0){
            throw new RuntimeException("除0错误");
        }
        System.out.println(10/x);
    }
    public static void main(String[] args) {
        try {
            fuc(0);
        }
        catch (RuntimeException e){
            e.printStackTrace();
            System.out.println("捕捉异常");
        }
    }

    public static void main1(String[] args) {
        TestClone test=new TestClone();
        System.out.println(test);
        String str="Hello word";
        try {
            TestClone testclone = (TestClone) test.clone();
            test.arr[0]=10;
            System.out.println(test);
            System.out.println(testclone);
        }catch (CloneNotSupportedException error){
            error.printStackTrace();
        }
    }
}
=======
import java.util.Arrays;

class TestClone implements Cloneable{
    int[] arr;
    TestClone(){
        arr=new int[]{1,2,3,4};
    }

    @Override
    public String toString() {
        return "TestClone{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        TestClone obj=(TestClone) super.clone();
        obj.arr=this.arr.clone();
        return obj;
    }
}

public class Error {
    public static void fuc(int x)throws RuntimeException{
        if(x==0){
            throw new RuntimeException("除0错误");
        }
        System.out.println(10/x);
    }
    public static void main(String[] args) {
        try {
            fuc(0);
        }
        catch (RuntimeException e){
            e.printStackTrace();
            System.out.println("捕捉异常");
        }
    }

    public static void main1(String[] args) {
        TestClone test=new TestClone();
        System.out.println(test);
        String str="Hello word";
        try {
            TestClone testclone = (TestClone) test.clone();
            test.arr[0]=10;
            System.out.println(test);
            System.out.println(testclone);
        }catch (CloneNotSupportedException error){
            error.printStackTrace();
        }
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
