import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DeleteFile {

    //删除路径下的路径下的文件
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入删除文件所在目录:");
        String rootPath = scanner.next();
        File rootDir = new File(rootPath);
        if (!rootDir.isDirectory()) {
            return;
        }
        System.out.println("输入要删除的文件:");
        String delFileName = scanner.next();

        //遍历目录，找到要删除的文件进行删除
        delFile(rootDir, delFileName);
    }

    private static void delFile(File rootDir, String delFileName) {
        //列出rootDir中的所有内容
        File[] list = rootDir.listFiles();
        if (list == null) {
            return;
        }
        //遍历当前的内容，如果是普通文件，检测名字；如果是目录，递归到下一层文件夹中
        for (File item : list) {
            if (item.isFile()) {
                if (item.getName().contains(delFileName)) {
                    //删除文件
                    boolean flag = MenuHelp(item);
                    if (flag) {
                        System.out.println("删除结果:" + item.delete());
                    }
                    else{
                        System.out.println("放弃删除");
                    }
                }
            } else if (item.isDirectory()) {
                //进入下一层文件夹
                delFile(item, delFileName);
            }
        }
    }

    private static boolean MenuHelp(File item) {
        boolean ret = false;
        try {
            System.out.println("确认要删除文件" + item.getCanonicalPath() + "吗？(Y/N)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if (choice.equals("Y") || choice.equals("y")) {
                ret = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}