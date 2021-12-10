package len.cloud01.cluster;

import len.cloud01.artifact.service.cluster.connect.LinuxService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LinuxConnect {
    @Test
    public void test_types_iter() throws IOException {
        LinuxService linuxService = new LinuxService();
        System.out.println(linuxService.executeCommand("172.19.144.52", "cloud", "123", "whoami"));
    }
}
