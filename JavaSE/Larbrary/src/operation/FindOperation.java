<<<<<<< HEAD
package operation;

import book.BookList;

import java.util.Scanner;

public class FindOperation implements Operation{
    public void work(BookList booklist){
        Scanner io=new Scanner(System.in);
        int size=booklist.getUsenum();
        if(size==0){
            System.out.println("书架为空!");
            return;
        }
        System.out.println("输入要查找的书名: ");
        String name=io.nextLine();
        int pos=booklist.findBook(name);
        if(pos!=-1){
            System.out.println(booklist.GetPos(pos));
        }
        else{
            System.out.println("没找到这本书!!");
        }
    }
}
=======
package operation;

import book.BookList;

import java.util.Scanner;

public class FindOperation implements Operation{
    public void work(BookList booklist){
        Scanner io=new Scanner(System.in);
        int size=booklist.getUsenum();
        if(size==0){
            System.out.println("书架为空!");
            return;
        }
        System.out.println("输入要查找的书名: ");
        String name=io.nextLine();
        int pos=booklist.findBook(name);
        if(pos!=-1){
            System.out.println(booklist.GetPos(pos));
        }
        else{
            System.out.println("没找到这本书!!");
        }
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
