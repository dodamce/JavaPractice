package Sever;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

class UdpSever {
    //创建socket实例
    private DatagramSocket socket = null;

    //服务器这里的端口需要绑定端口号
    public UdpSever(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    //启动服务器
    public void Start() throws IOException {
        System.out.println("INFO:服务正在启动中");
        while (true) {
            //读取客户端发来请求,缓冲区最大位1024
            DatagramPacket quest_packet = new DatagramPacket(new byte[1024], 1024);
            //receive方法是阻塞的
            socket.receive(quest_packet);

            System.out.printf("INFO:获取客户端成功\n客户端IP:%s\t客户端端口:%d", quest_packet.getAddress().toString(),
                    quest_packet.getPort());

            //解析packet,获取客户端请求
            String request = new String(quest_packet.getData(), 0, quest_packet.getLength(), "utf-8");

            //构建响应报文
            String response = process(request);

            //响应发送到客户端，指定将数据发送客户端位置
            DatagramPacket response_Packet = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    quest_packet.getSocketAddress());
            socket.send(response_Packet);
        }
    }

    //回显服务器，响应报文和请求相同
    public String process(String request) {
        return request;
    }
}

public class UdpEchoSever {
    public static void main(String[] args) throws IOException {
        UdpSever sever = new UdpSever(8080);
        sever.Start();
    }
}