package Sever;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class DictUdp extends UdpSever {

    private final HashMap<String, String> hashMap = new HashMap<>();

    public DictUdp(int port) throws SocketException {
        super(port);
        hashMap.put("cat", "猫");
        hashMap.put("dog", "狗");
        hashMap.put("pig", "猪");
    }

    @Override
    public String process(String request) {
        return hashMap.getOrDefault(request, "收录的数据中没有找到这个单词");
    }

    public static void main(String[] args) throws IOException {
        DictUdp dictUdp = new DictUdp(8080);
        dictUdp.Start();
    }
}
