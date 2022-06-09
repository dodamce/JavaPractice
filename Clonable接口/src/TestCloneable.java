import java.lang.reflect.Field;

class Money implements Cloneable{
    int m=100;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Money{" +
                "m=" + m +
                '}';
    }
}

class Test implements Cloneable{
    private int age=18;
    Money money=new Money();

    @Override
    public String toString() {
        return "Test{" +
                "age=" + age +
                ", money=" + money +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }


//重写克隆方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Test clone=(Test)super.clone();
        clone.money=(Money)this.money.clone();
        return clone;
    }
}




public class TestCloneable {
    public static void main(String[] args) throws CloneNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Test();
    }

    //反射修改类私有成员
    public static void Test() throws NoSuchFieldException, IllegalAccessException {
        String Str="abcd";
        System.out.println(Str);
        Class<?> stringClass = String.class;
        Field field=stringClass.getDeclaredField("value");
        field.setAccessible(true);

        char[]arr=(char[])field.get(Str);
        arr[0]='x';
        System.out.println(Str);
    }
}
