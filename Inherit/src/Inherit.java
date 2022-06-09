//三个常用接口
//Comparable Comparator Cloneable

import java.util.Arrays;
import java.util.Comparator;

//接口，不能有具体普通的函数实现，default默认方法除外,可以有static方法，所有方法都是public
interface Face {
    default void fun(){
        System.out.println("Hello Word");
    }
    void test();
}

interface Face_a extends Face{//接口继承
    void test_a();
}

class TestInterface implements Face_a {
    public void test(){
        System.out.println("Test");
    }
    public void test_a(){
        System.out.println("test_a");
    }
}


//抽象类,不可被实例化
abstract class Shape{
    public abstract void draw();
}

class Circle extends Shape{
    public void draw(){
        System.out.println("⚪");
    }
}


class Animal{
    public String name;
    public int age;
    Animal(final String _name,final int _age){
        this.name=_name;
        this.age=_age;
    }
    Animal(){}

    public void eat(){
        System.out.println(name+" eat()");
    }
}

class Dog extends Animal{
    String name="123";
    public Dog(final String str,final int age){
        super(str,age);
    }

    void Print(){
        System.out.println(super.name);
    }
}

class Student /*implements Comparable<Student>*/{//方法一: 比较接口
    int age;
    String name;
    double score;
    Student(int _age,String _name,double _score){
        this.age=_age;
        this.name=_name;
        this.score =_score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

//    public int compareTo(Student st){
//        return this.age-st.age;
//    }
}

//比较器
class ScoreComparator implements Comparator<Student> {
    public int compare(Student l,Student r) {
        return (int)(l.score-r.score);
    }
}

//比较名字
class NameComparator implements Comparator<Student>{
    public int compare(Student l,Student r){
        return l.name.compareTo(r.name);
    }
}

public class Inherit {
    public static void main(String[] args) {
        Student[]arrList={new Student(20,"小明",89.5),new Student(19,"小华",76.5)};
        if(new ScoreComparator().compare(arrList[0],arrList[1])>1){
            System.out.println("大于");
        }
        System.out.println(Arrays.toString(arrList));
        Arrays.sort(arrList,new ScoreComparator());
        System.out.println(Arrays.toString(arrList));
    }
//    public static void main(String[] args) {
//        Student[]arrList={new Student(20,"小明",89.5),new Student(19,"小华",76.5)};
//        if(arrList[0].compareTo(arrList[1])>0){
//            System.out.println("大于");
//        }
//        System.out.println(Arrays.toString(arrList));
//        Arrays.sort(arrList);
//        System.out.println(Arrays.toString(arrList));
//    }
}
