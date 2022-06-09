class ListNode {
    int val;
    ListNode next;

    ListNode(int _val) {
        val = _val;
        next = null;
    }
}

public class List {
    private ListNode head;
    int size;// 链表的大小

    public int GetSize() {
        return size;
    }

    private ListNode GetNode(int time) {
        ListNode node = head;
        while (time >= 1) {
            node = node.next;
            time--;
        }
        return node;
    }

    public void disPlay() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("\n");
    }

    public void addFirst(int val) {// 头插法
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode node = new ListNode(val);
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(int val) {// 尾插法
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode node = GetNode(size - 1);
            node.next = new ListNode(val);
        }
        size++;
    }

    // 任意位置插入,下标为0
    public void Insert(int pos, int val) {
        if (pos == 0) {// 头插
            addFirst(val);
        } else if (pos == size) {// 尾插
            addLast(val);
        } else {
            ListNode node = GetNode(pos);
            ListNode newNode = new ListNode(val);
            newNode.next = node.next;
            node.next = newNode;
            size++;
        }
    }

    private ListNode GetPos(int toFind) {
        ListNode node = head;
        while (node != null && node.val != toFind) {
            node = node.next;
        }
        return node;
    }

    // 查找元素是否在链表中
    public boolean contains(int toFind) {
        return GetPos(toFind) != null;
    }

    // 删除第一个key值节点
    public void remove(int key) {
        ListNode node = head;
        ListNode prev = null;
        while (node.val != key) {
            prev = node;
            node = node.next;
        }
        if (prev == null) {
            // 头删
            head = head.next;
        } else {
            prev.next = node.next;
        }
        size--;
    }

    public void clear(){
        head=null;
        size=0;
    }

    // 删除全部key值
    public void removeAllKey(int key){
        ListNode node=head;
        ListNode prev=null;
        while(node!=null){
            while(node!=null&&node.val!=key){
                prev=node;
                node=node.next;
            }
            if(node==null){
                break;
            }
            else{
                if(prev==null){
                    head=head.next;
                }
                else{
                    prev.next=node.next;
                }
                node=node.next;
                size--;
            }
        }
    }
}
