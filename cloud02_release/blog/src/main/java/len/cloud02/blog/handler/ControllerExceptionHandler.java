package len.cloud02.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice  // 它会拦截所有带注解“@Controller”的类，如之前写的web上的index
public class ControllerExceptionHandler {

    private final Logger logger1 = LoggerFactory.getLogger(this.getClass()); // 用于存储捕获的log

    @ExceptionHandler(Exception.class)  // 如果带有Controller的类中出现了错误，且错误类型是Exception，则会跳转到exceptionHandler这个方法中，此时会传递两个参数request、exception
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        logger1.error("Len logger || Request URL:{}, Exception Msg:{}, Exception:{}", request.getRequestURL(), exception.getMessage(), exception);

        // 用于throw指定跳转的定制化错误Log（或许定制化错误网页也可以）
        if (AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class) != null) {
            throw exception;
        }
        // 用于跳转到通用的error错误网页
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.addObject("exception", exception);
        modelAndView.setViewName("error/error");  // 设置返回的页面
        return modelAndView;
    }
    // ~ 没有用ControllerAdvice+ExceptionHandler，若出现后端内部错误，会跳转到“500错误”；用的话则跳转到指定的“error错误”
    // ~ 无论是否用ControllerAdvice+ExceptionHandler，地址错误无该地址，都会跳转到“404错误”
}
