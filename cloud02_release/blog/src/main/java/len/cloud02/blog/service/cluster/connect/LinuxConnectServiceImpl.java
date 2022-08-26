package len.cloud02.blog.service.cluster.connect;

import java.io.IOException;

// Like: IConnectionPool.java
public interface LinuxConnectServiceImpl {
    public Boolean saveObject(HelpConnectServiceImpl conn);

    /**
     * borrow connection object in the connect-pool
     *
     * @param key
     * @return
     */
    public HelpConnectServiceImpl borrowObject(String key);
    /**borrow connection object in the connect-pool
     * if the connection hasn't in the connectionPool return null,else return connect object
     *
     * @param conn
     * @return
     */
    public HelpConnectServiceImpl borrowObject(HelpConnectServiceImpl conn);


    /**
     * close single connection in the connection-pool and  close/release of this connection
     * @param conn
     * @throws IOException
     */
    public void remove(HelpConnectServiceImpl conn) throws IOException;
    public void remove(String key) throws IOException;

    /**
     * delete every connection in the connection-pool and also close/release of all connection
     * @throws IOException
     */
    public void clear() throws IOException;
}
