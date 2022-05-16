package len.cloud02.blog.service.cluster2;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.SFTPv3Client;
import com.trilead.ssh2.Session;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class ClusterServerImpl {
    public String commandWithResponse(String host, String username, String password, String command){
        StringBuilder sb = new StringBuilder();
        Connection connection = new Connection("172.19.144.52");
        try {
            connection.connect();
        }catch (IOException exception){
            exception.printStackTrace();
        }

        try {
            connection.authenticateWithPassword("cloud", "123");
            Session session = connection.openSession();
            SFTPv3Client client = new SFTPv3Client(connection);
            session.execCommand("free -m");
            InputStream inputStream = session.getStdout();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            int lines = (int) bufferedReader.lines().count();
            for (int i1=0; i1<lines; i1++){
                sb.append(bufferedReader.readLine());
            }
            client.close();
            connection.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
