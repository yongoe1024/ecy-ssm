package com.yongoe.ecy.config.security;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域
 */
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("跨域设置已开启！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 允许跨域
        // 转换响应对象
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        // 响应对象设置跨域
        // 设置允许跨域的ip
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        // 设置允许的请求头
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        // 设置凭证
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        // 设置允许的方法
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,DELETE,PUT");
        // 执行过滤
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
