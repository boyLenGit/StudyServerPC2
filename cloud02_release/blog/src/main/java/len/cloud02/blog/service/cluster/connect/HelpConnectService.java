package len.cloud02.blog.service.cluster.connect;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.ConnectionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

// 1.云平台做4个数据库相关模块与2个绘图模块
// 2.为汇报做准备，画了很多图
// 3.写了云平台SDK文档
// Like: LinuxConnection.java

public class HelpConnectService implements HelpConnectServiceImpl, Closeable {
    Logger log = LoggerFactory.getLogger(this.getClass());
    private String url, user, password;
    private Connection connection;

    /**
     * init server's connect
     *
     * @param url
     * @param user
     * @param password
     * @throws IOException
     */
    public HelpConnectService(String url, String user, String password) throws IOException{
        this.url = url;
        this.user = user;
        this.password = password;
        this.connection = createConnection();
    }

    /**
     * this method will establish connection unless username or password
     * incorrect and remote server is not find
     *
     * @return connection
     * @throws IOException
     */
    private Connection createConnection() throws IOException {
        connection = new Connection(url);
        ConnectionInfo info = connection.connect(); // establish connection
        if (false == connection.authenticateWithPassword(user, password)){
            log.error("connect server failed,please check the username and password. " + this.user + " " + this.password);
            throw new IllegalArgumentException("connection remote server fail");
        }
        return connection;
    }

    /**
     * close connection
     */
    @Override
    public void close() throws IOException {
        if (connection != null)
            this.connection.close();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
