//package com.wlee.hoteljob.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.util.ContentCachingRequestWrapper;
//import org.springframework.web.util.ContentCachingResponseWrapper;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//===============================================================전체 영역을 필터로하는부분임 ============================================================
//@Slf4j
//@Component
//public class GlobalFilterEx implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        // 우선 필터를 통해 HttpServletResponse, HttpServletRequest 클래스로 들어온 request와 response를 ContentCachingRequestWrapper와 ContentCachingResponseWrapper로 래핑해주어야 한다.
//        // HttpServletRequest 그대로 request.getReader 함수를 호출하거나 안에 있는 데이터를 읽으려고 하면, 단 한번만 읽을 수 있도록 톰캣에서 만들어두었기 때문에 이걸 다시 읽을 수 있는 클래스로 래핑해주어야 하기 때문이다.
//        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
//        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);
//
//        //생성시에는 read를 하지않고 길이만 초기화를 시켜준다
////        //요청 값을 받음
////        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
////        //응답 값을 받음
////        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//
//        //전처리
//
//        chain.doFilter(httpServletRequest,httpServletResponse);
//        //doFilter가 실행되면서 실내 내부 Spring 들어가서야 writeToCache메소드가 실행이 되서 rquest의 내용이 content에담겨 읽을수 있게된다
//        //그렇기에 데이터 사용 및 log는 doFilter 이후 처리
//
//        //후처리
//        //req
//        String url = httpServletRequest.getRequestURI();
//        String reqContent = new String(httpServletRequest.getContentAsByteArray());
//
//        log.info("request url: {}, request body: {}", url, reqContent);
//
//        String resContent = new String(httpServletResponse.getContentAsByteArray());
//        int httpStatus = httpServletResponse.getStatus();
//
//        //copyBodyToResponse해주지 안으면 그전 필터 후처리후 이미 데이터를 읽었기 때문에 데이터가 없어진다 그래서 response 데이터가 빈값이여서 후처리한 데이터를 복사해서 응답처리를 해준다
//        httpServletResponse.copyBodyToResponse();
//
//        log.info("response status: {}, response body: {}", httpStatus, resContent);
//
//    }
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
