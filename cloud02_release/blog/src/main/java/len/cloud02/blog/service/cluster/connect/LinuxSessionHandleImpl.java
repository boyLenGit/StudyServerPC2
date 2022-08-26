package len.cloud02.blog.service.cluster.connect;

import com.trilead.ssh2.Connection;

import java.io.IOException;

public interface LinuxSessionHandleImpl {
    public String executeCommand(Connection conn, String command) throws IOException;

}
