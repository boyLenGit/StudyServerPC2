package len.cloud01.artifact;

import len.cloud01.artifact.po.Type;
import len.cloud01.artifact.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ArtifactApplicationTests {

    @Autowired
    private TypeService typeService;

    @Test
    void test_types_iter() {
        List<Type> types = typeService.listType();
        for(Type type: types){
            System.out.println(type + "  ||  " + type.getName());
            System.out.println();
        }
    }

}
