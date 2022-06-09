import java.util.Arrays;

class ArrayError extends RuntimeException{//非受查异常
    public ArrayError(String msg){
        super(msg);
    }
}

class ArrayList<E>{
    private Object[] data;
    private int useSize=0;
    private final Object[] DEFAULT={};
    private int Capacity;
    public ArrayList(){
        this.data= DEFAULT;
        this.Capacity=0;
    }
    public ArrayList(int capacity) throws ArrayError{
        if(capacity>0){
            this.data=new Object[capacity];
            this.Capacity=capacity;
        }
        else if(capacity==0){
            this.data=new Object[]{};
        }
        else{
            throw new ArrayError("初始化给定数组容量错误");
        }
    }
    private void dilatation(){
        if(data==DEFAULT){
            //默认给10个,
            data=new Object[10];
            this.Capacity=10;
            //System.out.println("INFO: 扩容成功");
        }
        else{
            int capacity=this.Capacity+(this.Capacity>>1);//1.5倍扩容
            this.data=Arrays.copyOf(this.data,capacity);
            this.Capacity=capacity;
            //System.out.println("INFO: 1.5倍扩容");
        }
    }
    public boolean add(E member){
        if(this.Capacity==this.useSize){
            //扩容
            dilatation();
        }
        this.data[this.useSize++]=member;
        return true;
    }
    void add(int index,E member){//index位置插入数据
        if(index<0||index>useSize){
            throw new ArrayError("插入下标不合法,下标范围[0-"+useSize+"]");
        }
        if(this.Capacity==this.useSize){
            dilatation();
        }
        for(int i=useSize;i>index;i--){
            this.data[i]=this.data[i-1];
        }
        this.data[index]=member;
        this.useSize++;
    }
    public void remove(){
        if(useSize>0){
            this.data[useSize-1]=null;
            useSize--;
        }
    }
    public void remove(int pos){//移除pos位置的值
        if(pos<useSize) {
            if (this.useSize == 1) {
                this.data[0] = null;
            }
            for (int i = pos; i < useSize - 1; i++) {
                this.data[i] = this.data[i + 1];
            }
            this.data[useSize] = null;
            this.useSize--;
        }
    }
    public void clear(){
        for(int i=0;i<data.length;i++){
            this.data[i]=null;
        }
        this.useSize=0;
    }

    public void disPlay(){
        for(int i=0;i<useSize;i++){
            System.out.print(this.data[i]+" ");
        }
        System.out.println();
    }

    public int getUseSize() {
        return useSize;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer>arr=new ArrayList<>();
        System.out.println(arr.add(10));
        System.out.println(arr.add(20));
        arr.add(50);
        arr.disPlay();
        arr.add(0,123);
        arr.disPlay();
        arr.add(arr.getUseSize(),678);
        arr.disPlay();
        arr.add(1,456);
        arr.disPlay();

        ArrayList<String>arrString=new ArrayList<>();
        arrString.add("hello");
        arrString.add("word");
        arrString.add(0,"test");
        arrString.disPlay();
//        arrString.clear();
//        arrString.disPlay();
        int size=arr.getUseSize();
        for(int i=0;i<size;i++){
            arr.remove(0);
            arr.disPlay();
        }
        System.out.println(arr.getUseSize());
        System.out.println(arr);

        int arrsize=arrString.getUseSize();
        for(int i=0;i<arrsize;i++){
            arrString.remove();
            arrString.disPlay();
        }
        System.out.println(arrString);
        System.out.println(arrString.getUseSize());
    }
}
