package operation;

import book.BookList;

public class ExitOperation implements Operation{
    public void work(BookList booklist){
        System.out.println("退出系统");
        System.exit(0);
    }
}
