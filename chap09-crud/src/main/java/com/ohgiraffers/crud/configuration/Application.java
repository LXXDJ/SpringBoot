package com.ohgiraffers.crud.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ohgiraffers.crud")	// 실행 클래스의 위치가 기본 패키지에서 벗어나게 되면 ComponentScan의 영역이 달라지므로 명시 필수
@MapperScan(basePackages = "com.ohgiraffers.crud", annotationClass = Mapper.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
