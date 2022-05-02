package len.cloud02.blog;

import com.trilead.ssh2.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class SSH2 {
    public static void main(String[] args) {
//        command();
        file_test();
    }

    public static void command_test(){
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
            client.close();
            connection.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void file_test(){
        Connection connection = new Connection("172.19.144.52");
        try {
            connection.connect();
        }catch (IOException exception){
            exception.printStackTrace();
        }

        try {
            connection.authenticateWithPassword("cloud", "123");
            Session session = connection.openSession();
            SCPClient scpClient = connection.createSCPClient();
            SFTPv3Client client = new SFTPv3Client(connection);
            scpClient.put("/Volumes/nvme/nvmeDownload/shuliehe.zip","/home/cloud/Users/mbl/data");
            Vector<SFTPv3DirectoryEntry> files = client.ls("/home/cloud/Users/mbl/data");
            for (SFTPv3DirectoryEntry item: files){
                System.out.println(item.filename);
            }
            client.close();
            connection.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
