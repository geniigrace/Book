package org.mega.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 어노테이션이 생성될수 있는 위치를 지정, 파라미터(매개변수) 로 지정하면 파라미터 선언 객체만 사용 가능
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 클래스로 지정, LoginUser라는 이름 가진 어노테이션 생성
public @interface LoginUser {
}
