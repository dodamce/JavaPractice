package operation;

import book.BookList;

import java.util.Scanner;

public class ReturnOperation implements Operation{
    public void work(BookList booklist){
        System.out.println("输入要归还的书籍");
        String name=new Scanner(System.in).nextLine();
        int pos=booklist.findBook(name);
        if(pos!=-1){
            booklist.GetPos(pos).setBorrow(false);
            System.out.println("归还成功");
        }
        else{
            System.out.println("书库无"+name+"这本书的存储记录");
        }
    }
}
