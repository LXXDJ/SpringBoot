package com.ohgiraffers.chap00autoconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Configuration
public class SpringConfiguration {
    // 우선순위 : 환경변수 > properties 파일 > yml 파일

    @Value("${test.value}")
    public String value;

    @Value("${test.list}")
    public List<String> list;       // 배열1

    @Value("${test.greeting}")
    private String greeting;

    @Value("${test.array}")
//    private String[] arr;           // 배열2
    private Set<String> arr;        // 배열3
    
    @Value("${username}")
    private String username;

    @Bean
    public Object propertyReadTest(){
        System.out.println("value : " + value);

        for(String i : list) System.out.println(i);

        System.out.println("greeting = " + greeting);

//        for(String a : arr) System.out.println(a);
        Iterator<String> iter = arr.iterator();
        while(iter.hasNext()) System.out.println(iter.next());

        System.out.println("username = " + username);

        return new Object();
    }
}
