package len.cloud02.blog;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.SFTPv3Client;
import com.trilead.ssh2.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SSH2 {
    public static void main(String[] args) {
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
            for (int i1=0; i1<3; i1++){
                String line = bufferedReader.readLine();
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
