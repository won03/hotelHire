package com.wlee.hoteljob.interceptor;

import com.wlee.hoteljob.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    // controller로 보내기 전에 처리하는 인터셉터
    // 반환이 false라면 controller로 요청을 안함
    // 매개변수 Object는 핸들러 정보를 의미한다. ( RequestMapping , DefaultServletHandler )
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        //uri QueryParam 셋팅
        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                        .query(request.getQueryString())
                                .build()
                                        .toUri();
        log.info("request url : {}", url);

        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation : {}", hasAnnotation);
        // 나의 서버는 모두 public으로 동작을 하는데
        //@Auth 권한을 가진 요청에 대해서는 세션, 쿠키, Param에서 검증
        if (hasAnnotation) {
            //권한체크, 검증하기위해 쿼리 찾기
            String query = uri.getQuery();

            log.info(query);
            //이름이 steve인 쿼리 파람만 권한이 있기때문에 가능
            if (query.equals("name=lee")){
                return true;
            }
            throw new AuthException();

        }
        return true;
    }

    // controller의 handler가 끝나면 처리됨
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }

    //checkAnnotation
    //특정 조건이 만족하면 Pass를 하고 만약에 조건에 만족하지 못하면 Block을 해라
    private boolean checkAnnotation(Object handler, Class clazz){
        // resource (Java script 파일이라던지 html 파일 등)
        if (handler instanceof ResourceHttpRequestHandler){
            return true;
        }
        // annotation check
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (null != handlerMethod.getMethodAnnotation(clazz) || null !=handlerMethod.getBeanType().getAnnotation(clazz)) {
            // Auth annotation이 있을 때는 true
            return true;
        }
        return false;
    }
}
