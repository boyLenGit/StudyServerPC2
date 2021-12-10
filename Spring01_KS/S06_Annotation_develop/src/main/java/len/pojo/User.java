<<<<<<< HEAD
package len.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // 配置作用域，prototype是多作用域，还有singleton
public class User {
    //相当于 <property name="name" value="狂神"></property>

    @Value("狂神")
    public String name;
}
=======
package len.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // 配置作用域，prototype是多作用域，还有singleton
public class User {
    //相当于 <property name="name" value="狂神"></property>

    @Value("狂神")
    public String name;
}
>>>>>>> 1da3f48 (first commit)
