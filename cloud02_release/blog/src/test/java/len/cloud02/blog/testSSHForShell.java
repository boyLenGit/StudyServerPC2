package len.cloud02.blog;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.SFTPv3Client;
import com.trilead.ssh2.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class testSSHForShell {
    private String host = "172.19.144.52";
    private String port = "22";
    private String name = "cloud";
    private String password = "123";

    public static void main(String[] args) {
        testShell01();
    }

    public static void testShell01(){
        Connection connection = new Connection("172.19.144.52");
        Scanner scanner = new Scanner(System.in);

        try {
            connection.connect();
        }catch (IOException exception){
            exception.printStackTrace();
        }

        try {
            connection.authenticateWithPassword("cloud", "123");
            SFTPv3Client client = new SFTPv3Client(connection);
            while (scanner.hasNext()){
                Session session = connection.openSession();
                String command = scanner.nextLine();
                System.out.println("Command：" + command);
                session.execCommand(command);
                InputStream inputStream = session.getStdout();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String read_temp;
                while (true){
                    read_temp = bufferedReader.readLine();
                    if (read_temp==null) break;
                    System.out.println(read_temp);
                }
                session.close();
            }
            client.close();
            connection.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
