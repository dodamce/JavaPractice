package 单例模式;

//饿汉模式
public class SingletonDemo {
    //饿汉模式
//    static class Singleton {
//        private static Singleton instance = new Singleton();
//
//        //防止类外生成
//        private Singleton() {
//        }
//
//        public static Singleton getInstance() {
//            return instance;
//        }
//    }

    //懒汉模式，慢加载模式
    static class Singleton {
        private static volatile Singleton instance = null;//保证内存可见性

        private Singleton() {
        }

        public static Singleton getInstance() {
            if (instance != null) {
                //首次调用涉及线程安全
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }

}
