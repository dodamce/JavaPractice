public class TestList {
    public static void main(String[] args) {
        MyList list=new MyList();
        for(int i=0;i<10;i++){
            list.addLast(i);
        }
        list.disPlay();
        list.prevPlay();
        System.out.println(list.GetSize());
        for(int i=0;i<10;i++){
            list.addLast(i);
        }
        list.disPlay();
        System.out.println(list.GetSize());
        list.prevPlay();
        System.out.println("-----------------");
        list.addIndex(2,10000);
        list.addIndex(0,10000);
        list.addIndex(21,10000);
        list.addIndex(5,10000);
        list.disPlay();
        list.prevPlay();
    }
}
