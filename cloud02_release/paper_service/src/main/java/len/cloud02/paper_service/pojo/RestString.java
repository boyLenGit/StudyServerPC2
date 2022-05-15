package len.cloud02.paper_service.pojo;

import lombok.Data;

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
