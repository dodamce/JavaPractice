package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

class UdpClient {
    private final DatagramSocket socket;

    private final String _ip;
    private final int _port;

    public UdpClient(String ip, int port) throws SocketException {
        socket = new DatagramSocket();
        _ip = ip;
        _port = port;
    }

    public void Start() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //读取输入，将输入构造成请求
            System.out.print("client:");
            String request = scanner.next();
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(_ip), _port);

            socket.send(requestPacket);

            //从服务器上获取到了信息
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(responsePacket);

            //解析服务器响应
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength(), "utf-8");

            System.out.println("Sever Response" + response);
        }
    }
}

public class UdpEchoClient {
    public static void main(String[] args) throws IOException {
        UdpClient client = new UdpClient("127.0.0.1", 8080);
        client.Start();
    }
}
