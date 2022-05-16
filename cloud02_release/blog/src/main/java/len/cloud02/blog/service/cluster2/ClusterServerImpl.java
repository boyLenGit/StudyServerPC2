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
                res.append(temp).append("\n");
            }
            client.close();
            connection.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return res.toString();
    }
}
