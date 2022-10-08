package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;

    TcpEchoClient(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
    }

    public void Start() {
        System.out.println("和服务器成功建立链接");
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream()) {
            try (OutputStream outputStream = socket.getOutputStream()) {
                while (true) {
                    System.out.print("client#");
                    String request = scanner.next();
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(request);
                    printWriter.flush();

                    //读取服务器响应
                    Scanner read = new Scanner(inputStream);
                    String response = read.next();

                    System.out.println("Sever 响应" + response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 8082);
        client.Start();
    }
}
