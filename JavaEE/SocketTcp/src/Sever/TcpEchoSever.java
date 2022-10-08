package Sever;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoSever {
    private ServerSocket listenSocket = null;

    public TcpEchoSever(int port) throws IOException {
        listenSocket = new ServerSocket(port);
    }

    public void Start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService pool = Executors.newCachedThreadPool();
        while (true) {
            //接受客户端链接
            Socket socket = listenSocket.accept();
//            DelConnection(socket);
//            //多线程创建新线程
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        DelConnection(socket);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            thread.start();

            //线程池解决
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        DelConnection(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void DelConnection(Socket socket) throws IOException {
        System.out.printf("[get client:%s,%d]", socket.getInetAddress().toString(), socket.getPort());

        //处理请求与响应
        try (InputStream inputStream = socket.getInputStream()) {
            try (OutputStream outputStream = socket.getOutputStream()) {
                Scanner scanner = new Scanner(inputStream);
                while (true) {
                    if (!scanner.hasNext()) {
                        System.out.printf("%s,%d 客户端断开连接", socket.getInetAddress().toString(), socket.getPort());
                        break;
                    }
                    String request = scanner.next();

                    //构造响应
                    String response = MakeResponse(request);

                    //返回客户端,写入到socket的输入流中
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(response);
                    printWriter.flush();

                    System.out.printf("回复%s %d客户端成功", socket.getInetAddress().toString(), socket.getPort());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }

    private String MakeResponse(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoSever sever = new TcpEchoSever(8082);
        sever.Start();
    }
}
