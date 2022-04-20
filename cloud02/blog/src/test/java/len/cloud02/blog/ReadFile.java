package len.cloud02.blog;

import com.alibaba.fastjson.JSON;
import org.aspectj.util.FileUtil;
import org.mockito.internal.configuration.plugins.Plugins;

import java.io.File;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        readXML();
    }

    public static void readXML() throws IOException {
        File xmlFile = new File("/Users/mabolun/Project/Java/cloud02/blog/src/test/java/len/cloud02/blog/ReadFile_json.config");
        String config = FileUtil.readAsString(xmlFile);
        Plugins plugins = JSON.parseObject(config, Plugins.class);
        System.out.println(plugins);
    }
}
