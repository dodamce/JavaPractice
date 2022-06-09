package book;

import java.util.Arrays;

public class BookList {
    private Book[] books;
    private int usenum;//书本个数
    private int capacity;

    public Book[] getBooks() {
        return books;
    }

    public BookList(){
        this.books=new Book[]{new Book("小王子","安托万·德·圣-埃克苏佩",34.5,"童话")};
        usenum=1;
        capacity=1;
    }

    public int getUsenum() {
        return usenum;
    }

    public int findBook(String name){
        for(int i=0;i<usenum;i++){
            if(books[i].getName().equals(name)){
               return i;
            }
        }
        return -1;
    }

    public void setUsenum(int usenum) {
        this.usenum = usenum;
    }

    public Book GetPos(int pos){
        if(pos>usenum){
            return null;
        }
        return this.books[pos];
    }

    public void addBook(Book book){
        if(usenum==capacity){
            this.books=Arrays.copyOf(this.books,2*capacity);
            capacity*=2;
            System.out.println("扩容成功");
        }
        this.books[usenum]=book;
        usenum++;
    }
}
