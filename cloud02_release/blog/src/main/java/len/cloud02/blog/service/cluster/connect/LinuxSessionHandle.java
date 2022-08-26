package len.cloud02.blog.service.cluster.connect;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.Session;
import com.trilead.ssh2.StreamGobbler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class LinuxSessionHandle implements LinuxSessionHandleImpl, Closeable {
    Logger logger = LoggerFactory.getLogger(LinuxSessionHandle.class);
    private Session session;  // session.cn.stdoutBuffer中存储了执行命令的返回内容，如果要查看

    /**
     * open session then execute commands on remote server and return the result of it
     * @param command
     * @return String
     * @throws IOException
     */
    public  String executeCommand(Connection conn, String command) throws IOException {
        String str="";
        try {
            session = conn.openSession();
            session.execCommand(command);
            str = this.read().toString();
        } catch (Exception e) {
            session.ping();
            throw new IOException("session exception",e);
        }
        finally{
            close();
        }
        //session.close();  // boyLenChange
        return str;
    }

    /**
     * read the result of remote server execute commands
     * @return
     * @throws IOException
     */
    private StringBuffer read() throws IOException{
        InputStream stdout = new StreamGobbler(session.getStdout());
        BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
        String tempString = null;
        // readLine()每次调用都默认会读一行
        StringBuffer str = new StringBuffer();
        while ((tempString = br.readLine()) != null) {
            str.append(tempString+"\r\n");
        }
        br.close();
        return str;
    }

    /**
     * close session
     */
    @Override
    public void close() throws IOException {
        if (this.session != null) this.session.close();
    }

}
