package len.cloud02.paper_service.util;

import java.io.File;
import java.io.IOException;

public class LenFile {
    public static void deleteFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()){
            return;
        }else file.delete();
    }
}
