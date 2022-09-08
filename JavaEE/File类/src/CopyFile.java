import java.io.*;
import java.util.Scanner;

public class CopyFile {
    //指定两个路径 源路径 srcPath 复制到dstPath
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要拷贝的源路径");
        String srcPath = scanner.next();
        File srcFile = new File(srcPath);
        System.out.println("输入要拷贝的目的路径");
        String dstPath = scanner.next();
        File dstFile = new File(dstPath);
        if (!srcFile.isFile()) {
            System.out.println("源路径出错");
            return;
        }

        //读取源文件拷贝到目的文件中
        try (InputStream inputStream = new FileInputStream(srcFile)) {
            //打开输出目的文件
            try (OutputStream outputStream = new FileOutputStream(dstFile)) {
                byte[] buff = new byte[1024];
                while (true) {
                    int size = inputStream.read(buff);
                    if (size == -1) {
                        //读取完毕
                        break;
                    }
                    outputStream.write(buff, 0, size);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入完成");
    }
}
