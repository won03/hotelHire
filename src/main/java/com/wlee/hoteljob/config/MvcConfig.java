package com.wlee.hoteljob.config;

import com.wlee.hoteljob.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {
    private final AuthInterceptor authInterceptor;
    //특정 URL에만 Interceptor적용 가능
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //이건 전체 영역
        //registry.addInterceptor(authInterceptor);

        //이건 특정 URL (/api/private/* ->  api에 private에 속한 모든 URL 인터셉터 처리)
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");
    }
}
