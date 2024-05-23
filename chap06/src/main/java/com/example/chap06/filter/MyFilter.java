package com.example.chap06.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("웹서버 실행시 나옴");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("들렸다가 감");
        // 계속 그 다음 페이지 요청하는거 진행
        filterChain.doFilter(servletRequest,servletResponse); // 무조건 쓰는거
    }

    @Override
    public void destroy() {
        System.out.println("웹서버 종료시 나옴");
    }
}
