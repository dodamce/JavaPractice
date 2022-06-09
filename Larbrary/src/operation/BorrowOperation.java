package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BorrowOperation implements Operation {
    public void work(BookList booklist){
        System.out.println("输入要借阅的书籍");
        String name=new Scanner(System.in).nextLine();
        int pos=booklist.findBook(name);
        if(pos==-1){
            System.out.println("书库中无此书");
        }
        else{
            Book book=booklist.GetPos(pos);
            if(book.isBorrow()){
                System.out.println(name+"已经被借出");
            }
            else{
                book.setBorrow(true);
                System.out.println("借阅成功");
                System.out.println(book);
            }
        }
    }
}
