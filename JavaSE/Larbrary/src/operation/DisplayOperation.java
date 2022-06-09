package operation;

import book.BookList;

public class DisplayOperation implements Operation{
    public void work(BookList booklist){
        int size=booklist.getUsenum();
        if(size==0){
            System.out.println("书架为空");
            return;
        }
        for(int i=0;i<size;i++){
            System.out.println(booklist.GetPos(i));
        }
    }
}
