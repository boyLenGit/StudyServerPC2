package len.cloud02.blog.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @Component  // ←如果拦截失效，尝试将@Component取消注解
public class LoginInterceptor implements HandlerInterceptor {
    @Override   // ↓ 在请求之前进行预处理
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("user")==null){
            // 如果user为空，则用户未登录，则直接无条件跳转到登录页面".../admin"
            response.sendRedirect("/admin");
            return false;
        }
        // ↓ true是继续同行的意思
        return true;
    }
}