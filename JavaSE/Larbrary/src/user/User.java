<<<<<<< HEAD
package user;

import book.BookList;
import operation.Operation;

import java.util.Scanner;

public abstract class User {//抽象类
    protected String name;
    protected Scanner choice;
    protected Operation[] operation;

    public User(String name){
        this.name=name;
        choice=new Scanner(System.in);
    }

    public void SelectWork(int op, BookList booklist){
        this.operation[op].work(booklist);
    }

    public abstract int menu();
}
=======
package user;

import book.BookList;
import operation.Operation;

import java.util.Scanner;

public abstract class User {//抽象类
    protected String name;
    protected Scanner choice;
    protected Operation[] operation;

    public User(String name){
        this.name=name;
        choice=new Scanner(System.in);
    }

    public void SelectWork(int op, BookList booklist){
        this.operation[op].work(booklist);
    }

    public abstract int menu();
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
