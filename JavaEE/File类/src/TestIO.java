import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestIO {
    public static void main(String[] args) {
        //调用完try后会自动释放文件资源
        try (InputStream inputStream = new FileInputStream("./src/Test.txt")) {
            while (true) {
                int n = inputStream.read();
                if (n == -1) {
                    break;
                }
                System.out.println((char) n);
            }
        } catch (IOException msg) {
            msg.printStackTrace();
        }
    }
}
