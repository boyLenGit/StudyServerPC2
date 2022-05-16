package len.cloud02.blog;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

public class AspectTest01 {

}

@Aspect
@Component
class LoggingAdvice{
    private Logger logger = (Logger) LoggerFactory.getLogger(LoggingAdvice.class);

    // 注意: ProceedingJointPoint只能用于环绕通知，因为ProceedingJointPoint暴露了proceed方法
    @Around("myPointcut()") // 环绕通知。myPointcut()是我自己定义的切点
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable{
        // 下面部分用于获取方法名、获取类名、获取传递的参数
        String methodName1 = pjp.getSignature().getName();
        String className1 = pjp.getTarget().getClass().toString();
        ObjectMapper objectMapper1 = new ObjectMapper();
        Object[] array1 = pjp.getArgs();
        // 打印调用前方法的信息，这里可以在方法执行前进行相关的逻辑处理
        logger.info("调用前"+className1+":"+methodName1+" args="+objectMapper1.writeValueAsString(array1));
        // 运行方法本体
        Object obj1 = pjp.proceed();
        // 打印调用后方法的信息，这里可以在方法执行后进行相关的逻辑处理
        logger.info("调用后"+className1+":"+methodName1+" 返回="+objectMapper1.writeValueAsString(obj1));
        return obj1;
    }

    @Pointcut(value = "execution( * len.cloud02.blog.web.IndexController.*.*(..) )")
    public void myPointcut(){

    }
}


