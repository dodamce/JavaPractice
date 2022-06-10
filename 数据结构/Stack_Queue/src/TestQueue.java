class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val=val;
        next=null;
    }
}

class MyQueue{//实现普通队列
    private Node head;
    private Node last;
    public MyQueue(){
        this.head=null;this.last=null;
    }
    public void offer(int val){
        if(head==null){
            this.head=new Node(val);
            this.last=this.head;
        }
        else{
            Node newNode=new Node(val);
            this.last.next=newNode;
            this.last=newNode;
        }
    }
    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int oldval=head.val;
        if(head==last){
            this.last=null;
        }
        this.head=this.head.next;
        return oldval;
    }
    public boolean isEmpty(){
        return head==null;
    }
}

public class TestQueue {
    public static void main(String[] args) {
        MyQueue queue=new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
//        System.out.println(queue.head);
//        System.out.println(queue.last);
    }
}
