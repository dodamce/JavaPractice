<<<<<<< HEAD
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
=======
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
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
