package len.cloud02.blog;

import len.cloud02.blog.po.cluster.ServerStateDynamic;
import len.cloud02.blog.service.cluster2.ClusterServerImpl;
import len.cloud02.blog.util.cluster.LinuxMemoryUtil;
import org.junit.Test;

public class testCommandService {
    private String server_ip = "124.221.110.115";
    private String server_username = "lenguest";
    private String server_password = "lenguest";
    private ClusterServerImpl clusterServer;

    public static void main(String[] args) {
        testCommand05();
    }


    public static void testCommand01(){
        String server_ip = "124.221.110.115";
        String server_username = "lenguest";
        String server_password = "lenguest";
        String command = "free -m";
        ClusterServerImpl clusterServer = new ClusterServerImpl();
        String result = clusterServer.commandWithResponse(server_ip, server_username, server_password, command);
        System.out.println(result);
    }

    public static void testCommand02(){
        String server_ip = "172.19.144.52";
        String server_username = "cloud";
        String server_password = "123";
        String command = "free -m";
        ClusterServerImpl clusterServer = new ClusterServerImpl();
        String result = clusterServer.commandWithResponse(server_ip, server_username, server_password, command);
        System.out.println(result);
    }

    public static void testCommand03(){
        String server_ip = "124.221.110.115";
        String server_username = "mbl";
        String server_password = "6886526";
        String command = "free -m";
        ClusterServerImpl clusterServer = new ClusterServerImpl();
        String result = clusterServer.commandWithResponse(server_ip, server_username, server_password, command);
        System.out.println(result);
    }

    public static void testCommand04(){
        String server_ip = "39.103.160.64";
        String server_username = "mbl";
        String server_password = "0000";
        String command = "free -m";
        ServerStateDynamic serverStateDynamic = new ServerStateDynamic();
        ClusterServerImpl clusterServer = new ClusterServerImpl();
        String result = clusterServer.commandWithResponse(server_ip, server_username, server_password, command);
        serverStateDynamic = LinuxMemoryUtil.shellMemoryInfoConvert(serverStateDynamic, result);
        System.out.println(serverStateDynamic.toString());
    }

    public static void testCommand05(){
        String server_ip = "39.103.160.64";
        String server_username = "lenguest";
        String server_password = "boylen.com";
        String command = "free -m";
        ServerStateDynamic serverStateDynamic = new ServerStateDynamic();
        ClusterServerImpl clusterServer = new ClusterServerImpl();
        String result = clusterServer.commandWithResponse(server_ip, server_username, server_password, command);
        System.out.println(result);
        serverStateDynamic = LinuxMemoryUtil.shellMemoryInfoConvert(serverStateDynamic, result);
        System.out.println(serverStateDynamic.toString());
    }
}
