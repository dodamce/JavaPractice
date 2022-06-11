import java.util.*;

/**
 * 堆的调整是从最后一棵子树开始
 */

class Heap{
    public int[]array;
    int useSize=0;
    private  void swap(int[]array,int left,int right){
        int tmp=array[left];
        array[left]=array[right];
        array[right]=tmp;
    }
    private void AdjustDown(int root){
        //向下调整,每次调整的边界都是数组的大小，超过数组大小停止调整
        int child=2*root+1;
        while(child< useSize){
            //存在叶子节点,找到最大值
            if(child+1< useSize&&array[child]<array[child+1]){
                child++;
            }
            if(array[root]<array[child]){
                swap(array,root,child);
            }
            else{
                break;
            }
            root=child;
            child=2*root+1;
        }
    }
    Heap(int[]_array){ //创建大根堆
        this.array=_array.clone();
        useSize=this.array.length;
        for(int parent=(array.length-1)/2;parent>=0;parent--){
            AdjustDown(parent);
        }
    }
    Heap(int capcity){
        this.array=new int[capcity];
    }
    //入队，保证堆仍然为大根堆
    private void grow(){
        this.array=Arrays.copyOf(this.array,2*this.array.length);
    }
    //向上调整
    private void AdjustUp(int child){
        int root=(child-1)/2;
        while(root>=0){
            if(this.array[root]<this.array[child]){
                swap(this.array,root,child);
            }
            else{
                break;
            }
            child=root;
            root=(child-1)/2;
        }
    }
    public void add(int num){
        if(this.useSize==this.array.length){
            grow();
        }
        this.array[useSize]=num;
        AdjustUp(useSize);
        useSize++;
    }
    //出堆
    public boolean isEmpty(){
        return useSize==0;
    }
    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("堆为空");
        }
        int ret=this.array[0];
        swap(this.array,0,this.useSize-1);
        this.array[this.useSize-1]=0;
        this.useSize--;
        AdjustDown(0);
        return ret;
    }
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<useSize;i++){
            str.append(this.array[i]).append(" ");
        }
        return str.toString();
    }
}

class TopK{
    static int[] topK(int[]array,int k){//找前k个最小的元素
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });//建大堆
        //遍历数组，前K个元素放到队列中
        for(int i=0;i<array.length;i++){
            if(maxHeap.size()<k){
                maxHeap.offer(array[i]);
            }
            else{
                if(array[i]<maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        int[]ret=new int[maxHeap.size()];
        for(int i=0;i<k;i++){
            ret[i]=maxHeap.poll();
        }
        return ret;
    }
}

public class TestHeap {
    public static void main(String[] args) {
        int[]arr={27,15,19,18,28,34,65,49,25,37};
        System.out.println(Arrays.toString(TopK.topK(arr, 4)));
    }
}
