import java.util.HashMap;
import java.util.Objects;

class Hash {
    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] array;
    public int useSize;

    public Hash() {
        this.useSize = 0;
        this.array = new Node[10];
    }

    public void put(int key, int val) {
        //找到key所在的位置
        int index = key % this.array.length;
        //遍历链表，看是否有相同的key
        Node node = this.array[index];
        while (node != null) {
            if (node.key == key) {
                node.val = val;
                return;
            }
            node = node.next;
        }
        //没有这个元素，头插法
        //先检查负载因子
        this.useSize++;
        if (loadFacter() > DEFAULT_LOADFACTER) {
            //扩容
            resize();
        }
        node = new Node(key, val);
        node.next = this.array[index];
        this.array[index] = node;
    }

    public int get(int key) {
        int index = key % this.array.length;
        Node node = this.array[index];
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;//没找到返回-1
    }

    public static final double DEFAULT_LOADFACTER = 0.75;

    private double loadFacter() {
        return 1.0 * this.useSize / this.array.length;
    }

    private void resize() {
        Node[] new_array = new Node[2 * this.array.length];
        for (int i = 0; i < this.array.length; i++) {
            Node node = this.array[i];
            while (node != null) {
                int index = node.key % new_array.length;
                //记录下一个节点
                Node next = node.next;
                node.next = new_array[index];
                new_array[index] = node;
                node = next;
            }
        }
        this.array = new_array;
    }
}

//测试HashCode
class Person {//自定义类型重写hashCode函数
    public String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class HashCode {
    public static void main(String[] args) {
        Hash hash = new Hash();
        for (int i = 0; i < 20; i++) {
            hash.put(i, i + 1);
        }
        for (int i = 20; i >= 0; i--) {
            System.out.print(hash.get(i) + " ");
        }
        System.out.println();
        System.out.println(new Person("123").hashCode());
        System.out.println(new Person("123").hashCode());
        HashMap<Person,Integer>hashMap=new HashMap<>();
        Person person=new Person("Hello");
        hashMap.put(person,1);//需要重写hashCode方法
    }
}
