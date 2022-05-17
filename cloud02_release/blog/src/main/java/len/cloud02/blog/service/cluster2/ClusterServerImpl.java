package len.cloud02.blog.service.cluster2;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.SFTPv3Client;
import com.trilead.ssh2.Session;
import len.cloud02.blog.po.cluster.ServerStateDynamic;
import len.cloud02.blog.po.cluster.ServerStateDynamic_vmstat;
import len.cloud02.blog.util.cluster.LinuxMemoryUtil;
import len.cloud02.blog.util.cluster.LinuxStateUtil;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class ClusterServerImpl {
    public String commandWithResponse(String host, String username, String password, String command){
        StringBuilder res = new StringBuilder();
        Connection connection = new Connection(host);
        try {
            connection.connect();
        }catch (IOException exception){
            exception.printStackTrace();
        }

        try {
            connection.authenticateWithPassword(username, password);
            Session session = connection.openSession();
            SFTPv3Client client = new SFTPv3Client(connection);
            session.execCommand(command);
            InputStream inputStream = session.getStdout();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String temp;
            while (true){
                temp = bufferedReader.readLine();
                if (temp==null) break;
                res.append(temp).append("\r\n");
            }
            client.close();
            connection.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return res.toString();
    }

    public Object[] getVmstatAndMem(String host, String username, String password){
        StringBuilder sb_mem = new StringBuilder();
        StringBuilder sb_vm = new StringBuilder();
        Connection connection = new Connection(host);
        try {
            connection.connect();
        }catch (IOException exception){
            exception.printStackTrace();
        }

        try {
            connection.authenticateWithPassword(username, password);
            Session session = connection.openSession();
            SFTPv3Client client = new SFTPv3Client(connection);

            session.execCommand("free -m");
            InputStream inputStream = session.getStdout();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String temp;
            while (true){
                temp = bufferedReader.readLine();
                if (temp==null) break;
                sb_mem.append(temp).append("\r\n");
            }

            session.execCommand("vmstat  1 2 -a");
            BufferedReader bufferedReader_vm = new BufferedReader(new InputStreamReader(session.getStdout()));
            String temp_vm;
            while (true){
                temp_vm = bufferedReader_vm.readLine();
                if (temp_vm==null) break;
                sb_vm.append(temp_vm).append("\r\n");
            }

            client.close();
            connection.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        // 转换
        ServerStateDynamic serverStateDynamic = new ServerStateDynamic();
        serverStateDynamic = LinuxMemoryUtil.shellMemoryInfoConvert(serverStateDynamic, sb_mem.toString());

        System.out.println(sb_vm.toString());
        ServerStateDynamic_vmstat serverStateDynamic_vmstat = new ServerStateDynamic_vmstat();
        serverStateDynamic_vmstat = LinuxStateUtil.shellVmstatConvert(serverStateDynamic_vmstat, sb_vm.toString());
        System.out.println(serverStateDynamic_vmstat.toString());
        return new Object[]{serverStateDynamic, serverStateDynamic_vmstat};
    }
}
