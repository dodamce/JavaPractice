import java.util.Arrays;

class MyStack<E>{
    private Object[] array;
    private int useSize;
    MyStack(){
        this.array=new Object[1];
        this.useSize=0;
    }
    private void dilatation(){
        this.array= Arrays.copyOf(this.array,this.array.length*2);
    }
    public void push(E num){
        if(array.length==this.useSize){
            dilatation();
            System.out.println("INFO:扩容成功");
        }
        array[useSize++]=num;
    }
    public Object pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        Object num=array[useSize-1];
        this.array[useSize-1]=null;
        this.useSize--;
        return num;
    }
    public boolean isEmpty(){
        return useSize==0;
    }
}
