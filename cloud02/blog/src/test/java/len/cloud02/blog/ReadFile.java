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
        Person person = JSON.parseObject(config, Person.class);

        System.out.println(person);
    }

    class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
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
