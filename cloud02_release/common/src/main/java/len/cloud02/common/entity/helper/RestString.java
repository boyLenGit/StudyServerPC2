package len.cloud02.common.entity.helper;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class RestString {
    private String string1;

    public RestString() {
    }

    public RestString(String string1) {
        this.string1 = string1;
    }

    //    public String getString1() {
//        return string1;
//    }
//
//    public void setString1(String string1) {
//        this.string1 = string1;
//    }
//
//    @Override
//    public String toString() {
//        return "RestString{" +
//                "string1='" + string1 + '\'' +
//                '}';
//    }
}
