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
