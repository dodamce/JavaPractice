<<<<<<< HEAD
import java.util.Arrays;

public class MyList {
    private int[]arr;
    private int size;

    private int[] DialTansy(){
        //数组扩容
        return Arrays.copyOf(this.arr,2*this.arr.length);
    }

    public MyList(){
        this.arr=new int[10];
        this.size=0;
    }

    public void Push(int pos,int val){
        if(pos>size||pos<0){
            System.out.println("下标违法");
            return;
        }
        else if(IsFull()){
            //System.out.println("数组已满");
            arr= DialTansy();//扩容

        }
        //pos位置的值改变，其他值向后移动
        int index=size-1;//有效数据位置
        for(int i=index;i>=pos;i--){
            arr[i+1]=arr[i];
        }
        this.arr[pos]=val;
        this.size++;
    }

    public boolean Contains(int toFind){
        for(int i=0;i<size;i++){
            if(arr[i]==toFind){
                return true;
            }
        }
        return false;
    }

    public int GetNumPos(int toFind){
        //获取num的下标，二分查找
        for(int i=0;i<size;i++){
            if(arr[i]==toFind){
                return i;
            }
        }
        return -1;
    }

    public int GetPosVal(int pos){
        if(pos<0||pos>=size){
            System.out.println("下标不合法");
            return -1;
        }
        return this.arr[pos];
    }

    public void SetPos(final int pos,final int val){
        if(pos<0||pos>=size){
            System.out.println("数组大小为:"+size);
        }
        else{
            this.arr[pos]=val;
        }
    }

    public boolean remove(final int del){
        int pos=GetNumPos(del);
        if(pos==-1){
            return false;
        }
        for(int i=pos;i<size;i++){
            this.arr[i]=this.arr[i+1];
        }
        size--;
        return true;
    }

    public void clear(){
        size=0;
    }

    public boolean IsEmpty(){
        return size==0;
    }

    public boolean IsFull(){
        return this.size==this.arr.length;
    }
    public int GetSize(){
        return size;
    }

    public void disPlay(){
        if(arr.length==0){
            return;
        }
        for(int i=0;i<size;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
    }
}
=======
import java.util.Arrays;

public class MyList {
    private int[]arr;
    private int size;

    private int[] DialTansy(){
        //数组扩容
        return Arrays.copyOf(this.arr,2*this.arr.length);
    }

    public MyList(){
        this.arr=new int[10];
        this.size=0;
    }

    public void Push(int pos,int val){
        if(pos>size||pos<0){
            System.out.println("下标违法");
            return;
        }
        else if(IsFull()){
            //System.out.println("数组已满");
            arr= DialTansy();//扩容

        }
        //pos位置的值改变，其他值向后移动
        int index=size-1;//有效数据位置
        for(int i=index;i>=pos;i--){
            arr[i+1]=arr[i];
        }
        this.arr[pos]=val;
        this.size++;
    }

    public boolean Contains(int toFind){
        for(int i=0;i<size;i++){
            if(arr[i]==toFind){
                return true;
            }
        }
        return false;
    }

    public int GetNumPos(int toFind){
        //获取num的下标，二分查找
        for(int i=0;i<size;i++){
            if(arr[i]==toFind){
                return i;
            }
        }
        return -1;
    }

    public int GetPosVal(int pos){
        if(pos<0||pos>=size){
            System.out.println("下标不合法");
            return -1;
        }
        return this.arr[pos];
    }

    public void SetPos(final int pos,final int val){
        if(pos<0||pos>=size){
            System.out.println("数组大小为:"+size);
        }
        else{
            this.arr[pos]=val;
        }
    }

    public boolean remove(final int del){
        int pos=GetNumPos(del);
        if(pos==-1){
            return false;
        }
        for(int i=pos;i<size;i++){
            this.arr[i]=this.arr[i+1];
        }
        size--;
        return true;
    }

    public void clear(){
        size=0;
    }

    public boolean IsEmpty(){
        return size==0;
    }

    public boolean IsFull(){
        return this.size==this.arr.length;
    }
    public int GetSize(){
        return size;
    }

    public void disPlay(){
        if(arr.length==0){
            return;
        }
        for(int i=0;i<size;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
