import java.util.*;

public class JavaSort {
    //直接插入排序
    public static void InsertSort(List<Integer>list){
        for(int i=0;i<list.size()-1;i++){
            int endPos=i;
            int next=list.get(endPos+1);
            while(endPos>=0){
                if(list.get(endPos)>next){
                    list.set(endPos+1, list.get(endPos));
                    endPos--;
                }
                else{
                    break;
                }
            }
            list.set(endPos+1,next);
        }
    }

    //折半插入排序[]
    private static int BinarySearch(List<Integer> list,int target,int left,int right){
        while(left<=right){
            int mid=(left+right)>>1;
            if(list.get(mid)>target){
                right=mid-1;
            }
            else if(list.get(mid)<target){
                left=mid+1;
            }
            else{
                //相同，保证稳定性
                left=mid+1;
                break;
            }
        }
        return left;
    }
    public static void InsertSortUseBisearch(List<Integer>list){
        for(int i=0;i<list.size()-1;i++){
            int endPos=i;
            int next=list.get(endPos+1);
            int findPos=BinarySearch(list,next,0,endPos);
            for(int pos=endPos;pos>=findPos;pos--){
                list.set(pos+1,list.get(pos));
            }
            list.set(findPos,next);
        }
    }

    //希尔排序
    public static void ShellSort(List<Integer>list){
        int step=list.size();
        while(step>1){
            step=step/3+1;
            for(int i=0;i< list.size()-step;i++){
                int endPos=i;
                int next= list.get(i+step);
                while(endPos>=0){
                    if(list.get(endPos)>next){
                        list.set(endPos+step,list.get(endPos));
                        endPos-=step;
                    }
                    else{
                        break;
                    }
                }
                list.set(endPos+step,next);
            }
        }
    }

    //冒泡排序
    private static void swap(List<Integer>list,int left,int right){
        int temp=list.get(left);
        list.set(left, list.get(right));
        list.set(right,temp);
    }
    public static void BubbleSort(List<Integer>list){
        for(int i=0;i< list.size();i++){
            boolean flag=false;
            for(int j=0;j< list.size()-i-1;j++){
                if(list.get(j)>list.get(j+1)){
                    flag=true;
                    swap(list,j,j+1);
                }
            }
            if(!flag){
                break;
            }
        }
    }

    //快速排序
    //三数取中,返回中间值的下标
    private static int GetMidPos(List<Integer>list,int left,int right){
        int mid=(left+right)>>1;
        if(list.get(left)<list.get(mid)){
            if(list.get(mid)<list.get(right)){
                return mid;
            }
            else if(list.get(right)>list.get(left)){
                return right;
            }
            else{
                return left;
            }
        }
        else{
            if(list.get(mid)>list.get(right)){
                return mid;
            }
            else if(list.get(right)>list.get(left)){
                return left;
            }
            else{
                return right;
            }
        }
    }
    //三种交换方法
    private static int HoareLeftRightPtr(List<Integer>list,int left,int right){
        int midPos=GetMidPos(list,left,right);
        swap(list,left,midPos);
        int keyPos=left;int key=list.get(keyPos);
        while(left<right){
            while(list.get(right)>=key&&right>left){
                right--;
            }
            while(list.get(left)<=key&&left<right){
                left++;
            }
            swap(list,left,right);
        }
        swap(list,left,keyPos);
        return left;
    }
    private static int PitExchangeMethod(List<Integer>list,int left,int right){
        int midPos=GetMidPos(list,left,right);
        swap(list,left,midPos);
        int key=list.get(left);
        while(left<right){
            while(list.get(right)>=key&&right>left){
                right--;
            }
            list.set(left,list.get(right));
            while(list.get(left)<=key&&left<right){
                left++;
            }
            list.set(right, list.get(left));
        }
        list.set(left,key);//left位置一定时坑
        return left;
    }
    private static int PrevNextPtr(List<Integer>list,int left,int right){
        int mid=GetMidPos(list,left,right);
        swap(list,left,mid);
        int keyPos=left; int key=list.get(keyPos);
        int prev=left; int next=left+1;//找小与key值
        while(next<list.size()){
            if(list.get(next)<key){
                prev++;
                if(prev!=next){
                    swap(list,prev,right);
                }
            }
            next++;
        }
        swap(list,keyPos,prev);
        return prev;
    }
    private static void _QuickSort(List<Integer>list,int left,int right){
        if(left>=right){
            return;
        }
        //int keyPos=HoareLeftRightPtr(list,left,right);
        //int keyPos=PitExchangeMethod(list, left, right);
        int keyPos=PrevNextPtr(list, left, right);
        _QuickSort(list,left,keyPos-1);
        _QuickSort(list,keyPos+1,right);
    }
    public static void QuickSort(List<Integer>list){
        _QuickSort(list,0,list.size()-1);
    }

    //快速排序非递归
    public static void QuickSortNotRecursive(List<Integer>list){
        Stack<List<Integer>>stack=new Stack<>();
        List<Integer>posits=new ArrayList<>(Arrays.asList(0,list.size()-1));
        stack.push(posits);
        while(!stack.isEmpty()){
            List<Integer>pos=stack.pop();
            int keyPos=HoareLeftRightPtr(list,pos.get(0),pos.get(1));
            if(pos.get(0)<keyPos-1){
                stack.push(new ArrayList<>(Arrays.asList(pos.get(0),keyPos-1)));
            }
            if(keyPos+1<pos.get(1)){
                stack.push(new ArrayList<>(Arrays.asList(keyPos+1,pos.get(1))));
            }
        }
    }

    //选择排序
    public static void SelectSort(List<Integer>list){
        int left=0; int right=list.size()-1;
        while(left<right){
            int maxPos=left;
            int minPos=left;
            for(int i=left;i<=right;i++){
                if(list.get(i)<list.get(minPos)){
                    minPos=i;
                }
                else if(list.get(i)>list.get(maxPos)){
                    maxPos=i;
                }
            }
            swap(list,left,minPos);
            if(maxPos==left){
                maxPos=minPos;
            }
            swap(list,right,maxPos);
            left++;right--;
        }
    }

    //堆排序,从小到大排序，建立大堆
    private  static void AdjustDown(List<Integer>list,int parent,int useSize){
        int child=parent*2+1;
        while(child<useSize){
            if(child+1<useSize&&list.get(child)<list.get(child+1)){
                child++;
            }
            if(list.get(child)>list.get(parent)){
                swap(list,child,parent);
            }
            else{
                break;
            }
            parent=child;
            child=2*parent+1;
        }
    }
    public static void HeapSort(List<Integer>list){
        //建堆
        for(int i= (list.size()-1-1)/2;i>=0;i--){
            AdjustDown(list,i,list.size());
        }
        int end= list.size();
        while(end>0){
            swap(list,0,end-1);
            end--;
            AdjustDown(list,0,end);
        }
    }

    //归并排序
    private  static void Merge(List<Integer>list,List<Integer>buff,int leftBegin,int leftEnd,int rightBegin,int rightEnd){
        buff.clear();
        int begin=leftBegin;int end=rightEnd;
        while(leftBegin<=leftEnd&&rightBegin<=rightEnd){
            if(list.get(leftBegin)<=list.get(rightBegin)){
                buff.add(list.get(leftBegin++));
            }
            else{
                buff.add(list.get(rightBegin++));
            }
        }
        while(leftBegin<=leftEnd){
            buff.add(list.get(leftBegin++));
        }
        while(rightBegin<=rightEnd){
            buff.add(list.get(rightBegin++));
        }
        for(int i=begin;i<=end;i++){
            list.set(i,buff.get(i-begin));
        }
    }
    private static void _MergeSort(List<Integer>list,List<Integer>buff,int left,int right){
        if(left>=right){
            return;
        }
        int midPos=(left+right)>>1;
        _MergeSort(list,buff,left,midPos);
        _MergeSort(list,buff,midPos+1,right);
        Merge(list,buff,left,midPos,midPos+1,right);
    }
    public static void MergeSort(List<Integer>list){
        List<Integer>buff=new ArrayList<>(list.size());
        _MergeSort(list,buff,0,list.size()-1);
    }

    //归并排序非递归写法
    public static void MergeSortNotRecursion(List<Integer>list){
        int step=1;
        List<Integer> buff = new ArrayList<>();
        while(step<list.size()){
            for(int i=0;i<list.size();i+=2*step){
                int leftBegin=i; int leftEnd=i+step-1;
                int rightBegin=i+step; int rightEnd=i+2*step-1;
                if(rightBegin>=list.size()){
                    break;
                }
                if(rightEnd>= list.size()){
                    rightEnd= list.size()-1;
                }
                Merge(list,buff,leftBegin,leftEnd,rightBegin,rightEnd);
            }
            step*=2;
        }
    }

    //计数排序
    public static void CoutSort(List<Integer>list){
        int max= Collections.max(list);
        int min=Collections.min(list);
        int[]array=new int[max-min+1];
        for (Integer integer : list) {
            array[integer - min]++;
        }
        int arrPos=0;
        for(int i=0;i< array.length;i++){
            while((array[i]--)>0){
                list.set(arrPos++,i+min);
            }
        }
    }
}
