public class ListTest {
    public static void main(String[] args) {
        MyList test=new MyList();
        for(int i=0;i<15;i++){
            test.Push(i,i+1);
        }
        System.out.println(test.GetSize());
        test.disPlay();
        if(test.Contains(20)){
            System.out.println("错误");
        }
        else if(test.Contains(10)){
            System.out.println("正确");
        }
        test.remove(10);
        test.disPlay();
        test.remove(1000);
        System.out.println(test.GetPosVal(10));
        test.disPlay();
        test.clear();
        test.disPlay();
        System.out.println(test.GetPosVal(10));
        System.out.println(test.GetNumPos(3));
        System.out.println(test.GetNumPos(1000));
    }
}
