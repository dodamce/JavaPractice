import java.io.*;
import java.util.Scanner;

public class SearchFile {
    //递归遍历文件，查看包含关键字的所有的文件
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要扫描的路径");
        String rootPath = scanner.next();
        System.out.println("输入要查询的关键字");
        String key = scanner.next();
        File rootDir = new File(rootPath);
        if (!rootDir.isDirectory()) {
            System.out.println("文件路径出错！");
        }

        //递归遍历路径下的所有文件
        disPlayDir(rootDir, key);
    }

    private static void disPlayDir(File rootDir, String key) {
        File[] files = rootDir.listFiles();
        if (files == null) {
            return;
        }
        for (File item : files) {
            if (item.isFile()) {
                //查找关键字是否在文件中
                if (inFile(item, key)) {
                    try {
                        System.out.println(item.getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                disPlayDir(item, key);
            }
        }
    }

    private static boolean inFile(File item, String key) {
        StringBuilder stringBuilder = new StringBuilder();
        //读出文件中所有内容
        try (Reader reader = new FileReader(item)) {
            char[] buff = new char[1024];
            while (true) {
                int size = reader.read(buff);
                if (size == -1) {
                    break;
                }
                stringBuilder.append(buff, 0, size);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.indexOf(key) != -1;
    }
}
