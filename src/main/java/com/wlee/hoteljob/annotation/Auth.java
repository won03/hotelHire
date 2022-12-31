package com.wlee.hoteljob.annotation;

import java.lang.annotation.*;

@Documented

//@Retention은 어노테이션이 적용될범위로 어떤 시점까지 어노테이션이 영향을 미치는지 결정한다
//-Class: 어노테이션 작성시 기본값으로 클래스 파일에 포함되지만 JVM이 로드하지않는다
//-Runtime: 클래스 파일에 포함되고, JVM이 로드해서 리플렉션 API로 참조 가능하다
//-Source: 컴파일 때만 사용되고, 클래스 파일에 포함되지않는다.
@Retention(RetentionPolicy.RUNTIME)

//@Target은 어노테이션이 적용되는 위치를 의미
@Target({ElementType.TYPE, ElementType.METHOD})

//@interface 를 붙여 선언하고 적용될 대상과 동작 방식을 지정할수있다.
public @interface Auth {
}
