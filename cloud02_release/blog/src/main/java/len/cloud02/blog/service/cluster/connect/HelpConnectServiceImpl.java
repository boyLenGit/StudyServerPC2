package len.cloud02.blog.service.cluster.connect;

import com.trilead.ssh2.Connection;

import java.io.Closeable;

//Like: IConnectable.java
public interface HelpConnectServiceImpl extends Closeable{
    public Connection getConnection();
    public String getPassword();
    public String getUrl();
    public String getUser();
}
