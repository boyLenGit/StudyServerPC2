package len.cloud02.blog.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect  // 用于进行切面的操作
@Component // 它的作用就是实现bean的注入，相当于<bean class="">  ！Aspect出现时要搭配Component才可以
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* len.cloud02.blog.test.*.*(..))") //切入点表达式。表示len.cloud01.artifact下所有类中所有方法都拦截掉。第一个*是指返回值。execution中内容规范：返回值类型 包名.类名.方法名(参数）
    public void entry_point(){
        // 定义了切入点
    }

    // 在方法entry_point()执前进行拦截
    @Before("entry_point()")
    public void doBefore(JoinPoint joinPoint){  // JoinPoint对象封装了SpringAop中切面方法的信息,在切面方法中添加JoinPoint参数,就可以获取到封装了该方法信息的JoinPoint对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("--------doBefore-------- || Request param:{}", requestLog);
    }

    // 在方法entry_point()执行后进行拦截
    @After("entry_point()")
    public void doAfter(){
        logger.info("--------doAfter--------");
    }

    // 在方法entry_point()执行完，返回return之后进行拦截
    @AfterReturning(returning = "result",pointcut = "entry_point()")
    public void doAfterRuturn(Object result) {
        logger.info("--------AfterReturning-------- || Result : {}", result);
    }

    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
