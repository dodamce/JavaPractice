<<<<<<< HEAD
package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class DelOperation implements Operation{
    public void work(BookList booklist){
        Scanner io=new Scanner(System.in);
        System.out.println("输入要删除的书名:");
        String name=io.nextLine();
        int pos=booklist.findBook(name);
        Book[] books=booklist.getBooks();
        if(pos!=-1){
            int size=booklist.getUsenum();
            for (int i = pos; i < size-1; i++) {
                books[i] = books[i + 1];
            }
            booklist.setUsenum(size-1);
            System.out.println("删除成功");
        }
        else{
            System.out.println("没有找到"+name+"这本书");
        }
    }
}
=======
package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class DelOperation implements Operation{
    public void work(BookList booklist){
        Scanner io=new Scanner(System.in);
        System.out.println("输入要删除的书名:");
        String name=io.nextLine();
        int pos=booklist.findBook(name);
        Book[] books=booklist.getBooks();
        if(pos!=-1){
            int size=booklist.getUsenum();
            for (int i = pos; i < size-1; i++) {
                books[i] = books[i + 1];
            }
            booklist.setUsenum(size-1);
            System.out.println("删除成功");
        }
        else{
            System.out.println("没有找到"+name+"这本书");
        }
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
