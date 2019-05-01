package com.example.demo.config;

import com.example.demo.dto.MyAutoWiredObject;
import com.example.demo.service.RestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfiguration {



    @Bean
    MyAutoWiredObject getObjectAsBean(){
       return new MyAutoWiredObject("1","Test");


    }
}
