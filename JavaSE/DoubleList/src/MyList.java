class ListNode{
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int _val){
        this.val=_val;
        this.next=null;
        this.prev=null;
    }
}

//双向无头链表
public class MyList {
    ListNode head;
    ListNode tail;
    int size;
    MyList(){head=null;tail=null;size=0;}

    private ListNode Find(int _val){
        ListNode node=head;
        while(node!=null){
            if(node.val==_val){
                return node;
            }
            node=node.next;
        }
        return null;
    }

    public int GetSize(){
        return size;
    }

    public void clear(){
        head=null;
        tail=null;
    }

    public void disPlay(){
        if(size==0){
            return;
        }
        ListNode node=head;
        while(node!=tail.next){
            System.out.print(node.val+" ");
            node=node.next;
        }
        System.out.println("\n");
    }

    public void prevPlay(){
        if(size==0){
            return;
        }
        ListNode node=tail;
        while(node!=null){
            System.out.print(node.val+" ");
            node=node.prev;
        }
        System.out.println("\n");
    }

    //头插法
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(head==null){
            head=node;tail=node;
        }
        else {
            node.next = head;
            head.prev=node;
            head = node;
        }
        size++;
    }

    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        if(tail==null){
            head=node;tail=head;
        }
        else{
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        size++;
    }

    //向任意位置插入
    public void addIndex(int pos,int val){
        if(pos>=size){
            addLast(val);
        }
        else if(pos==0){
            addFirst(val);
        }
        else{
            ListNode node=head;
            for(int i=0;i<pos;i++){
                node=node.next;
            }
            ListNode new_node=new ListNode(val);
            new_node.prev=node.prev;
            new_node.next=node;
            node.prev.next=new_node;
            node.prev=new_node;
        }
        size++;
    }

    //删除一个值位置
    public void remove(int key){
        ListNode node=Find(key);
        if(node==null){
            return;
        }
        if(node==head){
            if(node==tail){
                clear();
            }
            else{
                head=node.next;
                head.prev=null;
            }
        }
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    //删除所有值为key的点
    public void removeAllKey(int key){
        while(true){
            ListNode node=Find(key);
            if(node==null){
                break;
            }
            remove(node.val);
        }
    }
}
