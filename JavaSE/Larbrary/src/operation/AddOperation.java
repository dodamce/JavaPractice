<<<<<<< HEAD
package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddOperation implements Operation{
    public void work(BookList booklist){
        String name;String author;double price;String type;
        Scanner io=new Scanner(System.in);
        System.out.println("书名:");
        name=io.nextLine();
        System.out.println("作者: ");
        author=io.nextLine();
        System.out.println("书籍类型: ");
        type=io.nextLine();
        System.out.println("价格: ");
        price=io.nextDouble();
        Book book=new Book(name,author,price,type);
        booklist.addBook(book);

        System.out.println("添加图书成功！");
        //System.out.println(booklist.getUsenum());
    }
}
=======
package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddOperation implements Operation{
    public void work(BookList booklist){
        String name;String author;double price;String type;
        Scanner io=new Scanner(System.in);
        System.out.println("书名:");
        name=io.nextLine();
        System.out.println("作者: ");
        author=io.nextLine();
        System.out.println("书籍类型: ");
        type=io.nextLine();
        System.out.println("价格: ");
        price=io.nextDouble();
        Book book=new Book(name,author,price,type);
        booklist.addBook(book);

        System.out.println("添加图书成功！");
        //System.out.println(booklist.getUsenum());
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
