import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoSever {
    //创建socket实例
    private DatagramSocket socket = null;

    //服务器这里的端口需要绑定端口号
    public UdpEchoSever(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

}
