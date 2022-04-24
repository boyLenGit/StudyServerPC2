package len.cloud02.blog;

import com.alibaba.fastjson.JSON;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        readXML();
    }

    public static void readXML() throws IOException {
        // 读取JSON
        File xmlFile = new File("/Users/mabolun/Project/Java/cloud02/blog/src/test/java/len/cloud02/blog/ReadFile_json.config");
        String config = FileUtil.readAsString(xmlFile);
        Person_read person = JSON.parseObject(config, Person_read.class);
        System.out.println(person.toString());
        // 写入JSON
        person.setName("卷王2号");
        String json_write = JSON.toJSONString(person);
        FileUtil.writeAsString(xmlFile, json_write);
    }

    public static class Person_read{
        private String name;
        private int age;

        public Person_read(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
