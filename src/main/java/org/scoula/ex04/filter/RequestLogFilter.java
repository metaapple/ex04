package org.scoula.ex04.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestLogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("RequestLogFilter 필터 초기화");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filter) throws IOException, ServletException {

        System.out.println("2.-------------------");
        HttpServletRequest req = (HttpServletRequest) request;
        //요청 주소 추출하기
        String uri = req.getRequestURI();
        System.out.println("[요청 URL] " + uri + " " + req.getParameter("addr"));

        //다음 필터 있으면 다음 필터 호출, 마지막 필터인 경우 서블릿의 메서드를 호출함.
        filter.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("RequestLogFilter 종료");
    }
}
