package len.cloud02.blog.service.cluster.connect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LinuxService {

    private  String defaultTopComand = "top -b -n 1";
    private  String defaultMpstatComand = "mpstat 1 1";//"mpstat -P ALL"
    private  String defaultFreeCommand = "free -m";
    private  String defaultIostatCommand = "iostat -d 1 2";
    private  String defaultIostatCommand_x = "iostat -d -x 1 2";
    private  String defaultConections = "netstat -an|grep 9080|grep -c EST";
    @Autowired
    private LinuxConnectService pool ;
    @Autowired
    private LinuxSessionHandle handle;

    /**
     * execute default command "top -b -n 1" and return String type reslut
     *
     * @param url  server's ip
     * @param user  login name
     * @param password login password
     * @return
     * @throws IOException
     */
    public String topMonitor(String url,String user,String password) throws IOException{
        return this.executeCommand(url, user, password, defaultTopComand);
    }

    /**
     * execute default command "mpstat -P ALL" to get cpus performance
     *
     * @param url
     * @param user
     * @param password
     * @return
     * @throws IOException
     */
    public String cpuMonitor(String url,String user,String password) throws IOException{
        return this.executeCommand(url, user, password, defaultMpstatComand);
    }

    /**
     * execute default command "free -m" to get memory performance
     * @param url
     * @param user
     * @param password
     * @return
     * @throws IOException
     */
    public String memoryMonitor(String url,String user,String password) throws IOException{
        return this.executeCommand(url, user, password, defaultFreeCommand);
    }

    /**
     * execute default command "iostat -d" to get memory performance
     * @param url
     * @param user
     * @param password
     * @return
     * @throws IOException
     */
    public String inputOutputMonitor(String url,String user,String password) throws IOException{
        return this.executeCommand(url, user, password, defaultIostatCommand);
    }

    /**
     * execute default command "iostat -d - x" to get memory performance
     * @param url
     * @param user
     * @param password
     * @return
     * @throws IOException
     */
    public String inputOutputMonitor_x(String url,String user,String password) throws IOException{
        return this.executeCommand(url, user, password, defaultIostatCommand_x);
    }

    /**
     * "netstat -an|grep 9080|grep -c EST";
     * @param url
     * @param user
     * @param password
     * @return
     * @throws IOException
     */
    public String inputConections(String url,String user,String password) throws IOException{
        return this.executeCommand(url, user, password, defaultConections);
    }


    public String executeCommand(String url,String user,String password,String command) throws IOException{
        HelpConnectServiceImpl lc =  pool.borrowObject(url,user,password);
        return handle.executeCommand(lc.getConnection(),command);
    }

}
