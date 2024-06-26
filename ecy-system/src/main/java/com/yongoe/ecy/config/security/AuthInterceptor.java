package com.yongoe.ecy.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yongoe.ecy.config.aop.IgnoreAuth;
import com.yongoe.ecy.config.aop.IgnoreLogin;
import com.yongoe.ecy.system.entity.Menu;
import com.yongoe.ecy.system.entity.Role;
import com.yongoe.ecy.system.entity.User;
import com.yongoe.ecy.system.service.MenuService;
import com.yongoe.ecy.utils.R;
import com.yongoe.ecy.utils.UserThreadLocal;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 权限拦截器
 *
 * @author yongoe
 * @since 2023/1/1
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Resource
    private MenuService menuService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        IgnoreLogin ignoreLogin;
        IgnoreAuth ignoreAuth;
        if (handler instanceof HandlerMethod) {
            ignoreLogin = ((HandlerMethod) handler).getMethodAnnotation(IgnoreLogin.class);
            ignoreAuth = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
            if (ignoreLogin != null || ignoreAuth != null) {
                return true;
            }
        } else {
            return true;
        }
        User user = UserThreadLocal.get();
        // 管理员全部放行
        for (Role role : user.getRoleList()) {
            if (role.getId().equals(1L))
                return true;
        }
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        String requestURI = request.getRequestURI();
        for (Menu menu : menuService.list()) {
            // 查找 与请求路径匹配的菜单数据
            if (!StringUtils.isEmpty(menu.getUrl()) && antPathMatcher.match(menu.getUrl(), requestURI)) {
                // 返回 该菜单的 所需的权限
                List<Long> roleIds = menuService.getRoleIdsByMenuId(menu.getId());
                for (Long id : roleIds) {
                    for (Role userRole : user.getRoleList()) {
                        if (id.equals(userRole.getId()))
                            return true;
                    }
                }
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json");
                PrintWriter writer = response.getWriter();
                R error = R.error(403, "[" + menu.getName() + "]权限不足，请联系管理员！");
                writer.write(new ObjectMapper().writeValueAsString(error));
                writer.flush();
                writer.close();
                return false;
            }
        }
        //没有匹配的，就放行
        return true;

    }

    //防止内存溢出
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserThreadLocal.remove();
    }
}